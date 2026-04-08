package org.anime_game_servers.game_data_models.gi.data.trial

import org.anime_game_servers.core.base.interfaces.IntKey

interface TrialAvatarInfo: IntKey, TrialAvatarLoadout, TrialAvatarEquip {
    val trialAvatarId: Int
    fun getAvatarId(): Int
}
