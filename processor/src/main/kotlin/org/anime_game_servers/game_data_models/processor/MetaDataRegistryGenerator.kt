package org.anime_game_servers.game_data_models.processor

import com.google.devtools.ksp.processing.CodeGenerator
import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.ksp.kspDependencies
import org.anime_game_servers.game_data_models.loader.*
import org.anime_game_servers.game_data_models.processor.DataProcessor.DataClassInfoMetadata

object MetaDataRegistryGenerator {
    val handledModules = mutableSetOf<String>()
    fun createFileForMetaDataRegistry(metaDataList: List<DataClassInfoMetadata>, basePacket: String, module:String, codeGenerator: CodeGenerator){
        // Only generate the file once per module
        if(handledModules.contains(basePacket+module)){
            return
        }

        val fileSpec = generateClassForMetaData(metaDataList, basePacket, module)
        codeGenerator.createNewFile(
            // Make sure to associate the generated file with sources to keep/maintain it across incremental builds.
            // Learn more about incremental processing in KSP from the official docs:
            // https://kotlinlang.org/docs/ksp-incremental.html
            dependencies = fileSpec.kspDependencies(true),
            packageName = basePacket,
            fileName = fileSpec.name
        )
            .writer()
            .use {
                fileSpec.writeTo(it)
            }

        handledModules.add(basePacket+module)
    }

    fun generateClassForMetaData(metaDataList: List<DataClassInfoMetadata>, basePacket: String, module:String) : FileSpec {
        val className = ClassName(basePacket, "${module}ModelRegistry")

        val modelListName = "knownModels"

        val type = TypeSpec.objectBuilder(className)
            .addSuperinterface(DataClassSource::class.asClassName())
            .addProperty(
                PropertySpec.builder(modelListName, List::class.asClassName()
                    .parameterizedBy(DataClassInfo::class.asClassName()
                        .parameterizedBy(STAR)),
                    KModifier.PRIVATE)
                .build())
            .addFunction(FunSpec.builder(DataClassSource::getDataClassInfo.name)
                .addModifiers(KModifier.OVERRIDE)
                .returns(List::class.asClassName()
                    .parameterizedBy(DataClassInfo::class.asClassName()
                        .parameterizedBy(STAR)))
                .addStatement("return $modelListName")
                .build())
            .addInitializerBlock(CodeBlock.builder().apply {
                addStatement("val modelList = mutableListOf(")
                indent()
                metaDataList.forEach {
                    addStatement(
                        "%T,",
                        ClassName(it.packageName, it.getLoaderName()),
                    )
                }
                unindent()
                addStatement(")")
                addStatement("$modelListName = modelList")
            }.build())
            .build()

        val file = FileSpec.builder(className).apply {
            indent("    ")
            addType(type)
        }.build()

        return file
    }
}