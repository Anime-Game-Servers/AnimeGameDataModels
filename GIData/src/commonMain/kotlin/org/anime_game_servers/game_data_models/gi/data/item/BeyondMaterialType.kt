package org.anime_game_servers.game_data_models.gi.data.item

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.annotations.AddedIn
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

/**
 * [Custom name]
 */
@DataEnum
@Serializable
enum class BeyondMaterialType(val id: Int) : IntKey {

    @NoneEntry
    BEYOND_MATERIAL_NONE (0),
    BEYOND_MATERIAL_COSTUME (1),
    BEYOND_MATERIAL_COSTUME_SUIT (2),
    BEYOND_MATERIAL_COSTUME_DRAWING (3),
    BEYOND_MATERIAL_NORMAL (4),
    BEYOND_MATERIAL_EMOJI (5),
    BEYOND_MATERIAL_POSE (6),
    BEYOND_MATERIAL_TRANSFER_EFFECT (7),
    BEYOND_MATERIAL_COSTUME_GACHA_DISCOUNT_COUPON (8),
    BEYOND_MATERIAL_COSTUME_SHOP_DISCOUNT_COUPON (9),
    BEYOND_MATERIAL_HALL_UNLOCK (10),
    BEYOND_MATERIAL_ORANGE_COSTUME_TRANS_COIN (11),
    BEYOND_MATERIAL_TRIAL_COSTUME (12),
    BEYOND_MATERIAL_TRIAL_COSTUME_SUIT (13),
    BEYOND_MATERIAL_TYPE_UNREPEATABLE_SELECTABLE_CHEST (14),
    BEYOND_MATERIAL_TYPE_DROP_EXTRA_CHEST (15),
    BEYOND_MATERIAL_TYPE_BUNDLE (16),

    @UnknownEntry
    BEYOND_MATERIAL_UNKNOWN(9999);

    override fun getIntKey() = id
}
