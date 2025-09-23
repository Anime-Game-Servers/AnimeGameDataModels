package org.anime_game_servers.game_data_models.gi.data.quest

import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.dungeon.DungeonData
import org.anime_game_servers.game_data_models.gi.data.item.MaterialType

enum class QuestContentType(val id: Int) : IntKey {
    QUEST_CONTENT_NONE(0),

    /**
     * Same as [QUEST_CONTENT_MONSTER_DIE]
     * param [0]: monsterId of a monster that got killed
     * (currently unused on official, handling is guessed)
     */
    QUEST_CONTENT_KILL_MONSTER(1),

    /**
     * Gets triggered when the client sends a [NpcTalkReq] packet
     * param [0]: The id of the talk
     */
    QUEST_CONTENT_COMPLETE_TALK(2),

    /**
     * Gets triggered when a monster dies
     * param [0]: monsterId of a monster that got killed
     */
    QUEST_CONTENT_MONSTER_DIE(3),

    /**
     * Gets triggered by the client via [AddQuestContentProgressReq] when a plot is finished
     * param [0]: plotId of a plot that got finished
     */
    QUEST_CONTENT_FINISH_PLOT(4),

    /**
     * Gets triggered whenever the player obtains an item
     * param [0]: itemId of an item that should be obtained
     * param [1]: amount of the item that should be obtained
     */
    QUEST_CONTENT_OBTAIN_ITEM(5),

    /**
     * Gets triggered from the Lua handling, when a trigger gets fired that is defined in [TriggerData]
     * param [0]: triggerId from [TriggerData] of a trigger that got fired
     */
    QUEST_CONTENT_TRIGGER_FIRE(6),

    /**
     * Gets triggered when all monsters from a group where killed
     * param [0]: groupId of a group that should be cleared
     */
    QUEST_CONTENT_CLEAR_GROUP_MONSTER(7),

    /**
     * Gets triggered by the client via [AddQuestContentProgressReq] when a plot failed to finish
     * param [0]: plotId of a plot that failed to be finished
     */
    QUEST_CONTENT_NOT_FINISH_PLOT(8),

    /**
     * Gets triggered when the player enters a dungeon/domain
     * This might also trigger the server to add the Dungeon to the list of dungeons at that specific ScenePoint
     * param [0]: dungeonId of a dungeon that got entered from [DungeonData]
     * param [1]: ScenePoint from which the player should enter the dungeon
     */
    QUEST_CONTENT_ENTER_DUNGEON(9),

    /**
     * Gets triggered when the player enters the specified scene in his own instance
     * Difference to [QUEST_CONTENT_ENTER_MY_WORLD_SCENE] is unknown
     * param [0]: sceneId of a scene that should be entered
     */
    QUEST_CONTENT_ENTER_MY_WORLD(10),

    /**
     * Gets triggered when the player successfully completes a dungeon
     * param [0]: dungeonId of a dungeon that should be completed
     *            see also [DungeonData]
     */
    QUEST_CONTENT_FINISH_DUNGEON(11),

    /**
     * Gets triggered whenever a gadgetEntity gets destroyed
     * param [0]: gadgetId of a gadgetEntity that should be destroyed
     */
    QUEST_CONTENT_DESTROY_GADGET(12),

    /**
     * Gets triggered for every item collected and checks the type of the item
     * param [0]: the int representation of a [MaterialType]
     */
    QUEST_CONTENT_OBTAIN_MATERIAL_WITH_SUBTYPE(13),

    /**
     * TODO document specifics
     * (currently unused on official)
     */
    QUEST_CONTENT_NICK_NAME(14),

    /**
     * TODO document specifics
     * (currently unused on official)
     */
    QUEST_CONTENT_WORKTOP_SELECT(15),

    /**
     * TODO document specifics
     * (currently unused on official)
     */
    QUEST_CONTENT_SEAL_BATTLE_RESULT(16),

    /**
     * Gets triggered when the player enters a scene of the type room
     * param [0]: sceneId of a room scene that should be entered
     */
    QUEST_CONTENT_ENTER_ROOM(17),

    /**
     * Gets triggered every second on the game tick of the server. A tick equals one in game minute
     * param [0]: amount of in game days that should be completed since the start of the quest
     * paramsString: contains the start and end hour of the day that should be targeted
     *         the format is `[startHour],[endHour]`
     *         if endHour is smaller than startHour, while days to pass is bigger than 0,
     *         and currentHour is smaller than endHour, we need to pass it one extra time
     */
    QUEST_CONTENT_GAME_TIME_TICK(18),

    /**
     * Gets triggered when the player fails a dungeon
     * param [0]: dungeonId of a dungeon that should be failed.
     *            see also [DungeonData]
     */
    QUEST_CONTENT_FAIL_DUNGEON(19),

    /**
     * This gets triggered from ScriptLib via [AddQuestProgress] method
     * paramString: Contains the name of the notify that gets passed to it
     */
    QUEST_CONTENT_LUA_NOTIFY(20),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_TEAM_DEAD(21),

    /**
     * Gets triggered when the client sends a [NpcTalkReq] packet
     * paramString: contains the ids of talks separated by ','. Any of these can be triggered to complete this
     */
    QUEST_CONTENT_COMPLETE_ANY_TALK(22),

    /**
     * Gets triggered whenever the player unlocks a new transportation point
     * param [0]: sceneId of a scene containing the transportation point
     * param [1]: scenePointId of the transportation point
     */
    QUEST_CONTENT_UNLOCK_TRANS_POINT(23),

    /**
     * Get triggered via [QuestExecType.QUEST_EXEC_ADD_QUEST_PROGRESS]
     * param [0]: The id of progress to add
     */
    QUEST_CONTENT_ADD_QUEST_PROGRESS(24),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_INTERACT_GADGET(25),

    /**
     * TODO document specifics
     * (currently unused on official)
     */
    QUEST_CONTENT_DAILY_TASK_COMP_FINISH(26),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_FINISH_ITEM_GIVING(27),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_SKILL(107),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_CITY_LEVEL_UP(109),

    /**
     * TODO document specifics
     * (currently used in random quests on official)
     */
    QUEST_CONTENT_PATTERN_GROUP_CLEAR_MONSTER(110),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_ITEM_LESS_THAN(111),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_PLAYER_LEVEL_UP(112),

    /**
     * TODO document specifics
     * (currently unused on official)
     */
    QUEST_CONTENT_DUNGEON_OPEN_STATUE(113),

    /**
     * TODO document specifics
     * (currently unused on official)
     */
    QUEST_CONTENT_UNLOCK_AREA(114),

    /**
     * TODO document specifics
     * (currently unused on official)
     */
    QUEST_CONTENT_OPEN_CHEST_WITH_GADGET_ID(115),

    /**
     * TODO document specifics
     * (currently unused on official)
     */
    QUEST_CONTENT_UNLOCK_TRANS_POINT_WITH_TYPE(116),

    /**
     * TODO document specifics
     * (currently unused on official)
     */
    QUEST_CONTENT_FINISH_DAILY_DUNGEON(117),

    /**
     * TODO document specifics
     * (currently unused on official)
     */
    QUEST_CONTENT_FINISH_WEEKLY_DUNGEON(118),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_QUEST_VAR_EQUAL(119),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_QUEST_VAR_GREATER(120),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_QUEST_VAR_LESS(121),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_OBTAIN_VARIOUS_ITEM(122),

    /**
     * TODO document specifics
     * (currently unused on official)
     */
    QUEST_CONTENT_FINISH_TOWER_LEVEL(123),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_BARGAIN_SUCC(124),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_BARGAIN_FAIL(125),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_ITEM_LESS_THAN_BARGAIN(126),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_ACTIVITY_TRIGGER_FAILED(127),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_MAIN_COOP_ENTER_SAVE_POINT(128),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_ANY_MANUAL_TRANSPORT(129),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_USE_ITEM(130),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_MAIN_COOP_ENTER_ANY_SAVE_POINT(131),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_ENTER_MY_HOME_WORLD(132),

    /**
     * Gets triggered when the player enters the specified scene in his own instance
     * Difference to [QUEST_CONTENT_ENTER_MY_WORLD] is unknown
     * param [0]: sceneId of a scene that should be entered
     */
    QUEST_CONTENT_ENTER_MY_WORLD_SCENE(133),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_TIME_VAR_GT_EQ(134),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_TIME_VAR_PASS_DAY(135),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_QUEST_STATE_EQUAL(136),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_QUEST_STATE_NOT_EQUAL(137),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_UNLOCKED_RECIPE(138),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_NOT_UNLOCKED_RECIPE(139),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_FISHING_SUCC(140),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_ENTER_ROGUE_DUNGEON(141),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_USE_WIDGET(142),

    /**
     * TODO document specifics
     * (currently unused on official)
     */
    QUEST_CONTENT_CAPTURE_SUCC(143),

    /**
     * TODO document specifics
     * (currently unused on official)
     */
    QUEST_CONTENT_CAPTURE_USE_CAPTURETAG_LIST(144),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_CAPTURE_USE_MATERIAL_LIST(145),

    /**
     * Gets triggered whenever the player enters a vehicle.
     * params[0] = vehicle id the player should enter or 0 for any vehicle
     */
    QUEST_CONTENT_ENTER_VEHICLE(147),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_SCENE_LEVEL_TAG_EQ(148),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_LEAVE_SCENE(149),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_LEAVE_SCENE_RANGE(150),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_IRODORI_FINISH_FLOWER_COMBINATION(151),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_IRODORI_POETRY_REACH_MIN_PROGRESS(152),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_IRODORI_POETRY_FINISH_FILL_POETRY(153),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_ACTIVITY_TRIGGER_UPDATE(154),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_GADGET_STATE_CHANGE(155),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_LEAVE_SCENE_RANGE_AND_ROOM(156),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_GCG_LEVEL_WIN(157),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_AVATAR_RENAME_COMPLETE(158),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_GCG_GUIDE_PROGRESS(159),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_QUEST_GLOBAL_VAR_EQUAL(160),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_QUEST_GLOBAL_VAR_GREATER(161),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_QUEST_GLOBAL_VAR_LESS(162),
    
    /**
     * TODO document specifics
     */
    QUEST_CONTENT_ACHIEVEMENT_ISACHIEVED (163),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_EVENTS_ITEM_STATUS (164),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_ACHIEVEMENT_STATE_EQUAL (165),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_EXHIBITION_ACCUMULATE_GT_EQ (166),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_UNLOCK_ANY_TRANS_POINT (167),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_ITEM_NUM_EQUAL (168),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_ITEM_NUM_GREATER (169),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_ITEM_NUM_LESS (170),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_QUEST_VAR_NOT_EQUAL (171),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_QUEST_GLOBAL_VAR_NOT_EQUAL (172),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_SHOP_SELL_OUT (173),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_QUEST_CHECK_EQUAL (174),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_QUEST_CHECK_VALUE (175),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_PRESENT_AT_SPECIFIC_SCENE (177),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_MISC_RENAME_COMPLETE (179),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_ENTER_FEATURE_TAG_VEHICLE (180),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_LEAVE_FEATURE_TAG_VEHICLE (181),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_LEAVE_VEHICLE (182),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_ABYSS_WAR_LEVEL_STATE_EQUAL (183),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_ABYSS_WAR_ACCOUNT_DATA_IN_INTERVAL (184),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_ABYSS_WAR_LIMIT_REIGON_STATE_EQUAL (185),

    /**
     * TODO document specifics
     */
    QUEST_CONTENT_PARENT_QUEST_STATE_EQUAL (186),
    
    /**
     * TODO document specifics
     */
    QUEST_CONTENT_PLAYER_HAVE_AVATAR(187),
    
    /**
     * TODO document specifics
     */
    QUEST_CONTENT_FINISH_ANY_FOOD_COOK(188),
    
    /**
     * TODO document specifics
     */
    QUEST_CONTENT_TIME_VAR_PASS_REFRESH_POLICY(189),

    /**
     * An unknown condition type, check the representation string to get the missing enum values name
     */
    QUEST_CONTENT_UNKNOWN(9999);

    override fun getIntKey() = id
}