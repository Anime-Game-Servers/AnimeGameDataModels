package org.anime_game_servers.game_data_models.gi.data.trial

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapper

/**
 * TODO
 * These are known names for files handled by this class:
 * ExcelBinOutput/TrialAvatarFetterDataConfigData.json
 * @property avatarId TODO
 * @property fetterId TODO
 * @property finishCond TODO
 */
@DataFile("ExcelBinOutput/TrialAvatarFetterDataConfigData.json", FileType.JSON, FolderType.EXCEL)
@Serializable
data class TrialAvatarFetterData(
    val avatarId: Int,
    val fetterId: Int = UnsetInt,
    val finishCond: TrialAvatarFetterCondition? = null,
) : IntKey {
    override fun getIntKey() = avatarId

    @Serializable
    data class TrialAvatarFetterCondition(
        @Serializable(with = TrialAvatarFetterConditionTypeContainerSerializer::class)
        val condType: EnumWrapper<TrialAvatarFetterConditionType>? = null,
        val paramList: List<Int>? = null,
    )
}
