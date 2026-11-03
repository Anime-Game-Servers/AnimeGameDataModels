package org.anime_game_servers.game_data_models.gi.data.scene.level_tag

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.gi.helpers.getDefault
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * This is a Group of level tags. Each group can have multiple subgroups of tags, and in each subgroup there can only be
 * one tag active at a time. In the beginning the tags from [initialLevelTagIdList] should be active
 * These are known names for files handled by this class:
 * ExcelBinOutput/LevelTagGroupsExcelConfigData.json
 * txt/LevelTagGroupsData.txt (with an appropriate parser)
 * @property id id of the level tag group
 * @property levelTagGroupList List of the level tag subgroups
 * @property initialLevelTagIdList list of level tag ids from [LevelTagData] that should be active in the beginning.
 * The index of the tag in the list is the index its part of in the corresponding subgroup in [levelTagGroupList]
 * @property changeCd time to wait before changing the active tag in a subgroup TODO verify
 */
@DataFile("ExcelBinOutput/LevelTagGroupsExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/LevelTagGroupsData.txt", FileType.TSV, FolderType.EXCEL)
@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class LevelTagGroupsData(
    @JsonNames("ID")
    val id: Int,
    @JsonNames("level_tag_group_list")
    val levelTagGroupList: List<LevelTagGroup>? = null,
    @JsonNames("initial_level_tag_id_list")
    val initialLevelTagIdList: List<Int>? = null,
    @JsonNames("change_cd")
    val changeCd: Int? = null,
) : IntKey {
    override fun getIntKey() = id

    fun getLevelTagGroupListNonNull() = levelTagGroupList ?: emptyList()
    fun getInitialLevelTagIdListNonNull() = initialLevelTagIdList ?: emptyList()
    fun getChangeCdWithDefault() = changeCd.getDefault()

    /**
     * This is a subgroup of level tags. In each subgroup there can only be one tag active at a time
     * @property levelTagIdList list of level tag ids from [LevelTagData] that are in this subgroup
     */
    @Serializable
    data class LevelTagGroup(
        @JsonNames("level_tag_id_list")
        val levelTagIdList: List<Int>,
    )
}