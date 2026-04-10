package org.anime_game_servers.game_data_models.gi.data.scene.challenge

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.game_data_models.gi.helpers.nullableEnumValueOfOrDefault
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.TextMapHash
import org.anime_game_servers.game_data_models.gi.data.general.UnsetFloat
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.gi.data.general.UnsetTextMap
import org.anime_game_servers.game_data_models.gi.data.scene.weather.ClimateType
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType

/**
 * TODO Add documentation
 * These are known names for files handled by this class:
 * ExcelBinOutput/DungeonChallengeConfigData.json
 * txt/DungeonChallengeData.txt (with an appropriate parser)
 */
@DataFile("ExcelBinOutput/DungeonChallengeConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/DungeonChallengeData.txt", FileType.TSV, FolderType.EXCEL)
@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class ChallengeData(
    val id: Int,
    val isTransBackWhenInterrupt: Boolean? = null,

    @SerialName("challengeType")
    val challengeTypeString: String? = null,
    @Transient
    val challengeType: ChallengeType? = nullableEnumValueOfOrDefault(challengeTypeString, CHALLENGE_UNKNOWN),

    @SerialName("recordType")
    val recordTypeString: String? = null,
    @Transient
    val recordType: ChallengeRecordType? = nullableEnumValueOfOrDefault(recordTypeString, CHALLENGE_RECORD_TYPE_UNKNOWN),// todo

    @SerialName("interruptButtonType")
    val interruptButtonTypeString: String? = null,
    @Transient
    val interruptButtonType: InterruptButtonType? = nullableEnumValueOfOrDefault(interruptButtonTypeString, INTERRUPT_UNKNOWN),

    @SerialName("subChallengeSortType")
    val subChallengeSortTypeString: String? = null,
    @Transient
    val subChallengeSortType: SubChallengeSortType? = nullableEnumValueOfOrDefault(subChallengeSortTypeString, SUB_CHALLENGE_SORT_TYPE_UNKNOWN),

    @SerialName("animationOnSubStart") @JsonNames("subChallengeStartAnim")
    val animationOnSubStartString: String? = null,
    @Transient
    val animationOnSubStart: SubChallengeAnimationType? = nullableEnumValueOfOrDefault(animationOnSubStartString, SUB_CHALLENGE_ANIM_TYPE_UNKNOWN),

    @SerialName("animationOnSubSuccess") @JsonNames("subChallengeSuccessAnim")
    val animationOnSubSuccessString: String? = null,
    @Transient
    val animationOnSubSuccess: SubChallengeAnimationType? = nullableEnumValueOfOrDefault(animationOnSubSuccessString, SUB_CHALLENGE_ANIM_TYPE_UNKNOWN),

    @SerialName("animationOnSubFail") @JsonNames("subChallengeFailAnim")
    val animationOnSubFailString: String? = null,
    @Transient
    val animationOnSubFail: SubChallengeAnimationType? = nullableEnumValueOfOrDefault(animationOnSubFailString, SUB_CHALLENGE_ANIM_TYPE_UNKNOWN),

    @JsonNames("activitySkillID")
    val activitySkillId: Int = UnsetInt,
    val teamAbilityGroupList: List<String>? = null,

    // server only
    val abilityGroupList: List<String>? = null,
    val isHideFromUnrelatedPlayerAsFather: Boolean? = null,

    //client only
    val iconPath: String? = null,
    val isForwardTiming: Boolean? = null,
    val noSuccessHint: Boolean? = null,
    val noFailHint: Boolean? = null,
    val noPauseHint: Boolean? = null,
    val isSuccessWhenNotSettled: Boolean? = null,
    val isBlockTopTimer: Boolean? = null,

    val targetTextTemplate: String? = null,
    val subTargetTextTemplate: String? = null,
    val progressTextTemplate: String? = null,
    val subProgressTextTemplate: String? = null,
    val subChallengeFadeOutDelayTime: Float = UnsetFloat,

    @SerialName("subChallengeFadeOutRule")
    val subChallengeFadeOutRuleString: String? = null,
    @Transient
    val subChallengeFadeOutRule: SubChallengeFadeOutType? = nullableEnumValueOfOrDefault(subChallengeFadeOutRuleString, SUBCHALLENGE_FADEOUT_TYPE_UNKNOWN),

    @SerialName("subChallengeBannerRule")
    val subChallengeBannerRuleString: String? = null,
    @Transient
    val subChallengeBannerRule: SubChallengeBannerType? = nullableEnumValueOfOrDefault(subChallengeBannerRuleString, SUBCHALLENGE_BANNER_TYPE_UNKNOWN),


    // Textmaps
    val targetTextTemplateTextMapHash: TextMapHash = UnsetTextMap,
    val subTargetTextTemplateTextMapHash: TextMapHash = UnsetTextMap,
    val progressTextTemplateTextMapHash: TextMapHash = UnsetTextMap,
    val subProgressTextTemplateTextMapHash: TextMapHash = UnsetTextMap,

    // TODO unidentified client at least one unidentified boolean is missing

) : IntKey {
    override fun getIntKey() = id

}
