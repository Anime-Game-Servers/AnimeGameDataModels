package org.anime_game_servers.game_data_models.gi.data.quest

import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.general.Element
import org.anime_game_servers.game_data_models.gi.data.activity.ActivityCondData
import org.anime_game_servers.game_data_models.gi.data.activity.ActivityData
import org.anime_game_servers.game_data_models.gi.data.talks.TalkData

enum class QuestCondType(val id: Int) : IntKey {
    /**
     * Nothing to be checked, if its only this, the quest should be accepted by default
     */
    QUEST_COND_NONE(0),

    /**
     * Checks if a SubQuests state is equal to the given state
     * param [0]: the subQuestId to check the state of
     * param [1]: the state to check for. Int representation of [QuestState]
     */
    QUEST_COND_STATE_EQUAL(1),

    /**
     * Checks if a SubQuests state is different from the given state
     * param [0]: the subQuestId to check the state of
     * param [1]: the state to check for. Int representation of [QuestState]
     */
    QUEST_COND_STATE_NOT_EQUAL(2),

    /**
     * Checks if the player has the given item in his inventory
     * TODO check difference to other item count checks
     * param [0]: the item id to check for
     * param [1]: the amount of the item to check for
     */
    QUEST_COND_PACK_HAVE_ITEM(3),

    /**
     * Checks if the players current avatars element equals the given element (currently unused on official)
     * param [0]: the element to check for. Int representation of [Element]
     */
    QUEST_COND_AVATAR_ELEMENT_EQUAL(4),

    /**
     * Checks if the players current avatars element differs from the given element (currently only used in NPC groups on official)
     * param [0]: the element to check for. Int representation of [Element]
     */
    QUEST_COND_AVATAR_ELEMENT_NOT_EQUAL(5),

    /**
     * Checks if the players current avatars element can be changed (currently only used in NPC groups on official)
     * param [0]: 1 if the element should be changeable, 0 if not
     */
    QUEST_COND_AVATAR_CAN_CHANGE_ELEMENT(6),

    /**
     * Checks if players city level (level of the statue) in the specified region/city area is at least the given level (currently only used in talks)
     * param [0]: city area id
     * param [1]: level to check for
     */
    QUEST_COND_CITY_LEVEL_EQUAL_GREATER(7),

    /**
     * Checks if the player has less than the given amount of the specified item
     * param [0]: item id
     * param [1]: amount to check for
     */
    QUEST_COND_ITEM_NUM_LESS_THAN(8),

    /**
     * Checks if a specific daily/daily task has been started
     * param [0]: daily task id (See DailyTaskExcelConfigData)
     */
    QUEST_COND_DAILY_TASK_START(9),

    /**
     * Checks if an open state is in the given state
     * param [0]: the open state id to check for
     * param [1]: the open states state to check for
     */
    QUEST_COND_OPEN_STATE_EQUAL(10),

    /**
     * Checks if daily tasks/quests are activated for the players account (currently only used in NPC groups on official)
     * param [0]: 1 if daily tasks/quests should be activated, 0 if not
     */
    QUEST_COND_DAILY_TASK_OPEN(11),

    /**
     * Checks if the player has open rewards for completing all daily tasks/quests (currently only used in NPC groups/talks on official)
     * param [0]: 1 if the player should have open rewards, 0 if not
     */
    QUEST_COND_DAILY_TASK_REWARD_CAN_GET(12),

    /**
     * Checks if the player has already received the rewards for completing all daily tasks/quests (currently only used in NPC groups/talks on official)
     * param [0]: 1 if the player should have received the rewards, 0 if not
     */
    QUEST_COND_DAILY_TASK_REWARD_RECEIVED(13),

    /**
     * Checks if the player has open level up rewards (currently only used in NPC groups/talks on official)
     * param [0]: 1 if the player should have open rewards, 0 if not
     */
    QUEST_COND_PLAYER_LEVEL_REWARD_CAN_GET(14),

    /**
     * Checks if the player has open exploration rewards (currently only used in NPC groups/talks on official)
     * param [0]: 1 if the player should have open rewards, 0 if not
     */
    QUEST_COND_EXPLORATION_REWARD_CAN_GET(15),

    /**
     * Checks if the player is the host of the current world (currently only used in NPC groups/talks on official)
     * param [0]: 1 if the player should be the host, 0 if not
     */
    QUEST_COND_IS_WORLD_OWNER(16),

    /**
     * Checks if the players level is at least the given level
     * param [0]: level to check for
     */
    QUEST_COND_PLAYER_LEVEL_EQUAL_GREATER(17),

    /**
     * Checks if the players has already unlocked a specific scene area (currently only used in NPC groups/talks on official)
     * param [0]: scene id
     * param [1]: area id
     */
    QUEST_COND_SCENE_AREA_UNLOCKED(18),

    /**
     * TODO document specifics
     * (currently only used in talks on official)
     */
    QUEST_COND_ITEM_GIVING_ACTIVED(19),

    /**
     * TODO document specifics
     */
    QUEST_COND_ITEM_GIVING_FINISHED(20),

    /**
     * Checks if the current time is daytime (6:00 - 19:00)
     * param [0]: 1 if it should be daytime, 0 if its nighttime
     */
    QUEST_COND_IS_DAYTIME(21),

    /**
     * Checks if the players current avatar is the given avatar (currently unused on official)
     * param [0]: avatar id
     */
    QUEST_COND_CURRENT_AVATAR(22),

    /**
     * Checks if the players is currently in a specific area (currently unused on official)
     * param [0]: area id
     */
    QUEST_COND_CURRENT_AREA(23),

    /**
     * Checks if parent quests quest var has a specific value
     * param [0]: quest variable id
     * param [1]: the value to check for
     */
    QUEST_COND_QUEST_VAR_EQUAL(24),

    /**
     * Checks if parent quests quest var is greater than a specific value
     * param [0]: quest variable id
     * param [1]: the value to check against
     */
    QUEST_COND_QUEST_VAR_GREATER(25),

    /**
     * Checks if parent quests quest var is less than a specific value
     * param [0]: quest variable id
     * param [1]: the value to check against
     */
    QUEST_COND_QUEST_VAR_LESS(26),

    /**
     * Checks if the player has finished forge specific items in the queue (currently only used in NPC groups on official)
     * param [0]: 1 if the player should have finished items, 0 if not
     */
    QUEST_COND_FORGE_HAVE_FINISH(27),

    /**
     * Checks if a specific daily task/quest is currently in progress (currently only used in talks on official)
     * param [0]: daily task id (See DailyTaskExcelConfigData)
     */
    QUEST_COND_DAILY_TASK_IN_PROGRESS(28),

    /**
     * Checks if a specific daily task/quest has been finished (currently not used on official)
     * param [0]: daily task id (See DailyTaskExcelConfigData)
     */
    QUEST_COND_DAILY_TASK_FINISHED(29),

    /**
     * Checks if a specific activity condition has a specific state
     * param [0]: activity condition id, see [ActivityCondData]
     * param [1]: 1 if the activity condition state should be valid, 0 if not
     */
    QUEST_COND_ACTIVITY_COND(30),

    /**
     * Checks if a specific activity is currently opened (currently only used in NPC groups on official)
     * param [0]: activity id, see [ActivityData]
     */
    QUEST_COND_ACTIVITY_OPEN(31),

    /**
     * TODO document specifics
     */
    QUEST_COND_DAILY_TASK_VAR_GT(32),

    /**
     * TODO document specifics
     */
    QUEST_COND_DAILY_TASK_VAR_EQ(33),

    /**
     * TODO document specifics
     */
    QUEST_COND_DAILY_TASK_VAR_LT(34),

    /**
     * TODO document specifics
     * (currently unused on official)
     */
    QUEST_COND_BARGAIN_ITEM_GT(35),

    /**
     * TODO document specifics
     * (currently unused on official)
     */
    QUEST_COND_BARGAIN_ITEM_EQ(36),

    /**
     * TODO document specifics
     * (currently unused on official)
     */
    QUEST_COND_BARGAIN_ITEM_LT(37),

    /**
     * Checks if the player has completed a specific talk during the quest
     * param [0]: talk id to check for, see [TalkData]
     * param [1]: unknown, sometimes 3, mostly 0
     */
    QUEST_COND_COMPLETE_TALK(38),

    /**
     * TODO document specifics
     * (currently only used in NPC groups on official)
     */
    QUEST_COND_NOT_HAVE_BLOSSOM_TALK(39),

    /**
     * TODO document specifics
     * (currently only used in blossom groups on official)
     */
    QUEST_COND_IS_CUR_BLOSSOM_TALK(40),

    /**
     * TODO document specifics
     */
    QUEST_COND_QUEST_NOT_RECEIVE(41),

    /**
     * TODO document specifics
     * (currently only used in NPC groups on official)
     */
    QUEST_COND_QUEST_SERVER_COND_VALID(42),

    /**
     * TODO document specifics
     * (currently only used in NPC and Activity groups on official)
     */
    QUEST_COND_ACTIVITY_CLIENT_COND(43),

    /**
     * TODO document specifics
     */
    QUEST_COND_QUEST_GLOBAL_VAR_EQUAL(44),

    /**
     * TODO document specifics
     */
    QUEST_COND_QUEST_GLOBALv_VAR_GREATER(45),

    /**
     * TODO document specifics
     */
    QUEST_COND_QUEST_GLOBAL_VAR_LESS(46),

    /**
     * TODO document specifics
     */
    QUEST_COND_PERSONAL_LINE_UNLOCK(47),

    /**
     * TODO document specifics
     */
    QUEST_COND_CITY_REPUTATION_REQUEST(48),

    /**
     * TODO document specifics
     */
    QUEST_COND_MAIN_COOP_START(49),

    /**
     * TODO document specifics
     */
    QUEST_COND_MAIN_COOP_ENTER_SAVE_POINT(50),

    /**
     * TODO document specifics
     * (currently only used in NPC groups on official)
     */
    QUEST_COND_CITY_REPUTATION_LEVEL(51),

    /**
     * TODO document specifics
     * (currently unused on official)
     */
    QUEST_COND_CITY_REPUTATION_UNLOCK(52),

    /**
     * TODO document specifics
     */
    QUEST_COND_LUA_NOTIFY(53),

    /**
     * TODO document specifics
     */
    QUEST_COND_CUR_CLIMATE(54),

    /**
     * TODO document specifics
     */
    QUEST_COND_ACTIVITY_END(55),

    /**
     * TODO document specifics
     * (currently unused on official)
     */
    QUEST_COND_COOP_POINT_RUNNING(56),

    /**
     * TODO document specifics
     */
    QUEST_COND_GADGET_TALK_STATE_EQUAL(57), // only Gadget groups

    /**
     * TODO document specifics
     * (currently only used in NPC groups/Talks on official)
     */
    QUEST_COND_AVATAR_FETTER_GT(58),

    /**
     * TODO document specifics
     * (currently only used in Talks on official)
     */
    QUEST_COND_AVATAR_FETTER_EQ(59),

    /**
     * TODO document specifics
     * (currently only used in Talks on official)
     */
    QUEST_COND_AVATAR_FETTER_LT(60),

    /**
     * TODO document specifics
     * (currently only used in gadget groups on official)
     */
    QUEST_COND_NEW_HOMEWORLD_MOUDLE_UNLOCK(61),

    /**
     * TODO document specifics
     * (currently only used in gadget groups on official)
     */
    QUEST_COND_NEW_HOMEWORLD_LEVEL_REWARD(62),

    /**
     * TODO document specifics
     * (currently only used in gadget groups on official)
     */
    QUEST_COND_NEW_HOMEWORLD_MAKE_FINISH(63),

    /**
     * TODO document specifics
     * (currently only used in NPC groups on official)
     */
    QUEST_COND_HOMEWORLD_NPC_EVENT(64),

    /**
     * TODO document specifics
     * (currently unused on official)
     */
    QUEST_COND_TIME_VAR_GT_EQ(65),

    /**
     * TODO document specifics
     */
    QUEST_COND_TIME_VAR_PASS_DAY(66),

    /**
     * TODO document specifics
     * (currently only used in NPC groups on official)
     */
    QUEST_COND_HOMEWORLD_NPC_NEW_TALK(67),

    /**
     * TODO document specifics
     * (currently only used in talks on official)
     */
    QUEST_COND_PLAYER_CHOOSE_MALE(68),

    /**
     * TODO document specifics
     */
    QUEST_COND_HISTORY_GOT_ANY_ITEM(69),

    /**
     * TODO document specifics
     * (currently unused on official)
     */
    QUEST_COND_LEARNED_RECIPE(70),

    /**
     * TODO document specifics
     * (currently only used in NPC groups on official)
     */
    QUEST_COND_LUNARITE_REGION_UNLOCKED(71),

    /**
     * TODO document specifics
     * (currently only used in NPC groups on official)
     */
    QUEST_COND_LUNARITE_HAS_REGION_HINT_COUNT(72),

    /**
     * TODO document specifics
     * (currently only used in NPC groups on official)
     */
    QUEST_COND_LUNARITE_COLLECT_FINISH(73),

    /**
     * TODO document specifics
     * (currently only used in NPC groups on official)
     */
    QUEST_COND_LUNARITE_MARK_ALL_FINISH(74),

    /**
     * TODO document specifics
     * (currently only used in gadget groups on official)
     */
    QUEST_COND_NEW_HOMEWORLD_SHOP_ITEM(75),

    /**
     * TODO document specifics
     * (currently only used in NPC groups on official)
     */
    QUEST_COND_SCENE_POINT_UNLOCK(76),

    /**
     * TODO document specifics
     */
    QUEST_COND_SCENE_LEVEL_TAG_EQ(77),

    /**
     * TODO document specifics
     */
    QUEST_COND_PLAYER_ENTER_REGION(78),

    /**
     * TODO document specifics
     */
    QUEST_COND_ACTIVITY_SCHEDULE_OPEN_AND_COND(79),

    /**
     * TODO document specifics
     */
    QUEST_COND_ARANARA_COLLECTION_STATE_EQ(80),

    /**
     * TODO document specifics
     */
    QUEST_COND_INFERENCE_FINISH_PAGE_CONCLUSION(81),

    /**
     * TODO document specifics
     */
    QUEST_COND_SCENE_LEVEL_TAG_VALID(82),

    /**
     * TODO document specifics
     */
    QUEST_COND_NEW_HOMEWORLD_WOOD_EXCHANGE_UNLOCK(83),

    /**
     * TODO document specifics
     */
    QUEST_COND_IN_CITY(84),

    /**
     * TODO document specifics
     */
    QUEST_COND_GCG_EXP_OVERFLOW(86),

    /**
     * TODO document specifics
     */
    QUEST_COND_GCG_NPC_TYPE(87),

    /**
     * TODO document specifics
     */
    QUEST_COND_ACTIVITY_NEW_FUNGUS_CAPTURE(88),

    /**
     * TODO document specifics
     */
    QUEST_COND_GCG_LEVEL_REWARD_CAN_TAKE(89),

    /**
     * TODO document specifics
     */
    QUEST_COND_GCG_SHOP_NEW_GOODS(90),

    /**
     * TODO document specifics
     */
    QUEST_COND_GCG_CHALLENGE_NEW_BOSS(91),

    /**
     * TODO document specifics
     */
    QUEST_COND_GCG_CHALLENGE_NEW_CHAR(92),

    /**
     * TODO document specifics
     */
    QUEST_COND_GCG_LEVEL_UNLOCKED(93),

    /**
     * TODO document specifics
     */
    QUEST_COND_GCG_WORLD_CHALLENGE_RESULT(94),

    /**
     * TODO document specifics
     */
    QUEST_COND_HIT_WANDERER_RENAME_EASTER_EGG(95),

    /**
     * TODO document specifics
     */
    QUEST_COND_HIT_KEYWORD_EASTER_EGG(96),

    /**
     * TODO document specifics
     */
    QUEST_COND_GCG_INVITE_TYPE(97),

    /**
     * TODO document specifics
     */
    QUEST_COND_TMPVALUE_HIT_NICKNAME(98),

    /**
     * TODO document specifics
     */
    QUEST_COND_PACK_HAVE_ANY_ITEM(99),

    /**
     * TODO document specifics
     */
    QUEST_COND_OFFERING_PARI_NEW(100),

    /**
     * TODO document specifics
     */
    QUEST_COND_ACTIVITY_AKA_FES_REASONING_QUEST_NUM(101),

    /**
     * TODO document specifics
     */
    QUEST_COND_ACTIVITY_JOURNEY_GCG_PICK_STAGE_STATE_EQ(102),

    /**
     * TODO document specifics
     */
    QUEST_COND_ACTIVITY_GCG_PVE_HARD_REFRESH(103),

    /**
     * TODO document specifics
     */
    QUEST_COND_ACTIVITY_GCG_PVE_HARD_REWARD_CAN_TAKE(104),

    /**
     * TODO document specifics
     */
    QUEST_COND_ACTIVITY_GCG_PVE_INFINITE_REFRESH(108),

    /**
     * TODO document specifics
     */
    QUEST_COND_ACTIVITY_GCG_PVE_INFINITE_REWARD_CAN_TAKE(109),

    /**
     * TODO document specifics
     */
    QUEST_COND_STATE_INTERVAL (110),

    /**
     * TODO document specifics
     */
    QUEST_COND_ACTIVITY_GCG_PVE_PUZZLE_REFRESH (111),

    /**
     * TODO document specifics
     */
    QUEST_COND_ACTIVITY_GCG_PVE_PUZZLE_REWARD_CAN_TAKE (112),

    /**
     * TODO document specifics
     */
    QUEST_COND_ACHIEVEMENT_STATE_EQUAL (113),

    /**
     * TODO document specifics
     */
    QUEST_COND_ITEM_NUM_EQUAL (114),

    /**
     * TODO document specifics
     */
    QUEST_COND_ITEM_NUM_GREATER (115),

    /**
     * TODO document specifics
     */
    QUEST_COND_ITEM_NUM_LESS (116),

    /**
     * TODO document specifics
     */
    QUEST_COND_QUEST_VAR_NOT_EQUAL (117),

    /**
     * TODO document specifics
     */
    QUEST_COND_QUEST_GLOBAL_VAR_NOT_EQUAL (118),

    /**
     * TODO document specifics
     */
    QUEST_COND_QUEST_STATE_NOT_EQUAL (119),

    /**
     * TODO document specifics
     */
    QUEST_COND_WEAPON_IS_ARKHE_OUSIA_OR_PNEUMA (120),

    /**
     * TODO document specifics
     */
    QUEST_COND_ACTIVITY_BLESSING_V2_HAVE_REWARD (121),

    /**
     * TODO document specifics
     */
    QUEST_COND_HOMEWORLD_COIN_REACH_MAXIMUM (122),

    /**
     * TODO document specifics
     */
    QUEST_COND_QUEST_CHECK_RESULT (123),

    /**
     * TODO document specifics
     */
    QUEST_COND_ACTIVITY_NPC_BORN (124),

    /**
     * TODO document specifics
     */
    QUEST_COND_ACTIVITY_ALCHEMY_SIM_STATE (125),

    /**
     * TODO document specifics
     */
    QUEST_COND_ACTIVITY_ALCHEMY_SIM_EXAM_CAN_SUBMIT (126),

    /**
     * TODO document specifics
     */
    QUEST_COND_ACTIVITY_ALCHEMY_SIM_LOCK_STAGE (127),

    /**
     * TODO document specifics
     */
    QUEST_COND_FINISH_ROLE_COMBAT_ROUND (128),

    /**
     * TODO document specifics
     */
    QUEST_COND_QUEST_CHECK_VALUE (129),

    /**
     * TODO document specifics
     */
    QUEST_COND_ROLE_COMBAT_NPC_RANDOM_VALUE (130),

    /**
     * TODO document specifics
     */
    QUEST_COND_QUEST_CHECK_NOT_VALUE (131),

    /**
     * TODO document specifics
     */
    QUEST_COND_PRESENT_AT_SPECIFIC_SCENE (132),

    /**
     * TODO document specifics
     */
    QUEST_COND_PASS_ROLE_COMBAT_DIFFICULTY (133),

    /**
     * TODO document specifics
     */
    QUEST_COND_IN_VEHICLE (134),

    /**
     * TODO document specifics
     */
    QUEST_COND_TRIBAL_CHAPTER_UNLOCK (135),

    /**
     * TODO document specifics
     */
    QUEST_COND_PLAYER_LEAVE_REGION (137),

    /**
     * TODO document specifics
     */
    QUEST_COND_PLAYER_ENTER_CITY (138),

    /**
     * TODO document specifics
     */
    QUEST_COND_PLAYER_ENTER_FIRST_AREA (139),

    /**
     * TODO document specifics
     */
    QUEST_COND_PLAYER_ENTER_SECOND_AREA (140),

    /**
     * TODO document specifics
     */
    QUEST_COND_IN_VEHICLE_BY_FEATURETAG (141),

    /**
     * TODO document specifics
     */
    QUEST_COND_HAS_FINISH_MET_NPC (142),

    /**
     * TODO document specifics
     */
    QUEST_COND_PASS_ROLE_COMBAT_ROUND (143),

    /**
     * TODO document specifics
     */
    QUEST_COND_PACK_HAVE_ITEM_WITH_ID (144),

    /**
     * TODO document specifics
     */
    QUEST_COND_ABYSS_WAR_LEVEL_STATE_EQUAL (145),

    /**
     * TODO document specifics
     */
    QUEST_COND_ABYSS_WAR_ACCOUNT_DATA_IN_INTERVAL (146),

    /**
     * TODO document specifics
     */
    QUEST_COND_ROLE_COMBAT_HAS_DIFFICULTY_LEVEL (147),

    /**
     * TODO document specifics
     */
    QUEST_COND_GROUP_GADGET_STATE_EQUALS (148),

    /**
     * TODO document specifics
     */
    QUEST_COND_INSTRUMENT_TRIAL (150),

    /**
     * TODO document specifics
     */
    QUEST_COND_ACTIVITY_CUSTOM (151),

    /**
     * TODO document specifics
     */
    QUEST_COND_FINISH_ANY_LEY_LINE_CHALLENGE (152),

    /**
     * TODO document specifics
     */
    QUEST_COND_OPEN_STATE_EQUAL_V2(153),

    /**
     * TODO document specifics
     */
    QUEST_COND_FLOWER_TASK_ACTIVE(154),

    /**
     * TODO document specifics
     */
    QUEST_COND_WORLD_LEVEL_REACH(155),

    /**
     * TODO document specifics
     */
    QUEST_COND_PLAYER_HAVE_AVATAR(156),

    /**
     * TODO document specifics
     */
    QUEST_COND_PLAYER_CURRENT_AVATAR(157),

    /**
     * TODO document specifics
     */
    QUEST_COND_PLAYER_CURRENT_NOT_AVATAR(158),

    /**
     * TODO document specifics
     */
    QUEST_COND_PLAYER_TEAM_CONTAINS_AVATAR(159),

    /**
     * TODO document specifics
     */
    QUEST_COND_PLAYER_TEAM_NOT_CONTAINS_AVATAR(160),

    /**
     * TODO document specifics
     */
    QUEST_COND_STORY_GLOBAL_VALUE(161),

    /**
     * TODO document specifics
     */
    QUEST_COND_TIME_VAR_PASS_REFRESH_POLICY(162),

    /**
     * TODO document specifics
     */
    QUEST_COND_GALLANT_PATH_REWARD_CAN_GET(163),

    /**
     * TODO document specifics
     */
    QUEST_COND_SHOP_NEW_FORMULA_GOODS(164),

    /**
     * TODO document specifics
     */
    QUEST_COND_SHOP_NEW_GADGET_GOODS(165),

    /**
     * An unknown condition type, check the representation string to get the missing enum values name
     */
    QUEST_COND_UNKNOWN(9999);

    override fun getIntKey() = id
}