package org.anime_game_servers.game_data_models.processor

import com.google.devtools.ksp.processing.*
import com.google.devtools.ksp.symbol.*
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import java.security.InvalidParameterException
import kotlin.reflect.KProperty

class DataProcessor(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger,
    private val options: Map<String, String>) : SymbolProcessor {

    data class DataClassInfoMetadata(
        val className: String,
        val packageName: String,
        val ksClass: KSClassDeclaration,
        val fileInfos: List<DataFile>
    ) {
        fun getLoaderName(): String {
            return className + "Loader"
        }
    }

    private fun Resolver.getClassSymbolsByAnnotation(annotationName: String): Sequence<KSClassDeclaration>{
        return getSymbolsWithAnnotation(annotationName)
            .filterIsInstance<KSClassDeclaration>()
    }

    private inline fun <reified T:Enum<T>> KSAnnotation.getEnumArgument(member: KProperty<T>, fallback: T): T {
        return (arguments.find { it.name?.asString() == member.name }?.value as? KSClassDeclaration)
            ?.simpleName?.asString()?.let{
                java.lang.Enum.valueOf(T::class.java, it)
            } ?: fallback
    }

    private fun KSAnnotation.getStringArgument(member: KProperty<String>, fallback: String): String {
        return arguments.find { it.name?.asString() == member.name }?.value?.toString() ?: fallback
    }

    data class KspConfig(
        val packageRoot: String,
        val moduleName: String,
    )

    override fun process(resolver: Resolver): List<KSAnnotated> {
        val packageRoot = options["package_root"] ?: throw InvalidParameterException("Missing 'package_root' ksp option, please set it")
        val moduleName = options["module"] ?: throw InvalidParameterException("Missing 'module' ksp option, please set it")
        val kspConfig = KspConfig(packageRoot = packageRoot, moduleName = moduleName)

        val dataEnums = resolver.getClassSymbolsByAnnotation(DataEnum::class.qualifiedName!!).toList()
        val dataClasses = resolver.getClassSymbolsByAnnotation(DataFile::class.qualifiedName!!).toList()
        verifyClasses(dataClasses, dataEnums)
        logger.info("Processing...")
        val dataEnumResult = handleDataEnum(dataEnums)
        val dataClassResult = handleDataClass(dataClasses, kspConfig)
        return dataClassResult + dataEnumResult
    }

    fun verifyClasses(classes: List<KSClassDeclaration>, enums: List<KSClassDeclaration>){
        logger.info("Verifying classes")
        val classResult = ClassValidator.validate(classes)
        val enumsResult = ClassValidator.validate(enums)
        val mergedResults = classResult+enumsResult
        if (mergedResults.isNotEmpty()){
            mergedResults.forEach{ (resultClass, errors ) ->
                logger.error("${resultClass.getName()} failed with ${errors.size} errors:")
                errors.forEach { error ->
                    logger.error(error.toString())
                }
            }
            throw RuntimeException("Enum Validation failed")
        }
        logger.info("Verifying completed")
    }


    fun handleDataClass(dataClasses: List<KSClassDeclaration>, config: KspConfig): List<KSAnnotated> {
        logger.info("Processing Data classes")
        logger.info("Found ${dataClasses.count()} data annotations")

        val moduleDataClasses = mutableListOf<DataClassInfoMetadata>()

        dataClasses.forEach { dataClass ->
            val fileInfos = dataClass.annotations
                .filter { it.shortName.asString() == "DataFile" }
                .map { annotation ->
                    val filePath = annotation.getStringArgument(DataFile::filePath, "")
                    val fileType = annotation.getEnumArgument(DataFile::fileType, FileType.OTHER)
                    val folderType = annotation.getEnumArgument(DataFile::folderType, FolderType.OTHER)


                    DataFile(
                        filePath = filePath,
                        fileType = fileType,
                        folderType = folderType
                    )

                }.toList()
            val dataAnnotationInfo = DataClassInfoMetadata(
                className = dataClass.simpleName.asString(),
                packageName = dataClass.packageName.asString(),
                ksClass = dataClass,
                fileInfos = fileInfos
            )

            MetaDataGenerator.createFileForMetaData(dataAnnotationInfo, codeGenerator)
            moduleDataClasses.add(dataAnnotationInfo)

            logger.info("Processing ${dataAnnotationInfo.className}")
        }

        MetaDataRegistryGenerator.createFileForMetaDataRegistry(moduleDataClasses, config.packageRoot, config.moduleName, codeGenerator)
        MetaDataRegistryProviderGenerator.createFilesForMetaDataRegistryProvider(config.packageRoot, config.moduleName, codeGenerator)

        logger.info("Finished processing ${moduleDataClasses.size} data classes")
        return emptyList()
    }

    fun handleDataEnum(dataEnums: List<KSClassDeclaration>): List<KSAnnotated> {
        logger.info("Processing Data Enums")
        logger.info("Found ${dataEnums.count()} data enum annotations")

        val moduleDataClasses = mutableListOf<EnumMetaDataGenerator.DataEnumInfoMetadata>()

        dataEnums.forEach { dataEnums ->
            logger.info("Processing ${dataEnums.simpleName.asString()}")
            try {
                val dataAnnotationInfo = EnumMetaDataGenerator.DataEnumInfoMetadata(
                    className = dataEnums.simpleName.asString(),
                    packageName = dataEnums.packageName.asString(),
                    ksClass = dataEnums,
                )

                EnumMetaDataGenerator.createClassesForDataEnum(dataAnnotationInfo, codeGenerator)
                moduleDataClasses.add(dataAnnotationInfo)
                logger.info("processed ${dataAnnotationInfo.className}")
            } catch (e: Throwable) {
                if(e is NoSuchElementException){
                    logger.error("failed to process ${dataEnums.simpleName.asString()} with $e\nDid you maybe forget the @UnknownEntry annotation?")
                }else {
                    logger.error("failed to process ${dataEnums.simpleName.asString()} with $e")
                }
            }
        }

        logger.info("Finished processing ${moduleDataClasses.size} data enum classes")
        return emptyList()
    }
}