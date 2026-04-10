package org.anime_game_servers.game_data_models.gi.data.shop

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.game_data_models.gi.data.general.ShopType
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.gi.data.general.UnsetLong
import org.anime_game_servers.game_data_models.gi.helpers.nullableEnumValueOfOrDefault
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.TextMapHash
import org.anime_game_servers.game_data_models.gi.data.general.UnsetDouble
import org.anime_game_servers.game_data_models.gi.data.general.UnsetFloat
import org.anime_game_servers.game_data_models.gi.data.general.UnsetTextMap
import org.anime_game_servers.game_data_models.gi.data.quest.GainItem
import org.anime_game_servers.game_data_models.gi.serializers.StringToLocalDatetimeSerializer
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * This contains the entries of the shops, together with information about the cost, refreshing, requirements and more
 */
@DataFile("ExcelBinOutput/ShopGoodsExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/ShopGoodsData.txt", FileType.TSV, FolderType.EXCEL)
@DataFile("txt/ActivityShopGoodsData.txt", FileType.TSV, FolderType.EXCEL)
@DataFile("txt/GCGShopGoodsData.txt", FileType.TSV, FolderType.EXCEL)
@DataFile("txt/ShopmallGoodsData.txt", FileType.TSV, FolderType.EXCEL)
@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class ShopGoodsData(
    @JsonNames("goods_id")
    val goodsId: Int,
    @SerialName("shopType") @JsonNames("shop_type")
    val shopTypeId: Int,
    @Transient
    val shopType: ShopType? = nullableEnumValueOfOrDefault(shopTypeId, ShopType.SHOP_TYPE_UNKNOWN),
    @JsonNames("item_id")
    val itemId: Int = UnsetInt, // yes there are actually entries without an itemId, like 102005
    @JsonNames("item_count")
    val itemCount: Int,
    @JsonNames("rotate_id")
    val rotateId: Int = UnsetInt,
    @JsonNames("cost_scoin")
    val costScoin: Int = UnsetInt,
    @JsonNames("cost_hcoin")
    val costHcoin: Int = UnsetInt,
    @JsonNames("cost_mcoin")
    val costMcoin: Int = UnsetInt,
    @JsonNames("cost_items")
    val costItems: List<GainItem>,
    @JsonNames("buy_limit")
    val buyLimit: Int = UnsetInt,
    @SerialName("refreshType") @JsonNames("refresh_type")
    val refreshTypeString: String? = null,
    @Transient
    val refreshType: ShopRefreshType? = nullableEnumValueOfOrDefault(
        refreshTypeString,
        ShopRefreshType.SHOP_REFRESH_UNKNOWN
    ),
    @JsonNames("refresh_param")
    val refreshParam: Int = UnsetInt,
    @JsonNames("display_days_before_sell")
    val displayDaysBeforeSell: Int = UnsetInt,
    @Serializable(with = StringToLocalDatetimeSerializer::class)
    @JsonNames("begin_time")
    val beginTime: LocalDateTime? = null,
    @Serializable(with = StringToLocalDatetimeSerializer::class)
    @JsonNames("end_time")
    val endTime: LocalDateTime? = null,
    @JsonNames("is_buy_once")
    val isBuyOnce: Boolean? = null,
    @SerialName("precondition")
    val preconditionString: String? = null,
    @Transient
    val precondition: ShopPrecondition? = nullableEnumValueOfOrDefault(
        preconditionString,
        ShopPrecondition.SHOP_PRECONDITION_UNKNOWN
    ),
    @JsonNames("precondition_param")
    val preconditionParam: Int = UnsetInt,
    @JsonNames("precondition_param_list")
    val preconditionParamList: List<String>,
    @JsonNames("precondition_hidden")
    val preconditionHidden: Boolean? = null,
    @JsonNames("min_show_level")
    val minShowLevel: Int = UnsetInt,
    @JsonNames("min_player_level")
    val minPlayerLevel: Int = UnsetInt,
    @JsonNames("max_player_level")
    val maxPlayerLevel: Int = UnsetInt,
    @JsonNames("sort_level")
    val sortLevel: Int = UnsetInt,
    @JsonNames("secondary_sheet_id")
    val secondarySheetId: Int = UnsetInt,
    @JsonNames("choose_one_group_id")
    val chooseOneGroupId: Int = UnsetInt,
    @JsonNames("platform_type_list")
    val platformTypeList: List<Long>? = null,

    @JsonNames("sub_tag_name")
    val subTagName: String? = null,
    @JsonNames("sub_tab_id")
    val subTabId: Int = UnsetInt,
    @JsonNames("show_id")
    val showId: Int = UnsetInt,
    @JsonNames("discount_rate")
    val discountRate: Double = UnsetDouble,
    @JsonNames("original_price")
    val originalPrice: Int = UnsetInt,

    // Textmaps
    @JsonNames("sub_tag_name_text_map_hash")
    val subTagNameTextMapHash: TextMapHash = UnsetTextMap
) : IntKey {
    override fun getIntKey() = goodsId
}
