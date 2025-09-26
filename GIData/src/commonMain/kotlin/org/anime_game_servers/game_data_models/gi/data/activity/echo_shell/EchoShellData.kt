package org.anime_game_servers.game_data_models.gi.data.activity.echo_shell

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.helpers.nullableEnumValueOfOrDefault
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * Data used for the EchoShell event/activity.
 * These are known names for files handled by this class:
 * ExcelBinOutput/EchoShellExcelConfigData.json
 * txt/EchoShellVoiceData.txt (with an appropriate parser)
 * @property id id of the echo shell
 * @property echoShellTypeString string representation of the echo shell type enum
 * @property echoShellType enum representation of the echo shell type, default is [EchoShellType.ECHO_SHELL_TYPE_NORMAL_ECHO]
 * @property storyId TODO
 * @property reminderList TODO
 * @property dungeonId id of the dungeon associated with this echo shell
 */
@DataFile("ExcelBinOutput/EchoShellExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/EchoShellVoiceData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class EchoShellData(
    val id: Int,
    @SerialName("echoShellType")
    val echoShellTypeString: String,
    @Transient
    val echoShellType: EchoShellType? = nullableEnumValueOfOrDefault(
        echoShellTypeString,
        EchoShellType.ECHO_SHELL_TYPE_UNKNOWN
    ),
    val storyId: Int,
    val reminderList: List<Int>,
    val dungeonId: Int,
) : IntKey {
    override fun getIntKey() = id
}
