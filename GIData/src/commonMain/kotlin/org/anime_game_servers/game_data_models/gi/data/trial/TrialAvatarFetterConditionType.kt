package org.anime_game_servers.game_data_models.gi.data.trial

import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.interfaces.IntKey

/**
 * TODO document
 */
@Serializable
enum class TrialAvatarFetterConditionType(val id: Int) : IntKey {
    TRIAL_FETTER_CONDITION_COMPLETE_SUB_MISSION(0),
    TRIAL_FETTER_CONDITION_LEVEL(1),
    TRIAL_FETTER_CONDITION_UNKNOWN(9999);

    override fun getIntKey() = id
}