package org.anime_game_servers.game_data_models.processor

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.ksp.kspDependencies
import com.squareup.kotlinpoet.ksp.toClassName
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.game_data_models.loader.enums.EnumMetadata
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapper
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapperBaseSerializer
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry
import kotlin.collections.set
import kotlin.enums.EnumEntries
import kotlin.reflect.KClass

object EnumMetaDataGenerator {

    data class DataEnumInfoMetadata(
        val className: String,
        val packageName: String,
        val ksClass: KSClassDeclaration,
        val unknownEntry: KSClassDeclaration = ksClass.getUnknownEntry(),
        val noneEntry: KSClassDeclaration? = ksClass.getNoneEntry(),
        val entries: List<KSClassDeclaration> = ksClass.declarations.mapNotNull { it as? KSClassDeclaration }.filter { !it.isCompanionObject }.toList(),
    ) {
        fun getMetadataName(): String {
            return className + "Metadata"
        }
        fun getEnumWrapperSerializerName(): String {
            return className + "ContainerSerializer"
        }

        fun getKeyValueMapping(): Map<String, KSClassDeclaration>{
            val stringMapping = mutableMapOf<String, KSClassDeclaration>()
            entries.forEach { entry ->
                // validation happens in its own step, so no need to worry about duplicates
                stringMapping[entry.getSerialName()] = entry
                entry.getJsonNames()?.forEach { jsonName ->
                    stringMapping[jsonName] = entry
                }
            }
            return stringMapping
        }

        companion object {
            fun KSClassDeclaration.getUnknownEntry() = this.declarations.mapNotNull{ it as? KSClassDeclaration }
                .filter { it.annotations.any { it.shortName.asString() == UnknownEntry::class.simpleName } }
                .first()
            fun KSClassDeclaration.getNoneEntry() = this.declarations.mapNotNull { it as? KSClassDeclaration }
                .firstOrNull { it.annotations.any { it.shortName.asString() == NoneEntry::class.simpleName } }

            fun KSClassDeclaration.getSerialName() = this.annotations.find { it.shortName.asString() == SerialName::class.simpleName }?.arguments?.map { it.value as String }?.first() ?: this.simpleName.asString()

            fun KSClassDeclaration.getJsonNames() =
                (this.annotations.find { it.shortName.asString() == JsonNames::class.simpleName }?.arguments as? ArrayList)?.flatMap {
                    @Suppress("UNCHECKED_CAST")
                    it.value as ArrayList<String>
                }
        }
    }

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
        val nullEnumType = enumType.copy(nullable = true)

        val intMapKey = "intEnumMap"
        val stringMapKey = "stringEnumMap"
        val stringMapFunctionKey = "getStringKeyMap"
        val intMapFunctionKey = "getIntKeyMap"
        val stringKeyType = String::class.asClassName()
        val intKeyType = Int::class.asClassName()

        val typeBuilder = TypeSpec.objectBuilder(className)
            .addSuperinterface(
                EnumMetadata::class.asClassName()
                .parameterizedBy(enumType))
            .addProperty(
                PropertySpec.builder(EnumMetadata<*>::unknownEntry.name, enumType, KModifier.OVERRIDE)
                .initializer("%L", metaData.unknownEntry)
                .build())
            .addProperty(
                PropertySpec.builder(EnumMetadata<*>::noneEntry.name, enumType.copy(nullable = metaData.noneEntry == null), KModifier.OVERRIDE)
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
            .addProperty(
                PropertySpec.builder(intMapKey, Map::class.asClassName().parameterizedBy(intKeyType, enumType),
                    KModifier.PRIVATE)
                    .delegate(CodeBlock.builder()
                        .beginControlFlow("lazy(mode = %T.PUBLICATION)", LazyThreadSafetyMode::class.asTypeName())
                        .add("values.associateBy { it.getIntKey() }")
                        .endControlFlow()
                        .build())
                .build())
            .addProperty(
                PropertySpec.builder(stringMapKey, Map::class.asClassName().parameterizedBy(stringKeyType, enumType),
                    KModifier.PRIVATE)
                    .delegate(CodeBlock.builder()
                        .beginControlFlow("lazy(mode = %T.PUBLICATION)", LazyThreadSafetyMode::class.asTypeName())
                        .add("$stringMapFunctionKey()")
                        .endControlFlow()
                        .build())
                .build())
            .addFunction(FunSpec.builder(EnumMetadata<*>::fromStringKey.name)
                .addModifiers(KModifier.OVERRIDE)
                .addParameter(ParameterSpec("stringKey", stringKeyType))
                .returns(nullEnumType)
                .addCode(CodeBlock.builder().apply {
                    addStatement("return $stringMapKey[stringKey]")
                }.build())
                .build())
            .addFunction(FunSpec.builder(EnumMetadata<*>::fromIntKey.name)
                .addModifiers(KModifier.OVERRIDE)
                .addParameter(ParameterSpec("intKey", intKeyType))
                .returns(nullEnumType)
                .addCode(CodeBlock.builder().apply {
                    addStatement("return $intMapKey[intKey]")
                }.build())
                .build())

        var chunkCount = 0
        val keyValueMapping = metaData.getKeyValueMapping()

        keyValueMapping.entries.chunked(500){ entries ->
            val functionName = stringMapFunctionKey+chunkCount.toString()
            chunkCount++
            typeBuilder.addFunction(FunSpec.builder(functionName)
                .addModifiers(KModifier.PRIVATE)
                .addParameter(ParameterSpec("target", MUTABLE_MAP.parameterizedBy(stringKeyType, enumType)))
                .addCode(CodeBlock.builder().apply {
                    entries.forEach { entry ->
                        addStatement("target[\"${entry.key}\"] = ${entry.value.simpleName.asString()}")
                    }
                }.build())
                .build()
            )
        }

        typeBuilder.addFunction(FunSpec.builder(stringMapFunctionKey)
            .returns(Map::class.asClassName().parameterizedBy(stringKeyType, enumType))
            .addModifiers(KModifier.PRIVATE)
                .addCode(CodeBlock.builder().withIndent {
                    addStatement("val stringKeyMap = mutableMapOf<%T, %T>()",stringKeyType, enumType)
                    for ( i in (0..<chunkCount)){
                        addStatement("$stringMapFunctionKey$i(stringKeyMap)")
                    }
                    addStatement("return stringKeyMap")
                }.build())
                .build()
            )



        val file = FileSpec.builder(className).apply {
            indent("    ")
            addType(typeBuilder.build())
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

        val type = TypeSpec.objectBuilder(className)
            .addSuperinterface(
                KSerializer::class.asClassName()
                .parameterizedBy(EnumWrapper::class.asClassName().parameterizedBy(enumType)),
                CodeBlock.builder()
                    .add(
                        "%T(%L)",EnumWrapperBaseSerializer::class.asClassName().parameterizedBy(enumType),
                        metaData.getMetadataName()
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