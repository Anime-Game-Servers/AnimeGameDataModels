package org.anime_game_servers.game_data_models.gi.data.activity

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.ShopType
import org.anime_game_servers.game_data_models.gi.data.general.ShopTypeContainerSerializer
import org.anime_game_servers.game_data_models.gi.data.general.ShopTypeMetadata
import org.anime_game_servers.game_data_models.gi.data.shop.ShopGoodsData
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapper

/**
 * This contains some basic info about shops from activities/events. You can map the shop from requests via [ShopType].
 * @param scheduleId the id of the activity/event shop run, this is needs to be unique
 * @param shopType the type of shop, this is normally unique, but runs of the same type with a different scheduleId might be possible
 * @param sheetList the list of sheets/pages in the shop. Conditions for those are defined in the [ActivityShopSheetData], and
 *   [ShopGoodsData] for shops with sheets can also be mapped to these ids
 */
@DataFile("ExcelBinOutput/ActivityShopOverallExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/ActivityShopOverallData.txt", FileType.TSV, FolderType.EXCEL)
@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class ActivityShopOverallData(
    @JsonNames("schedule_id")
    val scheduleId: Int,
    @Serializable(with = ShopTypeContainerSerializer::class)
    val shopType: EnumWrapper<ShopType>? = null,
    @JsonNames("sheet_list")
    val sheetList: List<Int>
) : IntKey {
    /*
     use scheduleId as fallback, so that unknown entries don't merge together for missing/unknown entries.
     for now the schedule id should always be higher than all ShopType ids including the unknown entry
     */
    override fun getIntKey() = shopType?.value?.id.let { typeId ->
        if (typeId == null || typeId == ShopTypeMetadata.unknownEntry.id){
            scheduleId
        } else {
            typeId
        }
    }
}
