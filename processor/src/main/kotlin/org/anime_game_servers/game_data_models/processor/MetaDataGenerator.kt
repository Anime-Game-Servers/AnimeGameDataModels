package org.anime_game_servers.game_data_models.processor

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.ksp.kspDependencies
import com.squareup.kotlinpoet.ksp.toClassName
import kotlinx.serialization.KSerializer
import org.anime_game_servers.game_data_models.loader.DataClassInfo
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType
import org.anime_game_servers.game_data_models.processor.DataProcessor.DataClassInfoMetadata
import kotlin.reflect.KClass

object MetaDataGenerator {
    fun createFileForMetaData(metaData: DataClassInfoMetadata, codeGenerator: CodeGenerator){
        val fileSpec = generateClassForMetaData(metaData)
        fileSpec.kspDependencies(false)
        codeGenerator.createNewFile(
            // Make sure to associate the generated file with sources to keep/maintain it across incremental builds.
            // Learn more about incremental processing in KSP from the official docs:
            // https://kotlinlang.org/docs/ksp-incremental.html
            dependencies = Dependencies(true, metaData.ksClass.containingFile!!),
            packageName = metaData.packageName,
            fileName = fileSpec.name
        )
            .writer()
            .use {
                fileSpec.writeTo(it)
            }
    }

    fun generateClassForMetaData(metaData: DataClassInfoMetadata) : FileSpec {
        val className = ClassName(metaData.packageName, metaData.getLoaderName())

        val type = TypeSpec.objectBuilder(className)
            .addSuperinterface(
                DataClassInfo::class.asClassName()
                .parameterizedBy(metaData.ksClass.toClassName()))
            .addProperty(
                PropertySpec.builder(DataClassInfo<*>::className.name, String::class, KModifier.OVERRIDE)
                .initializer("%S", metaData.className)
                .build())
            .addProperty(
                PropertySpec.builder(DataClassInfo<*>::packageName.name, String::class, KModifier.OVERRIDE)
                .initializer("%S", metaData.packageName)
                .build())
            .addProperty(
                PropertySpec.builder(DataClassInfo<*>::kClass.name,
                    KClass::class.asClassName().parameterizedBy(metaData.ksClass.toClassName()), KModifier.OVERRIDE)
                .initializer("%T::class", metaData.ksClass.toClassName())
                .build())
            .addProperty(
                PropertySpec.builder(DataClassInfo<*>::fileInfos.name, List::class.parameterizedBy(DataFile::class), KModifier.OVERRIDE)
                .initializer(CodeBlock.builder().apply {
                    add("listOf(\n")
                    indent()
                    metaData.fileInfos.forEach {
                        addStatement(
                            "%T(%S, %T.%L, %T.%L),",
                            DataFile::class,
                            it.filePath,
                            FileType::class,
                            it.fileType,
                            FolderType::class,
                            it.folderType
                        )
                    }
                    unindent()
                    add(")")
                }
                    .build())
                .build())
            .addProperty(
                PropertySpec.builder(DataClassInfo<*>::serializer.name, KSerializer::class.asClassName().parameterizedBy(metaData.ksClass.toClassName()), KModifier.OVERRIDE)
                .initializer("%T.serializer()", metaData.ksClass.toClassName())
                .build())
            .build()
        val file = FileSpec.builder(className).apply {
            indent("    ")
            addType(type)
        }.build()

        return file
    }
}