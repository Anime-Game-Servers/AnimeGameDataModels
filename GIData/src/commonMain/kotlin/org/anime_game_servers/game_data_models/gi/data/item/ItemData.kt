@file:OptIn(ExperimentalSerializationApi::class)

package org.anime_game_servers.game_data_models.gi.data.item

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.TextMapHash
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapper

/**
    Base for [MaterialData], [WeaponData], [ReliquaryData], [HomeWorldFurnitureData] and [DisplayItemData]
 */
interface ItemData : IntKey {
    val id: Int
    @Serializable(with = ItemTypeContainerSerializer::class)
    val itemType: EnumWrapper<ItemType>?
    val weight: Int
    val rank: Int
    val gadgetId: Int
    val useLevel: Int
    @JsonNames("dropable")
    val droppable: Boolean?
    val globalItemLimit: Int

    // server only
    val controlType: String?
    val itemRankLevel: Int

    // client only
    val icon: String?

    // textmaps
    val nameTextMapHash: TextMapHash
    val descTextMapHash: TextMapHash

    override fun getIntKey(): Int = id
}