package org.anime_game_servers.game_data_models.gi.data.scene.challenge

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.TextMapHash
import org.anime_game_servers.game_data_models.gi.data.general.UnsetFloat
import org.anime_game_servers.game_data_models.gi.data.general.UnsetInt
import org.anime_game_servers.game_data_models.gi.data.general.UnsetTextMap
import org.anime_game_servers.game_data_models.gi.helpers.getValueNonNull
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapper

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


    @Serializable(with = ChallengeTypeContainerSerializer::class)
    val challengeType: EnumWrapper<ChallengeType>? = null,

    @Serializable(with = ChallengeRecordTypeContainerSerializer::class)
    val recordType: EnumWrapper<ChallengeRecordType>? = null,// todo

    @Serializable(with = InterruptButtonTypeContainerSerializer::class)
    val interruptButtonType: EnumWrapper<InterruptButtonType>? = null,

    @Serializable(with = SubChallengeSortTypeContainerSerializer::class)
    val subChallengeSortType: EnumWrapper<SubChallengeSortType>? = null,

    @JsonNames("subChallengeStartAnim")
    @Serializable(with = SubChallengeAnimationTypeContainerSerializer::class)
    val animationOnSubStart: EnumWrapper<SubChallengeAnimationType>? = null,

    @JsonNames("subChallengeSuccessAnim")
    @Serializable(with = SubChallengeAnimationTypeContainerSerializer::class)
    val animationOnSubSuccess: EnumWrapper<SubChallengeAnimationType>? = null,

    @JsonNames("subChallengeFailAnim")
    @Serializable(with = SubChallengeAnimationTypeContainerSerializer::class)
    val animationOnSubFail: EnumWrapper<SubChallengeAnimationType>? = null,

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

    @Serializable(with = SubChallengeFadeOutTypeContainerSerializer::class)
    val subChallengeFadeOutRule: EnumWrapper<SubChallengeFadeOutType>? = null,

    @Serializable(with = SubChallengeBannerTypeContainerSerializer::class)
    val subChallengeBannerRule: EnumWrapper<SubChallengeBannerType>? = null,


    // Textmaps
    val targetTextTemplateTextMapHash: TextMapHash = UnsetTextMap,
    val subTargetTextTemplateTextMapHash: TextMapHash = UnsetTextMap,
    val progressTextTemplateTextMapHash: TextMapHash = UnsetTextMap,
    val subProgressTextTemplateTextMapHash: TextMapHash = UnsetTextMap,

    // TODO unidentified client at least one unidentified boolean is missing

) : IntKey {
    override fun getIntKey() = id

    fun getChallengeTypeNonNull() = challengeType.getValueNonNull(ChallengeTypeMetadata)
    fun getRecordTypeNonNull() = recordType.getValueNonNull(ChallengeRecordTypeMetadata)
    fun getInterruptButtonTypeNonNull() = interruptButtonType.getValueNonNull(InterruptButtonTypeMetadata)
    fun getSubChallengeSortTypeNonNull() = subChallengeSortType.getValueNonNull(SubChallengeSortTypeMetadata)

}
