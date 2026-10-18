package org.anime_game_servers.game_data_models.processor

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.ksp.kspDependencies
import org.anime_game_servers.game_data_models.loader.*

object MetaDataRegistryProviderGenerator {
    val handledModules = mutableSetOf<String>()
    fun createFilesForMetaDataRegistryProvider(basePacket: String, module: String, codeGenerator: CodeGenerator) {
        // Only generate the file once per module
        if (handledModules.contains(basePacket + module)) {
            return
        }

        generateClassFile(basePacket, module, codeGenerator)
        generateServiceResourceFile(basePacket, module, codeGenerator)


        handledModules.add(basePacket + module)
    }


    /**
     * Generates a service resource used for automatic registration of the Modules in the jvm target
     */
    fun generateServiceResourceFile(basePacket: String, module: String, codeGenerator: CodeGenerator) {
        val serviceFile = codeGenerator.createNewFile(
            dependencies = Dependencies(aggregating = true),
            packageName = "META-INF.services",
            fileName = DataClassSourceProvider::class.java.canonicalName,
            extensionName = ""
        )
        serviceFile.writer().use { writer ->
            writer.write(
                "${basePacket}.${module}ModelRegistryProvider\n"
            )
        }
    }

    /**
     * Generates the class used by the JVM ServiceLoader to detect the Modules
     */
    fun generateClassFile(basePacket: String, module: String, codeGenerator: CodeGenerator) {
        val fileSpec = generateClassForRegistryProvider(basePacket, module)
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
    }

    fun generateClassForRegistryProvider(basePacket: String, module: String): FileSpec {
        val className = ClassName(basePacket, "${module}ModelRegistryProvider")

        val type = TypeSpec.classBuilder(className)
            .addSuperinterface(DataClassSourceProvider::class.asClassName())
            .addFunction(
                FunSpec.builder(DataClassSourceProvider::getDataClassSource.name)
                    .addModifiers(KModifier.OVERRIDE)
                    .returns(
                        List::class.asClassName()
                            .parameterizedBy(DataClassSource::class.asClassName())
                    )
                    .addStatement("return listOf(${module}ModelRegistry)")
                    .build()
            )
            .build()

        val file = FileSpec.builder(className).apply {
            indent("    ")
            addType(type)
        }.build()

        return file
    }
}