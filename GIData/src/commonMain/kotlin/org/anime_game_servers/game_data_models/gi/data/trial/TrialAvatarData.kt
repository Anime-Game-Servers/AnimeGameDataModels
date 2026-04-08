@file:OptIn(ExperimentalSerializationApi::class)

package org.anime_game_servers.game_data_models.gi.data.trial

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * TODO document
 * These are known names for files handled by this class:
 * ExcelBinOutput/TrialAvatarExcelConfigData.json
 * txt/TrialAvatarData.txt (with an appropriate parser)
 * @property trialAvatarId TODO
 * @property trialAvatarParamList TODO
 * @property trialSkillDepotId TODO
 * @property isDynamicLevel TODO
 * @property trialAvatarCostume TODO
 * @property trialAvatarWeaponList TODO
 * @property trialReliquaryList TODO
 * @property trialAvatarSkillLevel TODO
 * @property hideIcon TODO
 */
@DataFile("ExcelBinOutput/TrialAvatarExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/TrialAvatarData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class TrialAvatarData(
    override val trialAvatarId: Int,
    val trialAvatarParamList: List<Int>? = null,
    val isDynamicLevel: Boolean? = null,
    override val trialSkillDepotId: Int = UnsetInt,
    @JsonNames("specifiedCostumeId")
    val trialAvatarCostume: Int = UnsetInt,

    // server only
    override val trialAvatarWeaponList: List<Int>? = null,
    override val trialReliquaryList: List<Int>? = null,
    override val trialAvatarSkillLevel: Int = UnsetInt,
    override val trialTalentList: List<Int>? = null,

    // client only
    val hideIcon: Boolean? = null,

    // unidentified
    val unk_58_MNBNOCMMBHF : List<Int>? = null,
    val unk_63_MKBKMBONFEC : Boolean? = null,

) : TrialAvatarInfo {
    override fun getIntKey() = trialAvatarId

    override fun getAvatarId(): Int = trialAvatarParamList?.getOrElse(0) { 0 } ?: 0
    override fun getAvatarLevel(): Int = trialAvatarParamList?.getOrElse(1) { 0 } ?: 0
}
