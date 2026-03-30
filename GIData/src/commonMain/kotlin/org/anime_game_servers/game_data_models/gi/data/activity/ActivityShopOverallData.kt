package org.anime_game_servers.game_data_models.gi.data.activity

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.ShopType
import org.anime_game_servers.game_data_models.gi.data.shop.ShopGoodsData
import org.anime_game_servers.game_data_models.gi.helpers.nullableEnumValueOfOrDefault
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * This contains some basic info about shops from activities/events. You can map the shop from requests via [ShopType].
 * @param scheduleId the id of the activity/event shop run, this is needs to be unique
 * @param shopTypeString The string representation of the shop type, in case it's not mappable to a [ShopType], you can use this to
 *  find the missing enum name
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
    @SerialName("shopType") @JsonNames("shop_type")
    val shopTypeString: String?,
    @Transient
    val shopType: ShopType? = nullableEnumValueOfOrDefault(shopTypeString, ShopType.SHOP_TYPE_UNKNOWN),
    @JsonNames("sheet_list")
    val sheetList: List<Int>
) : IntKey {
    override fun getIntKey() = shopType?.id ?: scheduleId
}
