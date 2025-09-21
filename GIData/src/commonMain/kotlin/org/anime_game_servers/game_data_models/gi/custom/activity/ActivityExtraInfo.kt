package org.anime_game_servers.game_data_models.gi.custom.activity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.gi.helpers.nullableEnumValueOfOrDefault
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * This contains extra info about activities, that's either custom, or collected together from multiple smaller resources.
 * These are known names for files handled by this class:
 * Server/Activity/ActivityInfo.json
 * @property activityId id of the activity
 * @property duration in days that the activity is active
 * @property rewardPreview id of the reward preview
 * @property specialReward id of the special reward
 * @property defaultGroups list of groups that should be registered by default during this activity
 * @property defaultWatchers list of watchers that should be registered by default during this activity
 * @property startConditions list of conditions that must be met for the activity to start
 * @property activeConditions list of conditions that must be met for the activity to be active and playable
 * @property comment additional comment about either the activity or the data in it, only relevant for the humans interacting with the data
 */
@DataFile("Server/ActivityExtraInfo.json", FileType.JSON, FolderType.CUSTOM)
@Serializable
data class ActivityExtraInfo(
    val activityId: Int,
    val duration: Int = UnsetInt,
    val rewardPreview: Int = UnsetInt,
    val specialReward: Int = UnsetInt,
    val defaultGroups: List<Int>? = null,
    val defaultWatchers: List<Int>? = null,

    val startConditions: List<ActivityStateCondition>? = null,
    val activeConditions: List<ActivityStateCondition>? = null,

    val comment: String? = null,

    ) : IntKey {
    override fun getIntKey() = activityId


    fun hasDuration() = duration > 0
    fun hasRewardPreview() = rewardPreview > 0
    fun hasSpecialReward() = specialReward > 0
    fun hasDefaultGroups() = !defaultGroups.isNullOrEmpty()
    fun hasDefaultWatchers() = !defaultWatchers.isNullOrEmpty()
    fun hasStartConditions() = !startConditions.isNullOrEmpty()
    fun hasActiveConditions() = !activeConditions.isNullOrEmpty()

    /**
     * Defines one condition for an ActivityInfo
     * The params usage depends on the type, check [ActivityStateCondType] documentation for more information on the specific types parameters
     */
    @Serializable
    data class ActivityStateCondition(
        @SerialName("type")
        val typeString: String? = null,
        @Transient
        val type: ActivityStateCondType? = nullableEnumValueOfOrDefault(
            typeString,
            ActivityStateCondType.UNKNOWN
        ),
        val param: String? = null,
    )
}
