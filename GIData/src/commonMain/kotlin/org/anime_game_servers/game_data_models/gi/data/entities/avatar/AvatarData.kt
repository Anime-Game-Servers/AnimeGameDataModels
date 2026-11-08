package org.anime_game_servers.game_data_models.gi.data.entities.avatar

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.entities.CreatureExcelConfig
import org.anime_game_servers.game_data_models.gi.data.entities.EntityExcelConfig
import org.anime_game_servers.game_data_models.gi.data.general.*
import org.anime_game_servers.game_data_models.gi.data.rewards.RewardData
import org.anime_game_servers.game_data_models.loader.DataFile
import org.anime_game_servers.game_data_models.loader.FileType
import org.anime_game_servers.game_data_models.loader.FolderType
import org.anime_game_servers.game_data_models.loader.enums.EnumWrapper

/**
 * This defines a lot of information about playable characters/avatars in the game.
 * These are known names for files handled by this class:
 * ExcelBinOutput/AvatarExcelConfigData.json
 * txt/AvatarData.txt
 * @property id the id o the avatar and primary identifier
 * @property camp TODO document
 * @property useType Enum wrapper. [AvatarUseType.AVATAR_UNKNOWN] if set to something not in the enum // TODO document
 * @property bodyType Enum wrapper with the body type assigned to the avatar. [BodyType.BODY_UNKNOWN] if set to something not in the enum
 * @property qualityType Enum wrapper with the rarity /stars of the character. [QualityType.QUALITY_UNKNOWN] if set to something not in the enum
 * @property avatarIdentityType Enum wrapper. [AvatarIdentityType.AVATAR_IDENTITY_UNKNOWN] if set to something not in the enum // TODO document
 * @property chargeEfficiency TODO document
 * @property isRangeAttack TODO document
 * @property staminaRecoverSpeed TODO document
 * @property skillDepotId this contains the id of the default [AvatarSkillDepotData] containing the base abilities info of the avatar
 * @property candSkillDepotIds when a character can change their abilities, for example by changing the element like traveler,
 * this contains the ids of the [AvatarSkillDepotData] the character can switch to.
 * @property mannequinMotionConfig TODO document
 * @property featureTagGroupId references to [FeatureTagGroupData] TODO document
 * @property avatarPromoteId references to [AvatarPromoteData], containing some information about the process of the characters promotion
 * @property avatarPromoteRewardLevelList The levels of promotion, at which the character gets rewards
 * @property avatarPromoteRewardIdList The [RewardData] ids for the rewards the character gets at each promotion from [avatarPromoteRewardLevelList]
 * @property initialWeapon The [org.anime_game_servers.game_data_models.gi.data.item.WeaponData] id of the default weapon the character has when obtained. This is also given to the player with the character.
 * @property weaponType Enum wrapper with the type of weapon the character uses. [WeaponType.WEAPON_UNKNOWN] if set to something not in the enum
 * @property propGrowCurves Info about the character specific growth curves to use for some stats
 * @property hpBase The base health points of the character
 * @property attackBase The base attack points of the character
 * @property defenseBase The base defense points of the character
 * @property critical The base critical chance of the character
 * @property antiCritical The base critical reduction of the character
 * @property criticalHurt The critical damage multiplier of the character
 * @property fireSubHurt The [Element.FIRE] damage reduction of the character
 * @property grassSubHurt The [Element.GRASS] damage reduction of the character
 * @property waterSubHurt The [Element.WATER] damage reduction of the character
 * @property elecSubHurt The [Element.ELECTRIC] damage reduction of the character
 * @property windSubHurt The [Element.WIND] damage reduction of the character
 * @property iceSubHurt The [Element.ICE] damage reduction of the character
 * @property rockSubHurt The [Element.ROCK] damage reduction of the character
 * @property fireAddHurt The [Element.FIRE] damage increase of the character
 * @property grassAddHurt The [Element.GRASS] damage increase of the character
 * @property waterAddHurt The [Element.WATER] damage increase of the character
 * @property elecAddHurt The [Element.ELECTRIC] damage increase of the character
 * @property windAddHurt The [Element.WIND] damage increase of the character
 * @property iceAddHurt The [Element.ICE] damage increase of the character
 * @property rockAddHurt The [Element.ROCK] damage increase of the character
 * @property physicalSubHurt The physical/[Element.NONE] damage reduction of the character
 * @property physicalAddHurt The physical/[Element.NONE] damage increase of the character
 * @property elementMastery The base element mastery of the character
 * @property healAdd The healing increase of the character
 * @property healedAdd The healing received increase of the character
 * @property iconName TODO document
 * @property sideIconName TODO document
 * @property imageName TODO document
 * @property cutsceneShow TODO document
 * @property lodPatternName TODO document
 * @property nameTextMapHash The [TextMapHash] of the characters name that can be shown in the ui/log
 * @property descTextMapHash The [TextMapHash] of the characters description that can be shown in the ui
 * @property infoDescTextMapHash TODO document
 * @property scriptDataPathHash TODO document
 * @property combatConfigHash [TextHash] of the clients internal path to the characters combat config.
 * For characters the base is `"Data/_BinOutput/Avatar/%s.MiHoYoBinData"`, which matches to `BinOutput/Avatar/%s.json` in the dumped resources.
 * @property mannequinPathHash TODO document
 * @property gachaCardNameHash TODO document
 * @property gachaImageNameHash TODO document
 * @property coopPicNameHash TODO document
 * @property mannequinJsonConfigHash [TextHash] of the clients internal path to the characters combat config TODO document when exactly manekin is used
 * For characters the base is `"Data/_BinOutput/Avatar/%s.MiHoYoBinData"`, which matches to `BinOutput/Avatar/%s.json` in the dumped resources.
 * @property animatorConfigPathHash TODO document
 * @property prefabPathHash TODO document
 * @property prefabPathRemoteHash TODO document
 * @property controllerPathHash TODO document
 * @property controllerPathRemoteHash TODO document
 * @property prefabPathRagdollHash TODO document
 */
@OptIn(ExperimentalSerializationApi::class)
@DataFile("ExcelBinOutput/AvatarExcelConfigData.json", FileType.JSON, FolderType.EXCEL)
@DataFile("txt/AvatarData.txt", FileType.TSV, FolderType.EXCEL)
@Serializable
data class AvatarData(
    override val id: Int,
    override val camp: Int = UnsetInt,
    @Serializable(with = AvatarUseTypeContainerSerializer::class)
    val useType: EnumWrapper<AvatarUseType>? = null,
    @Serializable(with = BodyTypeContainerSerializer::class)
    val bodyType: EnumWrapper<BodyType>? = null,
    @Serializable(with = QualityTypeContainerSerializer::class)
    val qualityType: EnumWrapper<QualityType>? = null,
    @Serializable(with = AvatarIdentityTypeContainerSerializer::class)
    val avatarIdentityType: EnumWrapper<AvatarIdentityType>? = null,

    @SerialName("charge_efficiency")
    val chargeEfficiency: Float = UnsetFloat,
    @SerialName("isRangeAttack")
    val isRangeAttack: Boolean = false,
    @SerialName("stamina_recover_speed")
    val staminaRecoverSpeed: Float = UnsetFloat,

    @JsonNames("skill_depot_id")
    val skillDepotId: Int = UnsetInt,
    @SerialName("cand_skill_depot_ids")
    val candSkillDepotIds: List<Int>? = null,
    @JsonNames("manekin_motion_config", "manekinMotionConfig")
    val mannequinMotionConfig: Int = UnsetInt,
    @JsonNames("feature_tag_group_id", "featureTagGroupID")
    val featureTagGroupId: Int = UnsetInt, // references to FeatureTagGroupData

    @JsonNames("avatar_promote_id")
    val avatarPromoteId: Int = UnsetInt,
    @SerialName("avatar_promote_reward_level_list")
    val avatarPromoteRewardLevelList: List<Int>? = null,
    @SerialName("avatar_promote_reward_id_list")
    val avatarPromoteRewardIdList: List<Int>? = null,

    // weapon
    @JsonNames("initial_weapon")
    val initialWeapon: Int = UnsetInt,
    @Serializable(with = WeaponTypeContainerSerializer::class)
    val weaponType: EnumWrapper<WeaponType>? = null,


    // Stats/Props
    override val propGrowCurves: List<CreatureExcelConfig.FightPropGrowConfig>? = null,
    @JsonNames("hp_base")
    override val hpBase: Float = UnsetFloat,
    @JsonNames("attack_base")
    override val attackBase: Float = UnsetFloat,
    @JsonNames("defense_base")
    override val defenseBase: Float = UnsetFloat,
    override val critical: Float = UnsetFloat,
    override val antiCritical: Float = UnsetFloat,
    override val criticalHurt: Float = UnsetFloat,
    override val fireSubHurt: Float = UnsetFloat,
    override val grassSubHurt: Float = UnsetFloat,
    override val waterSubHurt: Float = UnsetFloat,
    override val elecSubHurt: Float = UnsetFloat,
    override val windSubHurt: Float = UnsetFloat,
    override val iceSubHurt: Float = UnsetFloat,
    override val rockSubHurt: Float = UnsetFloat,
    override val fireAddHurt: Float = UnsetFloat,
    override val grassAddHurt: Float = UnsetFloat,
    override val waterAddHurt: Float = UnsetFloat,
    override val elecAddHurt: Float = UnsetFloat,
    override val windAddHurt: Float = UnsetFloat,
    override val iceAddHurt: Float = UnsetFloat,
    override val rockAddHurt: Float = UnsetFloat,
    override val physicalSubHurt: Float = UnsetFloat,
    override val physicalAddHurt: Float = UnsetFloat,
    override val elementMastery: Float = UnsetFloat,
    @SerialName("heal_add")
    val healAdd: Float = UnsetFloat,
    @SerialName("healed_add")
    val healedAdd: Float = UnsetFloat,

    // client data
    @SerialName("icon_name")
    val iconName: String? = null,
    @SerialName("side_icon_name")
    val sideIconName: String? = null,
    @SerialName("image_name")
    val imageName: String? = null,
    @SerialName("cutscene_show")
    val cutsceneShow: String? = null,
    @JsonNames("LODPatternName")
    override val lodPatternName: String? = null,

    //textMaps
    override val nameTextMapHash: TextMapHash,
    val descTextMapHash: TextMapHash = UnsetTextMap,
    val infoDescTextMapHash: TextMapHash = UnsetTextMap,

    // textHash
    val scriptDataPathHash: TextHash = UnsetTextHash,
    @JsonNames("combat_config_hash", "combatConfigHashSuffix")
    val combatConfigHash: TextHash = UnsetTextHash,
    @JsonNames("manekin_path_hash", "manekinPathHash", "manekinPathHashSuffix")
    val mannequinPathHash: TextHash = UnsetTextHash,
    @JsonNames("gacha_card_name_hash", "gachaCardNameHashSuffix")
    val gachaCardNameHash: TextHash = UnsetTextHash,
    @JsonNames("gacha_image_name_hash", "gachaImageNameHashPre")
    val gachaImageNameHash: TextHash = UnsetTextHash,
    @JsonNames("coop_pic_name_hash", "coopPicNameHashPre")
    val coopPicNameHash: TextHash = UnsetTextHash,
    @JsonNames("manekin_json_config_hash", "manekinJsonConfigHash", "manekinJsonConfigHashSuffix")
    val mannequinJsonConfigHash: TextHash = UnsetTextHash,
    @JsonNames("animator_config_path_hash", "animatorConfigPathHashPre")
    val animatorConfigPathHash: TextHash = UnsetTextHash,
    override val prefabPathHash: TextHash = UnsetTextHash,
    override val prefabPathRemoteHash: TextHash = UnsetTextHash,
    override val controllerPathHash: TextHash = UnsetTextHash,
    override val controllerPathRemoteHash: TextHash = UnsetTextHash,
    override val prefabPathRagdollHash: TextHash = UnsetTextHash,

    ): IntKey, EntityExcelConfig, CreatureExcelConfig {
    override fun getIntKey() = id

    fun getCandSkillDepotIdsNonNull() = candSkillDepotIds ?: emptyList()

    fun getWeaponTypeNonNull() = weaponType?.value ?: WEAPON_NONE
    fun getPropGrowCurvesNonNull() = propGrowCurves ?: emptyList()

    fun getCombatConfigHashJvm(): Long = combatConfigHash.toLong()

}
