package org.anime_game_servers.game_data_models.processor

import com.google.devtools.ksp.symbol.ClassKind
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSDeclaration
import com.google.devtools.ksp.symbol.KSPropertyDeclaration
import kotlinx.serialization.SerialName
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.game_data_models.processor.ClassValidator.ValidatorTarget.Companion.getJsonNames
import org.anime_game_servers.game_data_models.processor.ClassValidator.ValidatorTarget.Companion.getSerialName
import kotlin.collections.set

object ClassValidator {

    data class ValidatorTarget(
        val ksClass: KSClassDeclaration,
        val entries: List<KSDeclaration> = if(ksClass.classKind == ClassKind.ENUM_CLASS){
            ksClass.declarations.mapNotNull { it as? KSClassDeclaration }.filter { !it.isCompanionObject }.toList()
        }  else ksClass.declarations.mapNotNull { it as? KSPropertyDeclaration }.toList(),
    ) {
        fun getName() = ksClass.simpleName.asString()

        companion object {
            fun KSDeclaration.getSerialName() = this.annotations.find { it.shortName.asString() == SerialName::class.simpleName }?.arguments?.map { it.value as String }?.first() ?: this.simpleName.asString()

            fun KSDeclaration.getJsonNames() =
                (this.annotations.find { it.shortName.asString() == JsonNames::class.simpleName }?.arguments as? ArrayList)?.flatMap {
                    @Suppress("UNCHECKED_CAST")
                    it.value as ArrayList<String>
                }
        }
    }

    fun validate(classes: List<KSClassDeclaration>): Map<ValidatorTarget, List<Exception>>{
        val validatorTargets = classes.map { ValidatorTarget(it) }

        val failures = mutableMapOf<ValidatorTarget, MutableList<Exception>>()
        validatorTargets.forEach { target ->
            validateJsonNames(target).let { result ->
                if(result.isNotEmpty()) {
                    failures.getOrPut(target) { mutableListOf() } += result
                }
            }
        }
        return failures
    }

    data class SerialNamesValidationException(
        val field: KSDeclaration,
        val error: String
    ) : Exception("$field failed with $error")

    /**
     * This check for duplicate names in classes where [JsonNames] or [SerialName] overlap, since kotlinx doesn't seem to check this for [JsonNames]
     */
    fun validateJsonNames(metaData: ValidatorTarget) : List<SerialNamesValidationException> {
        val stringMapping = mutableMapOf<String, KSDeclaration>()
        val errors = mutableListOf<SerialNamesValidationException>()
        metaData.entries.forEach { entry ->
            try {
                stringMapping.checkAndAddEntry(entry.getSerialName(), entry)
                entry.getJsonNames()?.forEach { jsonName ->
                    stringMapping.checkAndAddEntry(jsonName, entry)
                }
            } catch (e: Exception) {
                errors+=(e as SerialNamesValidationException)
            }
        }
        return errors
    }

    @Throws(SerialNamesValidationException::class)
    fun MutableMap<String, KSDeclaration>.checkAndAddEntry(key: String, fieldDeclaration: KSDeclaration){
        if(this.containsKey(key)){
            throw SerialNamesValidationException(field = fieldDeclaration, error = "Duplicate Serialisation target name: Name $ for field ${fieldDeclaration.simpleName.asString()} already exists")
        }
        this[key] = fieldDeclaration
    }
}