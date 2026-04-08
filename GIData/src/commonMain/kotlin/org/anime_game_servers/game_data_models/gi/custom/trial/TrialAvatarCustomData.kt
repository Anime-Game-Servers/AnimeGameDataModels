package org.anime_game_servers.game_data_models.gi.custom.trial

import kotlinx.serialization.Serializable
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.gi.data.trial.TrialAvatarInfo
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * TODO document
 */
@DataFile("Server/TrialAvatar/TrialAvatarCustomConfigData.json", FileType.JSON, FolderType.CUSTOM)
@Serializable
data class TrialAvatarCustomData(
    override val trialAvatarId: Int,
    override val trialSkillDepotId: Int = UnsetInt,
    override val trialAvatarSkillLevel: Int = UnsetInt,
    val trialAvatarParamList: List<Int>? = null,
    override val trialAvatarWeaponList: List<Int>? = null,
    override val trialReliquaryList: List<Int>? = null,
    override val trialTalentList: List<Int>? = null,
) : TrialAvatarInfo {
    override fun getIntKey() = trialAvatarId

    override fun getAvatarId(): Int = trialAvatarParamList?.getOrElse(0) { 0 } ?: 0
    override fun getAvatarLevel(): Int = trialAvatarParamList?.getOrElse(1) { 0 } ?: 0
}

