package org.anime_game_servers.game_data_models.gi.data.trial

import org.anime_game_servers.core.base.interfaces.IntKey

interface TrialAvatarEquip: IntKey {
    val trialAvatarWeaponList: List<Int>?

    fun hasWeapon() = trialAvatarWeaponList?.let { it.size >= 1 } ?: false
    fun hasWeaponLevel() = trialAvatarWeaponList?.let { it.size >= 2 } ?: false
    fun getWeapon() = trialAvatarWeaponList?.getOrElse(0) {0}
    fun getWeaponLevel() = trialAvatarWeaponList?.getOrElse(1) {0}
}
