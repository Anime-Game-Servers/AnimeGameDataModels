package org.anime_game_servers.game_data_models.gi.data.item

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

@DataEnum
@Serializable
enum class BydMaterialUseOp(val id: Int) : IntKey {
    @NoneEntry
    BYD_MATERIAL_USE_NONE (0),
    BYD_MATERIAL_USE_GAIN_COSTUME (1),
    BYD_MATERIAL_USE_GAIN_COSTUME_SUIT (2),
    BYD_MATERIAL_USE_GAIN_COSTUME_DRAWING (3),
    BYD_MATERIAL_USE_GAIN_EMOJI (4),
    BYD_MATERIAL_USE_GAIN_POSE (5),
    BYD_MATERIAL_USE_GAIN_TRANSFER_EFFECT (6),
    BYD_MATERIAL_USE_UNLOCK_PRIVATE_HALL (7),
    BYD_MATERIAL_USE_GAIN_TRIAL_COSTUME (8),
    BYD_MATERIAL_USE_GAIN_TRIAL_COSTUME_SUIT (9),
    BYD_MATERIAL_USE_ADD_SELECT_ITEM_UNREPEATABLE (11),
    BYD_MATERIAL_USE_UNLOCK_NORMAL_BEYOND_BATTLE_PASS (12),
    BYD_MATERIAL_USE_OPEN_DROP_EXTRA (13),

    @UnknownEntry
    BYD_MATERIAL_USE_UNKNOWN(9999);

    override fun getIntKey() = id
}
