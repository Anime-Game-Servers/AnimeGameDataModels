package org.anime_game_servers.game_data_models.processor

import com.google.devtools.ksp.processing.*
import com.google.devtools.ksp.symbol.*
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
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

    override fun process(resolver: Resolver): List<KSAnnotated> {
        logger.info("Processing...")
        val dataEnumResult = handleDataEnum(resolver)
        val dataClassResult = handleDataClass(resolver)
        return dataClassResult + dataEnumResult
    }

    fun handleDataClass(resolver: Resolver): List<KSAnnotated> {
        logger.info("Processing Data classes")
        val dataClasses = resolver.getClassSymbolsByAnnotation(DataFile::class.qualifiedName!!)
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

        MetaDataRegistryGenerator.createFileForMetaDataRegistry(moduleDataClasses, options["package_root"]!!, options["module"]!!, codeGenerator)
        MetaDataRegistryProviderGenerator.createFilesForMetaDataRegistryProvider(options["package_root"]!!, options["module"]!!, codeGenerator)

        logger.info("Finished processing ${moduleDataClasses.size} data classes")
        return emptyList()
    }

    fun handleDataEnum(resolver: Resolver): List<KSAnnotated> {
        logger.info("Processing Data Enums")
        val dataClasses = resolver.getClassSymbolsByAnnotation(DataEnum::class.qualifiedName!!)
        logger.info("Found ${dataClasses.count()} data enum annotations")

        val moduleDataClasses = mutableListOf<EnumMetaDataGenerator.DataEnumInfoMetadata>()

        dataClasses.forEach { dataClass ->
            logger.info("Processing ${dataClass.simpleName.asString()}")
            try {
                val dataAnnotationInfo = EnumMetaDataGenerator.DataEnumInfoMetadata(
                    className = dataClass.simpleName.asString(),
                    packageName = dataClass.packageName.asString(),
                    ksClass = dataClass,
                )

                EnumMetaDataGenerator.createClassesForDataEnum(dataAnnotationInfo, codeGenerator)
                moduleDataClasses.add(dataAnnotationInfo)
                logger.info("processed ${dataAnnotationInfo.className}")
            } catch (e: Throwable) {
                if(e is NoSuchElementException){
                    logger.error("failed to process ${dataClass.simpleName.asString()} with $e\nDid you maybe forget the @UnknownEntry annotation?")
                }else {
                    logger.error("failed to process ${dataClass.simpleName.asString()} with $e")
                }
            }
        }

        logger.info("Finished processing ${moduleDataClasses.size} data enum classes")
        return emptyList()
    }
}