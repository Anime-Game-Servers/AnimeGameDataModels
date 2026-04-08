@file:OptIn(ExperimentalSerializationApi::class)

package org.anime_game_servers.game_data_models.gi.data.trial

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * TODO
 * These are known names for files handled by this class:
 * ExcelBinOutput/TrialAvatarTemplateExcelConfigData.json
 * txt/TrialAvatarTemplateData.txt (with an appropriate parser)
 * @property trialAvatarLevel TODO
 * @property trialReliquaryList TODO
 * @property trialTalentList TODO
 * @property trialAvatarSkillLevel TODO
 */
@DataFile("ExcelBinOutput/TrialAvatarTemplateExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/TrialAvatarTemplateData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class TrialAvatarTemplateData(
    @JsonNames("TrialAvatarLevel")
    val trialAvatarLevel: Int,
    @JsonNames("TrialReliquaryList")
    override val trialReliquaryList: List<Int>? = null,
    @JsonNames("TrialTalentList")
    override val trialTalentList: List<Int>? = null,
    @JsonNames("TrialAvatarSkillLevel")
    override val trialAvatarSkillLevel: Int = UnsetInt,
    @JsonNames("TrialSkillDepotId")
    override val trialSkillDepotId: Int = UnsetInt,
) : TrialAvatarLoadout, IntKey {
    override fun getIntKey() = trialAvatarLevel

    override fun getAvatarLevel() = trialAvatarLevel
}
