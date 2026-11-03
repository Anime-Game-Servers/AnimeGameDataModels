package org.anime_game_servers.game_data_models.gi.data.item

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapper

/**
 */
interface DestroyableItem {

    @Serializable(with = MaterialDestroyTypeContainerSerializer::class)
    val destroyRule: EnumWrapper<MaterialDestroyType>?
    val destroyReturnMaterial: List<Int>?
    val destroyReturnMaterialCount: List<Int>?
}