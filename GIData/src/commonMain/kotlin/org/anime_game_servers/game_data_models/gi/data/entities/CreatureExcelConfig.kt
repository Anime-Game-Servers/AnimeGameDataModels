package org.anime_game_servers.game_data_models.gi.data.entities

import kotlinx.serialization.Serializable
import org.anime_game_servers.game_data_models.gi.data.entities.avatar.GrowthCurveType
import org.anime_game_servers.game_data_models.gi.data.entities.avatar.GrowthCurveTypeContainerSerializer
import org.anime_game_servers.game_data_models.gi.data.general.TextHash
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapper

interface CreatureExcelConfig {
    val hpBase: Float
    val attackBase: Float
    val defenseBase: Float
    val critical: Float
    val antiCritical: Float
    val criticalHurt: Float
    val fireSubHurt: Float
    val grassSubHurt: Float
    val waterSubHurt: Float
    val elecSubHurt: Float
    val windSubHurt: Float
    val iceSubHurt: Float
    val rockSubHurt: Float
    val fireAddHurt: Float
    val grassAddHurt: Float
    val waterAddHurt: Float
    val elecAddHurt: Float
    val windAddHurt: Float
    val iceAddHurt: Float
    val rockAddHurt: Float
    val propGrowCurves: List<FightPropGrowConfig>?
    val elementMastery: Float
    val physicalSubHurt: Float
    val physicalAddHurt: Float
    val prefabPathRagdollHash: TextHash

    @Serializable
    data class FightPropGrowConfig(
        @Serializable(with = FightPropTypeContainerSerializer::class)
        val type: EnumWrapper<FightPropType>? = null,
        @Serializable(with = GrowthCurveTypeContainerSerializer::class)
        val growCurve: EnumWrapper<GrowthCurveType>? = null,
    ) {
        fun getTypeNonNull() = type?.value ?: FightPropType.FIGHT_PROP_NONE
        fun getGrowthCurveNonNull() = growCurve?.value ?: GrowthCurveType.GROW_CURVE_NONE
    }
}