package org.anime_game_servers.game_data_models.processor

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.ksp.kspDependencies
import com.squareup.kotlinpoet.ksp.toClassName
import kotlinx.serialization.KSerializer
import org.anime_game_servers.game_data_models.loader.enums.EnumMetadata
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapper
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry
import org.anime_game_servers.game_data_models.loader.enums.enumContainerSerializer
import kotlin.enums.EnumEntries
import kotlin.reflect.KClass

object EnumMetaDataGenerator {

    data class DataEnumInfoMetadata(
        val className: String,
        val packageName: String,
        val ksClass: KSClassDeclaration,
        val unknownEntry: KSClassDeclaration = ksClass.getUnknownEntry(),
        val noneEntry: KSClassDeclaration? = ksClass.getNoneEntry(),
        val entries: List<KSClassDeclaration> = ksClass.declarations.mapNotNull { it as? KSClassDeclaration }.toList(),
    ) {
        fun getMetadataName(): String {
            return className + "Metadata"
        }
        fun getEnumWrapperSerializerName(): String {
            return className + "ContainerSerializer"
        }
    }

    fun KSClassDeclaration.getUnknownEntry() = this.declarations.mapNotNull{ it as? KSClassDeclaration }
        .filter { it.annotations.any { it.shortName.asString() == UnknownEntry::class.simpleName } }
        .first()
    fun KSClassDeclaration.getNoneEntry() = this.declarations.mapNotNull { it as? KSClassDeclaration }
        .firstOrNull { it.annotations.any { it.shortName.asString() == NoneEntry::class.simpleName } }

    fun createClassesForDataEnum(metaData: DataEnumInfoMetadata, codeGenerator: CodeGenerator){
        createFileForMetaData(metaData, codeGenerator)
        createFileForEnumWrapperSerializer(metaData, codeGenerator)
    }

    fun createFileForMetaData(metaData: DataEnumInfoMetadata, codeGenerator: CodeGenerator){
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

    fun generateClassForMetaData(metaData: DataEnumInfoMetadata) : FileSpec {
        val className = ClassName(metaData.packageName, metaData.getMetadataName())
        val enumType = metaData.ksClass.toClassName()

        val type = TypeSpec.objectBuilder(className)
            .addSuperinterface(
                EnumMetadata::class.asClassName()
                .parameterizedBy(enumType))
            .addProperty(
                PropertySpec.builder(EnumMetadata<*>::unknownEntry.name, enumType, KModifier.OVERRIDE)
                .initializer("%L", metaData.unknownEntry)
                .build())
            .addProperty(
                PropertySpec.builder(EnumMetadata<*>::noneEntry.name, enumType.copy(nullable = true), KModifier.OVERRIDE)
                .initializer("%L", metaData.noneEntry)
                .build())
            .addProperty(
                PropertySpec.builder(EnumMetadata<*>::values.name, EnumEntries::class.asClassName().parameterizedBy(enumType), KModifier.OVERRIDE)
                .initializer("%L", "${metaData.className}.entries")
                .build())
            .addProperty(
                PropertySpec.builder(EnumMetadata<*>::kClass.name,
                    KClass::class.asClassName().parameterizedBy(metaData.ksClass.toClassName()), KModifier.OVERRIDE)
                .initializer("%T::class", metaData.ksClass.toClassName())
                .build())
            .addProperty(
                PropertySpec.builder(EnumMetadata<*>::serializer.name, KSerializer::class.asClassName().parameterizedBy(metaData.ksClass.toClassName()), KModifier.OVERRIDE)
                .initializer("%T.serializer()", metaData.ksClass.toClassName())
                .build())
            .build()
        val file = FileSpec.builder(className).apply {
            indent("    ")
            addType(type)
        }.build()

        return file
    }

    fun createFileForEnumWrapperSerializer(metaData: DataEnumInfoMetadata, codeGenerator: CodeGenerator){
        val fileSpec = generateClassForEnumWrapperSerializer(metaData)
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

    fun generateClassForEnumWrapperSerializer(metaData: DataEnumInfoMetadata) : FileSpec {
        val className = ClassName(metaData.packageName, metaData.getEnumWrapperSerializerName())
        val enumType = metaData.ksClass.toClassName()
        val enumContainerExtension = MemberName("org.anime_game_servers.game_data_models.loader.enums", "enumContainerSerializer", isExtension = true)

        val type = TypeSpec.objectBuilder(className)
            .addSuperinterface(
                KSerializer::class.asClassName()
                .parameterizedBy(EnumWrapper::class.asClassName().parameterizedBy(enumType)),
                CodeBlock.builder()
                    .add(
                        "%M(unknown = %L)",enumContainerExtension,
                        metaData.unknownEntry
                    )
                    .build())
            .build()
        val file = FileSpec.builder(className).apply {
            indent("    ")
            addType(type)
        }.build()

        return file
    }
}