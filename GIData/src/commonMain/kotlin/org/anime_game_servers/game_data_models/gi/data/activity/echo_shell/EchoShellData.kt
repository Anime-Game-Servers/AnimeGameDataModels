package org.anime_game_servers.game_data_models.gi.data.activity.echo_shell

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.activity.dragonspine.DragonspineMissionExecTypeContainerSerializer
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapper

/**
 * Data used for the EchoShell event/activity.
 * These are known names for files handled by this class:
 * ExcelBinOutput/EchoShellExcelConfigData.json
 * txt/EchoShellVoiceData.txt (with an appropriate parser)
 * @property id id of the echo shell
 * @property echoShellType The container with the enum and string representation of the echo shell type, default is [EchoShellType.ECHO_SHELL_TYPE_NORMAL_ECHO]
 * @property storyId TODO
 * @property reminderList TODO
 * @property dungeonId id of the dungeon associated with this echo shell
 */
@DataFile("ExcelBinOutput/EchoShellExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/EchoShellVoiceData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class EchoShellData(
    val id: Int,
    @Serializable(with = DragonspineMissionExecTypeContainerSerializer::class)
    val echoShellType: EnumWrapper<EchoShellType>? = null,
    val storyId: Int,
    val reminderList: List<Int>,
    val dungeonId: Int,
) : IntKey {
    override fun getIntKey() = id
}
