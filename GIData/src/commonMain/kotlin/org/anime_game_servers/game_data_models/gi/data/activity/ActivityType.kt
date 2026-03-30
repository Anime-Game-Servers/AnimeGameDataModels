package org.anime_game_servers.game_data_models.gi.data.activity

import org.anime_game_servers.core.base.annotations.AddedIn
import org.anime_game_servers.core.base.interfaces.IntKey

import org.anime_game_servers.game_data_models.gi.data.activity.echo_shell.EchoShellData
import org.anime_game_servers.game_data_models.gi.data.activity.echo_shell.EchoShellFloatSignalData
import org.anime_game_servers.game_data_models.gi.data.activity.echo_shell.EchoShellPreviewData
import org.anime_game_servers.game_data_models.gi.data.activity.echo_shell.EchoShellRewardData
import org.anime_game_servers.game_data_models.gi.data.activity.echo_shell.EchoShellSummerTimeDungeonData

/**
 * Only one activity per type is allowed to be active at the same time
 * TODO fully document
 */
enum class ActivityType(val id: Int) : IntKey {
    NEW_ACTIVITY_GENERAL(0),

    // TODO document used models
    /**
     * Closed beta (CB2) lantern rite has its own activity specific packages.
     *
     * This event also uses special activity groups in `Activity/1001/`
     * @since 1.0
     */
    NEW_ACTIVITY_SEA_LAMP(1),

    // TODO document used models
    /**
     * The elemental crucible event: [see here](https://genshin-impact.fandom.com/wiki/Elemental_Crucible)
     * From here on the normal activity info packages are used.
     *
     * Some instances of this event use special activity groups in `Activity/5001/`
     * @since 1.0
     */
    NEW_ACTIVITY_CRUCIBLE(2),

    // TODO document used models
    /**
     * The Marvelous Merchandise event: [first occurrence see here](https://genshin-impact.fandom.com/wiki/Marvelous_Merchandise/2020-10-26)
     *
     * This event also uses special activity groups in `Activity/5003/`
     * @see NEW_ACTIVITY_SALESMAN_MP For the newer version
     * @since 1.0
     */
    NEW_ACTIVITY_SALESMAN(3),

    // TODO document used models
    /**
     * This is the Character Trial Event: [see here](https://genshin-impact.fandom.com/wiki/Test_Run_-_Character_Trial_Event)
     *
     * This event also uses special activity groups in `Activity/5002/`
     * @since 1.0
     */
    NEW_ACTIVITY_TRIAL_AVATAR(4),

    // TODO document used models
    /**
     * This is the info/login bonus banner for multiple events.
     *
     * This includes:
     * * 1.0, 1.1, 1.2 "[Seize the Day](https://genshin-impact.fandom.com/wiki/Seize_the_Day)"
     * * 1.3 "[May Fortune Find You](https://genshin-impact.fandom.com/wiki/May_Fortune_Find_You/2021-02-11)"
     * * 1.4 "[Outland Gastronomy](https://genshin-impact.fandom.com/wiki/Outland_Gastronomy)"
     * * 2.1 "[Passage of Clouds and Stars](https://genshin-impact.fandom.com/wiki/Passage_of_Clouds_and_Stars)"
     * * 2.4 "[May Fortune Find You](https://genshin-impact.fandom.com/wiki/May_Fortune_Find_You/2022-01-25)"
     * * 3.1 "[Path of Gleaming Jade](https://genshin-impact.fandom.com/wiki/Path_of_Gleaming_Jade)"
     * * 3.4 "[May Fortune Find You](https://genshin-impact.fandom.com/wiki/May_Fortune_Find_You/2023-01-19)"
     * * 4.1 "[Bathing in Flowing Moonlight](https://genshin-impact.fandom.com/wiki/Bathing_in_Flowing_Moonlight)"
     * * 5.0 "[Brilliant Dawn](https://genshin-impact.fandom.com/wiki/Brilliant_Dawn)"
     * * 6.0 "[Rainbow's End: Silvery Flux](https://genshin-impact.fandom.com/wiki/Rainbow%27s_End:_Silvery_Flux)"
     * * 6.3 "[May Fortune Find You](https://genshin-impact.fandom.com/wiki/May_Fortune_Find_You/2026-01-16)"
     *
     * unused/unidentified:
     * * 10001: （test）1.0签到
     * * 10002: (test)高价值一次性签到
     * * 10005: Rainbow's End
     * * 10006: Rainbow's End
     * * 10007: Rainbow's End
     * @since 1.0
     */
    NEW_ACTIVITY_SIGNIN(5),

    // TODO document used models
    /**
     * This is for multiple bonus/info banners
     *
     * This includes:
     * * 1.0+ "[People's Choice](https://genshin-impact.fandom.com/wiki/People's_Choice)"
     * * 1.1+ "[Baptism of Song](https://genshin-impact.fandom.com/wiki/Baptism_of_Song)"
     * * 3.1+ "[Curtain of Leaves](https://genshin-impact.fandom.com/wiki/Curtain_of_Leaves)"
     * * 4.0+ "[The Curtain Never Falls on Magic](https://genshin-impact.fandom.com/wiki/The_Curtain_Never_Falls_on_Magic)"
     * * 6.2+ "[Witch's Homework](https://genshin-impact.fandom.com/wiki/Witch's_Homework_(Event))"
     * @since 1.0
     */
    NEW_ACTIVITY_BONUS(6),

    // TODO document used models
    /**
     * This is the "[Fate Foretold](https://genshin-impact.fandom.com/wiki/Fate_Foretold)" info banner
     * @since 1.0
     */
    NEW_ACTIVITY_NEWBEEBONUS(7),

    // TODO document used models
    /**
     * This is used for showing activity/event banners for new storylines
     * @since 1.0
     */
    NEW_ACTIVITY_PERSONAL_LIINE(8),

    // TODO document used models
    /**
     * This is the "[While It's Watm](https://genshin-impact.fandom.com/wiki/While_It%27s_Warm)" event.
     * @since 1.1
     */
    NEW_ACTIVITY_DELIVERY(9),

    // TODO document used models
    /**
     * This is the "[Gliding Challenge](https://genshin-impact.fandom.com/wiki/Gliding_Challenge)" event.
     *
     * This event also uses special activity groups in `Activity/5007/`
     *
     * @since 1.1
     */
    NEW_ACTIVITY_FLIGHT(10),

    /**
     * TODO identify this activity, it doesn't have an entry in NewActivityExcelConfigData, probably some type of placeholder
     */
    NEW_ACTIVITY_TEMP(99),

    // TODO document used models
    /**
     * This is the 1.1 flagship event [Unreconciled Stars](https://genshin-impact.fandom.com/wiki/Unreconciled_Stars).
     *
     * This event also uses special activity groups in `Activity/2001/`
     * @since 1.1
     */
    NEW_ACTIVITY_ASTER(1100),

    // TODO document used models
    /**
     * The 1.2 flagship event "[The Chalk Prince and the Dragon](https://genshin-impact.fandom.com/wiki/The_Chalk_Prince_and_the_Dragon)" was
     * a dragon spine event.
     *
     * This event also uses special activity groups in `Activity/3001/`
     * @since 1.2
     */
    NEW_ACTIVITY_DRAGONSPINE(1200),

    // TODO document used models
    /**
     * This is the "[Stellar Reunion](https://genshin-impact.fandom.com/wiki/Stellar_Reunion)" event banner
     * @since 1.2
     */
    NEW_ACTIVITY_REUNION(1201),

    // TODO document used models
    /**
     * This is used for two 1.x boss events:
     * * 1.2 "[Hypostatic Symphony](https://genshin-impact.fandom.com/wiki/Hypostatic_Symphony/2021-01-16)"
     * * 1.6 "[Legend of the Vagabond Sword](https://genshin-impact.fandom.com/wiki/Legend_of_the_Vagabond_Sword)"
     * @see NEW_ACTIVITY_EFFIGY_CHALLENGE_V2 for the 3.2 "Hypostatic Symphony: Dissonant Verse"
     * @see NEW_ACTIVITY_EFFIGY_CHALLENGE_V4 For the 3.7 "Feast of the Departed Warriors" event
     * @see NEW_ACTIVITY_EFFIGY_CHALLENGE_V5 For the 4.6 "Specially-Shaped Saurian Search" and 5.3 "On the Trail of Behemoths" events
     * @since 1.2
     */
    NEW_ACTIVITY_EFFIGY(1202),

    // TODO document used models
    /**
     * This is the "[Moment of Syzygy](https://genshin-impact.fandom.com/wiki/Spiral_Abyss)" Banner for the Spiral Abyss reset
     * @since 1.2
     */
    NEW_ACTIVITY_TOWER_RESET(1203),

    // TODO document used models
    /**
     * This is the "[Lost Riches](https://genshin-impact.fandom.com/wiki/Lost_Riches)" Event, first run during 1.2
     * This is the 2.0 "[Lost Riches](https://genshin-impact.fandom.com/wiki/Lost_Riches/2021-08-06) event as well.
     *
     * Some instances of this event also use special activity groups in `Activity/5011/`
     * @see NEW_ACTIVITY_TREASURE_SEELIE for the 3.0 version
     * @see NEW_ACTIVITY_TREASURE_HUNT_V4 for the 4.3 version
     * @since 1.2
     */
    NEW_ACTIVITY_TREASURE_MAP(1204),

    // TODO document used models
    // TODO identify the differences  between both salesman activities
    /**
     * This is a newer version of "[Marvelous Merchandise](https://genshin-impact.fandom.com/wiki/Marvelous_Merchandise)"
     *
     * This event also uses special activity groups in `Activity/5012/`
     * @see NEW_ACTIVITY_SALESMAN For the older version
     * @since 1.2
     */
    NEW_ACTIVITY_SALESMAN_MP(1205),

    // TODO document used models
    /**
     * This is the 1.3 "[Five Flushes of Fortune](https://genshin-impact.fandom.com/wiki/Five_Flushes_of_Fortune)" Event
     * @since 1.3
     */
    NEW_ACTIVITY_BLESSING(1300),

    // TODO document used models
    /**
     * This events first occurrence was the 1.3 "[Vishaps and Where to Find Them](https://genshin-impact.fandom.com/wiki/Vishaps_and_Where_to_Find_Them)" event.
     * Other occurrences are:
     * * "[Spectral Secrets](https://genshin-impact.fandom.com/wiki/Spectral_Secrets)" event from version 2.1.
     * @since 1.3
     */
    NEW_ACTIVITY_EXPEDITION(1301),

    // TODO document used models
    /**
     * This is the 1.3 flagship event "[Lantern Rite](https://genshin-impact.fandom.com/wiki/Lantern_Rite)".
     *
     * This event also uses special activity groups in `Activity/2002/`
     * @since 1.3
     */
    NEW_ACTIVITY_SEA_LAMP_NEW(1302),

    // TODO document used models
    /**
     * This is the 1.4 flagship event "[Invitation of Windblume](https://genshin-impact.fandom.com/wiki/Invitation_of_Windblume)".
     *
     * This event also uses special activity groups in `Activity/2003/`
     * @since 1.4
     */
    NEW_ACTIVITY_FLEUR_FAIR(1400),

    // TODO document used models
    // TODO identify this activity, it doesn't have an entry in NewActivityExcelConfigData or NewActivityEntryConfigData
    /**
     * @since 1.4
     */
    NewActivityExcelConfigData(1401),

    // TODO document used models
    /**
     * This event first occurred during version 1.4 and includes multiple combat events.
     *
     * This includes:
     * * 1.4 "[Contending Tides](https://genshin-impact.fandom.com/wiki/Contending_Tides)"
     * * 2.0 "[Phantom Flow](https://genshin-impact.fandom.com/wiki/Phantom_Flow)"
     * * 2.8 "[Hidden Strife](https://genshin-impact.fandom.com/wiki/Hidden_Strife)"
     * * 4.0 "[Verdict of Blades](https://genshin-impact.fandom.com/wiki/Verdict_of_Blades)"
     * @since 1.4
     */
    NEW_ACTIVITY_ARENA_CHALLENGE(1402),

    // TODO document used models
    /**
     * This is the "[Wishful Drops](https://genshin-impact.fandom.com/wiki/Wishful_Drops)" Event
     * @since 1.4
     */
    NEW_ACTIVITY_WATER_SPIRIT_CHALLENGE(1403),

    // TODO document used models
    /**
     * Only has one use for activity 6003 with title "(test)红白签到附带"
     * @since 1.4
     */
    NEW_ACTIVITY_SIGNIN_COMPANION(1404),

    // TODO document used models
    /**
     * This is an announcement activity/event to inform the user about new [Handout Events](https://genshin-impact.fandom.com/wiki/Hangout_Event).
     *
     * Known occurrences include:
     * * [1.4 Hangout Events Series I](https://genshin-impact.fandom.com/wiki/Hangout_Event?file=Hangout_Events_Series_I.png),
     * * [1.5 Hangout Events Series II](https://genshin-impact.fandom.com/wiki/Hangout_Event?file=Hangout_Events_Series_II.png),
     * * [2.2 Hangout Events Series III](https://genshin-impact.fandom.com/wiki/Hangout_Event?file=Hangout_Events_Series_III.png),
     * * [2.3 Hangout Events Series IV](https://genshin-impact.fandom.com/wiki/Hangout_Event?file=Hangout_Events_Series_IV.png),
     * * [2.4 Hangout Events Series V](https://genshin-impact.fandom.com/wiki/Hangout_Event?file=Hangout_Events_Series_V.png),
     * * [2.7 Hangout Events Series VI](https://genshin-impact.fandom.com/wiki/Hangout_Event?file=Hangout_Events_Series_VI.png),
     * * [2.8 Hangout Events Series VII](https://genshin-impact.fandom.com/wiki/Hangout_Event?file=Hangout_Events_Series_VII.png),
     * * [3.5 Hangout Events Series VIII](https://genshin-impact.fandom.com/wiki/Hangout_Event?file=Hangout_Events_Series_VIII.png),
     * * [3.6 Hangout Events Series IX](https://genshin-impact.fandom.com/wiki/Hangout_Event?file=Hangout_Events_Series_IX.png),
     * * [3.7 Hangout Events Series X](https://genshin-impact.fandom.com/wiki/Hangout_Event?file=Hangout_Events_Series_X.png),
     * * [3.8 Hangout Events Series XI](https://genshin-impact.fandom.com/wiki/Hangout_Event?file=Hangout_Events_Series_XI.png),
     * * [4.5 Hangout Events Series XII](https://genshin-impact.fandom.com/wiki/Hangout_Event?file=Hangout_Events_Series_XII.png)
     * @since 1.4
     */
    NEW_ACTIVITY_COOP(1405),

    // TODO document used models
    /**
     * This is the 1.3 "[Even Mountains Tremble](https://genshin-impact.fandom.com/wiki/No_Restoring_This_Past_Land_of_Beauty#Even_Mountains_Tremble)" boss announcement banner
     * @since 1.3
     */
    NEW_ACTIVITY_MONSTER_BANNER_DRAKE_PRIMO_ROCK(1501),

    // TODO document used models
    /**
     * This is used for the 1.5 and 2.3 "[Energy Amplifier](https://genshin-impact.fandom.com/wiki/Energy_Amplifier)" events.
     *
     * This includes:
     * * 1.5 "[Energy Amplifier Initiation](https://genshin-impact.fandom.com/wiki/Energy_Amplifier/2021-04-30)"
     * * 2.3 "[Energy Amplifier Fruition](https://genshin-impact.fandom.com/wiki/Energy_Amplifier/2021-12-24)"
     * @see NEW_ACTIVITY_RECHARGE_DISK For the 4.8 "Energy Amplifier: Lemma"
     * @since 1.5
     */
    NEW_ACTIVITY_CHANNELER_SLAB(1502),

    // TODO document used models
    /**
     * These are the banners for the [Misty Dungeon](https://genshin-impact.fandom.com/wiki/Misty_Dungeon) events which started with 1.5
     *
     * This includes:
     * * 1.5 "[Battlefront: Misty Dungeon](https://genshin-impact.fandom.com/wiki/Battlefront:_Misty_Dungeon)"
     * * 2.3 "[Misty Dungeon: Realm of Light](https://genshin-impact.fandom.com/wiki/Misty_Dungeon/2021-12-17)"
     * * 3.3 "[Misty Dungeon: Realm of Sand](https://genshin-impact.fandom.com/wiki/Misty_Dungeon/2022-12-09)"
     * * 4.2 "[Misty Dungeon: Realm of Water](https://genshin-impact.fandom.com/wiki/Misty_Dungeon/2023-11-09)"
     * @since 1.5
     */
    NEW_ACTIVITY_MISTTRIAL(1503),

    // TODO document used models
    /**
     * This is the standalone "[Windtrace](https://genshin-impact.fandom.com/wiki/Windtrace)" Event for version 1.5 to 3.3
     * @since 1.5
     */
    NEW_ACTIVITY_HIDEANDSEEK(1504),

    // TODO document used models
    /**
     * This is the "[Mimi Tomo](https://genshin-impact.fandom.com/wiki/Mimi_Tomo)" Event, which first occurred during version 1.5
     * @since 1.5
     */
    NEW_ACTIVITY_FIND_HILICHURL(1505),

    // TODO document used models
    /**
     * this is the 1.5 "[Chilled to the Bone](https://genshin-impact.fandom.com/wiki/Cryo_Hypostasis?file=Chilled_to_the_Bone.png)" boss announcement banner
     * @since 1.5
     */
    NEW_ACTIVITY_MONSTER_BANNER_EFFIGY_ICE(1506),

    // TODO document used models
    /**
     * This is the "[A Teapot to Call Home](https://genshin-impact.fandom.com/wiki/A_Teapot_to_Call_Home:_Part_I)" announcement banner
     * @since 1.5
     */
    NEW_ACTIVITY_HOMEWORLD(1507),

    /**
     * TODO identify this activity, it doesn't have an entry in NewActivityExcelConfigData
     * @since 1.5
     */
    NEW_ACTIVITY_H5(1508),

    // TODO document used models
    /**
     * This is the 1.6 flagship event "[Midsummer Island Adventure](https://genshin-impact.fandom.com/wiki/Midsummer_Island_Adventure)".
     * In this event the player gets to visit the Golden Apple Archipelago. The tide level of the sea changes based on the
     * scene tags controlled by [ActivityCondData].
     * @since 1.6
     */
    NEW_ACTIVITY_SUMMER_TIME(1600),

    // TODO document used models
    /**
     * This is the "[Never-Ending Battle](https://genshin-impact.fandom.com/wiki/Never-Ending_Battle)" Event from version 1.6.
     * @since 1.6
     */
    NEW_ACTIVITY_BUOYANT_COMBAT(1601),

    /**
     * This event ran twice, once as [Echoing Tales](https://genshin-impact.fandom.com/wiki/Echoing_Tales) and once as
     * [Resonating Visions](https://genshin-impact.fandom.com/wiki/Resonating_Visions), both times accompanying the Summer Times events
     * [NEW_ACTIVITY_SUMMER_TIME] and [NEW_ACTIVITY_SUMMER_TIME_2_8].
     * In these events the player needs to collect echo shells to unlock voice lines and rewards.
     * Used Models: [EchoShellData], [EchoShellFloatSignalData], [EchoShellPreviewData], [EchoShellRewardData],
     * [EchoShellSummerTimeDungeonData]
     * @since 1.6
     */
    NEW_ACTIVITY_ECHO_SHELL(1602),

    // TODO document used models
    /**
     * This is the "[Kaboomball Kombat](https://genshin-impact.fandom.com/wiki/Kaboomball_Kombat)" Event from version 1.6.
     * @since 1.6
     */
    NEW_ACTIVITY_BOUNCE_CONJURING(1603),

    // TODO document used models
    /**
     * This is the 1.6 announcement banner for "[Autumn Winds, Scarlet Leaves](https://genshin-impact.fandom.com/wiki/Autumn_Winds,_Scarlet_Leaves?file=Autumn_Winds%2C_Scarlet_Leaves_Event_Page.png)"
     * @since 1.6
     */
    NEW_ACTIVITY_DAOQI_ADVERTISEMENT(1604),

    // TODO document used models
    /**
     * This is the 2.0 flagship event "[Thunder Sojourn](https://genshin-impact.fandom.com/wiki/Thunder_Sojourn)".
     * @since 2.0
     */
    NEW_ACTIVITY_BLITZ_RUSH(2001),

    // TODO document used models
    /**
     * This is the 2.0 "[Theater Mechanicus: Stage of Wonders](https://genshin-impact.fandom.com/wiki/Theater_Mechanicus/2021-08-12)" event
     * @since 2.0
     */
    NEW_ACTIVITY_CHESS(2002),

    // TODO document used models
    /**
     * This is the 2.0 "[Bellowing Blaze](https://genshin-impact.fandom.com/wiki/Pyro_Hypostasis#Bellowing_Blaze)" boss announcement banner
     * @since 2.0
     */
    NEW_ACTIVITY_MONSTER_BANNER_EFFIGY_FIRE(2003),

    // TODO document used models
    /**
     * This is the 2.0 "[Machine Battlefront](https://genshin-impact.fandom.com/wiki/Perpetual_Mechanical_Array#Machine_Battlefront)" boss announcement banner
     * @since 2.0
     */
    NEW_ACTIVITY_MONSTER_BANNER_PERPETUAL(2004),

    // TODO document used models
    /**
     * This is the 2.0 "[Grus Nivis Chapter](https://genshin-impact.fandom.com/wiki/Grus_Nivis_Chapter?file=Grus_Nivis_Chapter_Event_Menu.png)" story quest banner announcement
     * @see NEW_ACTIVITY_PERSONAL_LIINE Typically NEW_ACTIVITY_PERSONAL_LIINE is used for these
     * @since 2.0
     */
    NEW_ACTIVITY_PERSONAL_LIINE_2(2005),

    // TODO document used models
    /**
     * Various 2.1+ boss announcement banners
     * @since 2.1
     */
    NEW_ACTIVITY_GENERAL_BANNER(2100),

    // TODO document used models
    /**
     * This is the flagship event 2.1 "[Moonlight Merriment](https://genshin-impact.fandom.com/wiki/Moonlight_Merriment)".
     * @since 2.1
     */
    NEW_ACTIVITY_LUNA_RITE(2101),

    // TODO document used models
    /**
     * This is the 2.1/2.5/3.1 [Hyakunin Ikki](https://genshin-impact.fandom.com/wiki/Hyakunin_Ikki)" event
     * @since 2.1
     */
    NEW_ACTIVITY_SUMO(2102),

    // TODO document used models
    /**
     * This is the 2.1 [Lunar Realm](https://genshin-impact.fandom.com/wiki/Lunar_Realm)" event
     * @since 2.1
     */
    NEW_ACTIVITY_MOONFIN_TRIAL(2103),

    // TODO document used models
    /**
     * This is the 2.1 "[Mendacious Waves](https://genshin-impact.fandom.com/wiki/Hydro_Hypostasis#Mendacious_Waves)" boss announcement banner
     * @since 2.1
     */
    NEW_ACTIVITY_MONSTER_BANNER_EFFIGY_WATER(2104),

    // TODO document used models
    /**
     * This is the 2.1 "[Distant Storm](https://genshin-impact.fandom.com/wiki/Thunder_Manifestation#Distant_Storm)" boss announcement banner
     * @since 2.1
     */
    NEW_ACTIVITY_MONSTER_BANNER_RAIJIN(2105),

    // TODO document used models
    /**
     * This is the 2.2 "[Dreams of Bloom](https://genshin-impact.fandom.com/wiki/Dreams_of_Bloom)" event
     * @since 2.2
     */
    NEW_ACTIVITY_PLANT_FLOWER(2200),

    // TODO document used models
    /**
     * This is the 2.2 flagship event "[Labyrinth Warriors](https://genshin-impact.fandom.com/wiki/Labyrinth_Warriors)"
     * @since 2.2
     */
    NEW_ACTIVITY_ROGUELIKE_DUNGEON(2201),

    // TODO document used models
    /**
     * This is used for two 2.x Music game events.
     *
     * This includes:
     * * 2.2 "[Tuned to the World's Sounds](https://genshin-impact.fandom.com/wiki/Tuned_to_the_World%27s_Sounds)"
     * * 2.7 "[The Almighty Arataki Great and Glorious Drumalong Festival](https://genshin-impact.fandom.com/wiki/The_Almighty_Arataki_Great_and_Glorious_Drumalong_Festival)"
     * @since 2.2
     */
    NEW_ACTIVITY_MUSIC_GAME(2202),

    // TODO document used models
    /**
     * This is the 2.2 "[Shadow of the Ancients](https://genshin-impact.fandom.com/wiki/Shadow_of_the_Ancients)" event
     * @since 2.2
     */
    NEW_ACTIVITY_DIG(2203),

    // TODO document used models
    /**
     * This is the 2.1 "[Exploding Population](https://genshin-impact.fandom.com/wiki/Exploding_Population)" world quest
     * @since 2.2
     */
    NEW_ACTIVITY_MOONFIN_BANNER(2204),

    // TODO document used models
    /**
     * This is the 2.3 flagship event "[Shadows Amidst Snowstorms](https://genshin-impact.fandom.com/wiki/Shadows_Amidst_Snowstorms)".
     * @since 2.3
     */
    NEW_ACTIVITY_WINTER_CAMP(2301),

    // TODO document used models
    /**
     * This is the 2.3 "[Bantan Sango Case Files: The Warrior Dog](https://genshin-impact.fandom.com/wiki/Bantan_Sango_Case_Files:_The_Warrior_Dog)" event
     * @since 2.3
     */
    NEW_ACTIVITY_HACHI(2302),

    // TODO document used models
    /**
     * This is the 2.4 "[A Study in Potions](https://genshin-impact.fandom.com/wiki/A_Study_in_Potions)" event
     * @since 2.4
     */
    NEW_ACTIVITY_POTION(2400),

    // TODO document used models
    /**
     * This is the 2.4 "[Eight Locales Over Mountains and Seas](https://genshin-impact.fandom.com/wiki/Eight_Locales_Over_Mountains_and_Seas)" event
     * @since 2.4
     */
    NEW_ACTIVITY_TANUKI_TRAVEL(2401),

    // TODO document used models
    /**
     * This is the 2.4 flagship/Lantern rite event "[Fleeting Colors in Flight](https://genshin-impact.fandom.com/wiki/Fleeting_Colors_in_Flight)".
     * @since 2.4
     */
    NEW_ACTIVITY_SEA_LAMP_2_4(2402),

    // TODO document used models
    /**
     * This is the 2.5 flagship event "[Three Realms Gateway Offering](https://genshin-impact.fandom.com/wiki/Three_Realms_Gateway_Offering)".
     * @since 2.5
     */
    NEW_ACTIVITY_MICHIAE_MATSURI(2501),

    // TODO document used models
    /**
     * This is the 2.5 "[Of Drink A-Dreaming](https://genshin-impact.fandom.com/wiki/Of_Drink_A-Dreaming)" event.
     * @since 2.5
     */
    NEW_ACTIVITY_BARTENDER(2502),

    // TODO document used models
    /**
     * This is the 2.5 "[Divine Ingenuity](https://genshin-impact.fandom.com/wiki/Divine_Ingenuity/2022-03-02)" event.
     *
     * @see NEW_ACTIVITY_UGC_V2 For the 3.7 version
     * @since 2.5
     */
    NEW_ACTIVITY_UGC(2503),

    // TODO document used models
    /**
     * This is the 2.6 flagship event "[Hues of the Violet Garden](https://genshin-impact.fandom.com/wiki/Hues_of_the_Violet_Garden)".
     * @since 2.6
     */
    NEW_ACTIVITY_IRODORI(2600),

    // TODO document used models
    /**
     * This is the 2.6 "[Vibro-Crystal Research](https://genshin-impact.fandom.com/wiki/Vibro-Crystal/2022-04-21)" event
     * This is the 3.5 "[Vibro-Crystal Verification](https://genshin-impact.fandom.com/wiki/Vibro-Crystal/2023-03-14)" event
     * This is the 4.6 "[Vibro-Crystal Applications](https://genshin-impact.fandom.com/wiki/Vibro-Crystal/2024-04-28)" event
     * @since 2.6
     */
    NEW_ACTIVITY_CRYSTAL_LINK(2601),

    // TODO document used models
    /**
     * Used for the spices "[Spices from the West](https://genshin-impact.fandom.com/wiki/Spices_From_the_West)" events.
     *
     * This includes:
     * * 2.6 "[Spices From the West](https://genshin-impact.fandom.com/wiki/Spices_From_the_West/2022-05-14)"
     * * 3.5 "[Spices From the West: Northerly Search](https://genshin-impact.fandom.com/wiki/Spices_From_the_West/2023-03-31)"
     * @since 2.6
     */
    NEW_ACTIVITY_SPICE(2602),

    // TODO document used models
    /**
     * This is used for multiple photo capture events since its first occurrence in 2.6.
     *
     * This includes:
     * * 2.6 "[Outside the Canvas, Inside the Lens](https://genshin-impact.fandom.com/wiki/Outside_the_Canvas,_Inside_the_Lens/2022-04-01)"
     * * 3.2 "[Outside the Canvas, Inside the Lens: Greenery Chapter](https://genshin-impact.fandom.com/wiki/Outside_the_Canvas,_Inside_the_Lens/2022-11-16)"
     * * 4.8 "[Outside the Canvas, Inside the Lens: Dew-Kissed Chapter](https://genshin-impact.fandom.com/wiki/Outside_the_Canvas,_Inside_the_Lens/2024-07-29)"
     * * 5.0 "[Mementos of Teyvat](https://genshin-impact.fandom.com/wiki/Mementos_of_Teyvat)"
     * * 5.8 "[Mementos of Teyvat: Prelude of the Frozen Veil]"(https://genshin-impact.fandom.com/wiki/Mementos_of_Teyvat/2025-08-21)
     *
     * @see NEW_ACTIVITY_PHOTO_UNDERSEA for the 4.0 photo event
     * @since 2.6
     */
    NEW_ACTIVITY_PHOTO(2603),

    // TODO document used models
    /**
     * This is the 2.7 "[A Muddy Bizarre Adventure](https://genshin-impact.fandom.com/wiki/A_Muddy_Bizarre_Adventure)" event
     * @since 2.7
     */
    NEW_ACTIVITY_LUMINANCE_STONE_CHALLENGE(2702),

    // TODO document used models
    /**
     * This is the 2.7 "[Core of the Apparatus](https://genshin-impact.fandom.com/wiki/Core_of_the_Apparatus)" event
     * @since 2.7
     */
    NEW_ACTIVITY_GACHA(2703),

    // TODO document used models
    /**
     * This is the 2.7 flagship event "[Perilous Trail](https://genshin-impact.fandom.com/wiki/Perilous_Trail_(Event))".
     * @since 2.7
     */
    NEW_ACTIVITY_ROGUE_DIARY(2704),

    // TODO document used models
    /**
     * This is the 2.8 flagship events "[Summertime Odyssey](https://genshin-impact.fandom.com/wiki/Summertime_Odyssey)".
     * @since 2.8
     */
    NEW_ACTIVITY_SUMMER_TIME_2_8(2801),

    // TODO document used models
    /**
     * This is the 2.8 "[Evermotion Mechanical Painting](https://genshin-impact.fandom.com/wiki/Evermotion_Mechanical_Painting)" event
     * @since 2.8
     */
    NEW_ACTIVITY_GEAR(2802),

    // TODO document used models
    /**
     * This is the 2.8 "[Reminiscent Regimen](https://genshin-impact.fandom.com/wiki/Reminiscent_Regimen/2022-08-04)" event
     * @see NEW_ACTIVITY_COOPERATE_CHALLENGE for 5.x "Reminiscent Regimen" events
     * @since 2.8
     */
    NEW_ACTIVITY_ISLAND_PARTY(2803),

    // TODO document used models
    /**
     * This is the 3.0 flagship event "[Graven Innocence](https://genshin-impact.fandom.com/wiki/Graven_Innocence)".
     * @since 2.8
     */
    NEW_ACTIVITY_GRAVEN_INNOCENCE(3000),

    // TODO document used models
    /**
     * This is used for a 3.0 and 3.6 event with the character Hajanad:
     * * 3.0 "[Tablet Analytics](https://genshin-impact.fandom.com/wiki/Tablet_Analytics)"
     * * 3.6 "[Brewing Developments](https://genshin-impact.fandom.com/wiki/Brewing_Developments)"
     * @since 3.0
     */
    NEW_ACTIVITY_INSTABLE_SPRAY(3001),

    // TODO document used models
    /**
     * This is the 3.0 "[Fayz Trials](https://genshin-impact.fandom.com/wiki/Fayz_Trials/2022-09-08)" event
     * This is the 3.7 "[Fayz Trials: Hypothesis](https://genshin-impact.fandom.com/wiki/Fayz_Trials/2023-06-21)" event
     * @see NEW_ACTIVITY_AUTO_TIME_STOP for the "The Great Fayz Reaction Debate" event
     * @since 3.0
     */
    NEW_ACTIVITY_MUQADAS_POTION(3002),

    // TODO document used models
    /**
     * This is the 3.0 "[Lost Riches](https://genshin-impact.fandom.com/wiki/Lost_Riches/2022-09-02)" event
     * @see NEW_ACTIVITY_TREASURE_MAP for the 1.2 and 2.0 version
     * @see NEW_ACTIVITY_TREASURE_HUNT_V4 for the 4.3 version
     * @since 3.0
     */
    NEW_ACTIVITY_TREASURE_SEELIE(3003),

    // TODO document used models
    /**
     * This is the 3.1 "[Wind Chaser](https://genshin-impact.fandom.com/wiki/Wind_Chaser)" event
     * @since 3.1
     */
    NEW_ACTIVITY_WIND_FIELD(3101),

    // TODO document used models
    /**
     * This is the 3.1 "[Star-Seeker's Sojourn](https://genshin-impact.fandom.com/wiki/Star-Seeker%27s_Sojourn)" event
     * @since 3.1
     */
    NEW_ACTIVITY_ROCK_BOARD_EXPLORE(3102),

    // TODO document used models
    /**
     * This is the 3.1 flagship event "[Of Ballads and Brews](https://genshin-impact.fandom.com/wiki/Of_Ballads_and_Brews)".
     * @since 3.1
     */
    NEW_ACTIVITY_VINTAGE(3103),

    // TODO document used models
    /**
     * This is the 3.2 flagship event "[Fabulous Fungus Frenzy](https://genshin-impact.fandom.com/wiki/Fabulous_Fungus_Frenzy)".
     * @since 3.2
     */
    NEW_ACTIVITY_FUNGUS_FIGHTER(3201),

    // TODO document used models
    /**
     * This used for Adventurer's Trials events, starting with version 3.2
     * 3.2 [Adventurer's Trials](https://genshin-impact.fandom.com/wiki/Adventurer%27s_Trials/2022-11-04)
     * 3.8 [Adventurer's Trials: Advanced](https://genshin-impact.fandom.com/wiki/Adventurer%27s_Trials/2023-07-20)
     * 5.2 [Adventurer's Trials: Metamorphosis](https://genshin-impact.fandom.com/wiki/Adventurer%27s_Trials/2024-12-11)
     * @since 3.2
     */
    NEW_ACTIVITY_CHAR_AMUSEMENT(3202),

    // TODO document used models
    /**
     * This is the 3.2 "[Hypostatic Symphony: Dissonant Verse](https://genshin-impact.fandom.com/wiki/Hypostatic_Symphony/2022-11-24)" event
     * @see NEW_ACTIVITY_EFFIGY for the 1.2 "Hypostatic Symphony" and 1.6 "Legend of the Vagabond Sword"
     * @see NEW_ACTIVITY_EFFIGY_CHALLENGE_V4 For the 3.7 "Feast of the Departed Warriors" event
     * @see NEW_ACTIVITY_EFFIGY_CHALLENGE_V5 For the 4.6 "Specially-Shaped Saurian Search" and 5.3 "On the Trail of Behemoths" events
     * @since 3.2
     */
    NEW_ACTIVITY_EFFIGY_CHALLENGE_V2(3203),

    // TODO document used models
    /**
     * This is the 3.3 flagship event "[Akitsu Kimodameshi](https://genshin-impact.fandom.com/wiki/Akitsu_Kimodameshi)".
     * @since 3.3
     */
    NEW_ACTIVITY_BRICK_BREAKER(3300),

    // TODO document used models
    /**
     * This is the 3.3 "[Across the Wilderness](https://genshin-impact.fandom.com/wiki/Across_the_Wilderness)" event
     * @since 3.3
     */
    NEW_ACTIVITY_COIN_COLLECT(3301),

    // TODO document used models
    /**
     * This is the 3.4 "[Warrior's Spirit](https://genshin-impact.fandom.com/wiki/Warrior%27s_Spirit)" event
     * @since 3.4
     */
    NEW_ACTIVITY_DUEL_HEART(3400),

    // TODO document used models
    /**
     * This is the 3.4 flagship event "[The Exquisite Night Chimes](https://genshin-impact.fandom.com/wiki/The_Exquisite_Night_Chimes)".
     * @since 3.4
     */
    NEW_ACTIVITY_SEA_LAMP_3_4(3401),

    // TODO document used models
    /**
     * This is used for the first two beetle battle events in 3.4 and 4.2:
     * * 3.4 "[Almighty Arataki Extraordinary and Exhilarating Extreme Beetle Brawl](https://genshin-impact.fandom.com/wiki/Almighty_Arataki_Extraordinary_and_Exhilarating_Extreme_Beetle_Brawl)"
     * * 4.2 "[Arataki Blazing Armor Beetle Battle Boot Camp](https://genshin-impact.fandom.com/wiki/Arataki_Blazing_Armor_Beetle_Battle_Boot_Camp)"
     * @see NEW_ACTIVITY_ELECTROHERCULES_BATTLE_V3 for the 5.3 event
     * @since 3.4
     */
    NEW_ACTIVITY_ELECTROHERCULES_BATTLE(3402),

    // TODO document used models
    /**
     * This is the 3.4 "[Second Blooming](https://genshin-impact.fandom.com/wiki/Second_Blooming](https://genshin-impact.fandom.com/wiki/Second_Blooming)" event
     * @since 3.4
     */
    NEW_ACTIVITY_TEAM_CHAIN(3403),

    // TODO document used models
    /**
     * This is used for the "[Genius Invokation TCG: Heated Battle Mode](https://genshin-impact.fandom.com/wiki/Heated_Battle_Mode)" events.
     * This includes for example:
     * * 3.4 "[Heated Battle Mode: Omnipotent Guide](https://genshin-impact.fandom.com/wiki/Heated_Battle_Mode/2023-01-28)
     * * 5.3 "[Heated Battle Mode: Sprinting Stratagems](https://genshin-impact.fandom.com/wiki/Heated_Battle_Mode/2024-01-06)"
     * @see NEW_ACTIVITY_GCG_AUTO_BATTLE_CARD For the "Heated Battle Mode: Automatic Artistry" version
     * @since 3.4
     */
    NEW_ACTIVITY_GCG_FESTIVAL(3404),

    // TODO document used models
    /**
     * This is the 3.4 "[Desert of Hadramaveth](https://genshin-impact.fandom.com/wiki/Desert_of_Hadramaveth?file=Desert_of_Hadramaveth_Event_Menu.png)" location announcement
     * @since 3.4
     */
    NEW_ACTIVITY_SANDY_LAND_BANNER(3405),

    // TODO document used models
    /**
     * This is the 3.5 flagship event "[Windblume's Breath](https://genshin-impact.fandom.com/wiki/Windblume%27s_Breath)".
     * @since 3.5
     */
    NEW_ACTIVITY_FLEURFAIR_V2(3500),

    // TODO document used models
    /**
     * This is the 3.5 "[Fungus Mechanicus](https://genshin-impact.fandom.com/wiki/Fungus_Mechanicus)" event
     * @since 3.5
     */
    NEW_ACTIVITY_FUNGUS_FIGHTER_V2(3501),

    // TODO document used models
    /**
     * This is the 3.6 "[Fulminating Sandstorm](https://genshin-impact.fandom.com/wiki/Fulminating_Sandstorm)" event
     * @since 3.6
     */
    NEW_ACTIVITY_SANDWORM_CANNON(3600),

    // TODO document used models
    /**
     * This is the 3.6 flagship event "[A Parade of Providence](https://genshin-impact.fandom.com/wiki/A_Parade_of_Providence)"
     * @since 3.6
     */
    NEW_ACTIVITY_AKA_FES(3601),

    // TODO document used models
    /**
     * This is the 3.6 "[The Recollector's Path](https://genshin-impact.fandom.com/wiki/The_Recollector%27s_Path)" event
     * @since 3.6
     */
    NEW_ACTIVITY_SORUSH_TRIAL(3602),

    // TODO document used models
    /**
     * This is the 3.7 "[Divine Ingenuity: Collector's Chapter](https://genshin-impact.fandom.com/wiki/Divine_Ingenuity/2023-06-08)" event
     * @see NEW_ACTIVITY_UGC For the 2.5 version
     * @since 3.7
     */
    NEW_ACTIVITY_UGC_V2(3701),

    // TODO document used models
    /**
     * This is the 3.7 "[Feast of the Departed Warriors](https://genshin-impact.fandom.com/wiki/Feast_of_the_Departed_Warriors)" event
     * @see NEW_ACTIVITY_EFFIGY for the 1.2 "Hypostatic Symphony" and 1.6 "Legend of the Vagabond Sword"
     * @see NEW_ACTIVITY_EFFIGY_CHALLENGE_V2 for the 3.2 "Hypostatic Symphony: Dissonant Verse"
     * @see NEW_ACTIVITY_EFFIGY_CHALLENGE_V5 For the 4.6 "Specially-Shaped Saurian Search" and 5.3 "On the Trail of Behemoths" events
     * @since 3.7
     */
    NEW_ACTIVITY_EFFIGY_CHALLENGE_V4(3702),

    // TODO document used models
    /**
     * This is the 3.7 flagship event "[Duel! The Summoners' Summit!](https://genshin-impact.fandom.com/wiki/Duel!_The_Summoners%27_Summit!)".
     * @since 3.7
     */
    NEW_ACTIVITY_JOURNEY(3703),

    // TODO document used models
    /**
     * This is the "[The Forge Realm's Temper: Clever Strategems](https://genshin-impact.fandom.com/wiki/The_Forge_Realm's_Temper)" tcg event
     * @see NEW_ACTIVITY_GCG_PVE_INFINITE for the "The Forge Realm's Temper: Endless Swarm" events
     * @see NEW_ACTIVITY_GCG_PVE_PUZZLE for the "The Forge Realm's Temper: Game of Wits" events
     * @since 3.7
     */
    NEW_ACTIVITY_GCG_PVE(3705),

    // TODO document used models
    /**
     * This is the 3.8 flagship event "[Secret Summer Paradise](https://genshin-impact.fandom.com/wiki/Secret_Summer_Paradise)"
     * @since 3.8
     */
    NEW_ACTIVITY_PENUMBRA_ADVENTURE(3800),

    // TODO document used models
    /**
     * This is the 3.8 "[Perilous Expedition](https://genshin-impact.fandom.com/wiki/Perilous_Expedition)" event
     * @since 3.8
     */
    NEW_ACTIVITY_MULTI_CHARACTER_FIGHT(3801),

    // TODO document used models
    /**
     * This is the 3.8 "[Shared Sight](https://genshin-impact.fandom.com/wiki/Shared_Sight)" event
     * This is the 5.2 "[Claw Convoy](https://genshin-impact.fandom.com/wiki/Claw_Convoy)" event
     * @since 3.8
     */
    NEW_ACTIVITY_ANIMAL_VIEW(3802),

    // TODO document used models
    /**
     * This is the "[The Forge Realm's Temper: Endless Swarm](https://genshin-impact.fandom.com/wiki/The_Forge_Realm's_Temper)" event banner
     * @see NEW_ACTIVITY_GCG_PVE for the "The Forge Realm's Temper: Clever Strategems" events
     * @see NEW_ACTIVITY_GCG_PVE_PUZZLE for the "The Forge Realm's Temper: Game of Wits" events
     * @since 3.8
     */
    NEW_ACTIVITY_GCG_PVE_INFINITE(3803),

    // TODO document used models
    /**
     * This is the 4.0 "[Studies in Light and Shadow: A Fontaine of Enchantment](https://genshin-impact.fandom.com/wiki/Studies_in_Light_and_Shadow:_A_Fontaine_of_Enchantment)" event
     * @see NEW_ACTIVITY_PHOTO for multiple other photo events
     * @since 4.0
     */
    NEW_ACTIVITY_PHOTO_UNDERSEA(4000),

    // TODO document used models
    /**
     * This is the 4.0 flagship event "[Mega Meka Melee](https://genshin-impact.fandom.com/wiki/Mega_Meka_Melee)".
     * @since 4.0
     */
    NEW_ACTIVITY_TOY_BATTLE(4001),

    // TODO document used models
    /**
     * This is the 4.0 "[Relic Records: Creations of the Hydro Nation](https://genshin-impact.fandom.com/wiki/Relic_Records:_Creations_of_the_Hydro_Nation)" event
     * @since 4.0
     */
    NEW_ACTIVITY_FONTAINE_GATHER(4002),

    // TODO document used models
    /**
     * This is the "[The Forge Realm's Temper: Game of Wits](https://genshin-impact.fandom.com/wiki/The_Forge_Realm's_Temper)" event banner
     * @see NEW_ACTIVITY_GCG_PVE for the "The Forge Realm's Temper: Clever Strategems" events
     * @see NEW_ACTIVITY_GCG_PVE_INFINITE for the "The Forge Realm's Temper: Endless Swarm" events
     * @since 4.0
     */
    NEW_ACTIVITY_GCG_PVE_PUZZLE(4003),

    // TODO document used models
    /**
     * This is the 4.1 "[Radiant Harvest](https://genshin-impact.fandom.com/wiki/Radiant_Harvest): event
     * @since 4.1
     */
    NEW_ACTIVITY_COLLECT_UNDERWATER(4100),

    // TODO document used models
    /**
     * This is the 4.1 "[The Peaks and Troughs of Life](https://genshin-impact.fandom.com/wiki/The_Peaks_and_Troughs_of_Life)" event
     * @since 4.1
     */
    NEW_ACTIVITY_QUICK_TIME_COMBAT(4101),

    // TODO document used models
    /**
     * This is the 4.1 flagship event "[Waterborne Poetry](https://genshin-impact.fandom.com/wiki/Waterborne_Poetry)"
     * @since 4.1
     */
    NEW_ACTIVITY_POETRY_FESTIVAL(4102),

    // TODO document used models
    /**
     * This is the "[Dodoco's Bomb-Tastic Adventure](https://genshin-impact.fandom.com/wiki/Dodoco's_Bomb-Tastic_Adventure)" event
     * @see NEW_ACTIVITY_FISHBLASTER For the 4.1 "Dodoco's Bomb-Tastic Adventure" event
     * @see NEW_ACTIVITY_BOMBER_DODOCO For the 5.0 "Dodoco's Boom-Bastic Escapades"
     * @see NEW_ACTIVITY_BOMBER_V3 For the 6.0 "Dodoco's Blow-Up-Erative Bomb-Nanza"
     * @since 4.1
     */
    NEW_ACTIVITY_FISHBLASTER(4103),

    // TODO document used models
    /**
     * This is the 4.2 flagship event "[Thelxie's Fantastic Adventures](https://genshin-impact.fandom.com/wiki/Thelxie%27s_Fantastic_Adventures)"
     * @since 4.2
     */
    NEW_ACTIVITY_RAINBOW_PRINCE(4200),

    // TODO document used models
    /**
     * This is the 4.2 "[Graph Adversarial Technology Experiment Log](https://genshin-impact.fandom.com/wiki/Graph_Adversarial_Technology_Experiment_Log)" event
     * @since 4.2
     */
    NEW_ACTIVITY_BLESSING_V2(4201),

    // TODO document used models
    /**
     * This is the 4.2 "[Lil' Fungi's Fun-Tastic Fiesta](https://genshin-impact.fandom.com/wiki/Lil%27_Fungi%27s_Fun-Tastic_Fiesta)" event
     * @since 4.2
     */
    NEW_ACTIVITY_FUNGUS_FIGHTER_V3(4202),

    // TODO document used models
    /**
     * This is the 4.3 flagship event "[Roses and Muskets](https://genshin-impact.fandom.com/wiki/Roses_and_Muskets)".
     * @since 4.3
     */
    NEW_ACTIVITY_FILMFEST(4300),

    // TODO document used models
    /**
     * This is the 4.3 "[Dance of Resolute Will](https://genshin-impact.fandom.com/wiki/Dance_of_Resolute_Will)" event
     * @since 4.3
     */
    NEW_ACTIVITY_GOAL_CHALLENGE(4301),

    // TODO document used models
    /**
     * This is the 4.3 "[Lost Riches](https://genshin-impact.fandom.com/wiki/Lost_Riches/2024-01-02)" event
     * @see NEW_ACTIVITY_TREASURE_MAP for the 1.2 and 2.0 version
     * @see NEW_ACTIVITY_TREASURE_SEELIE for the 3.0 version
     * @since 4.3
     */
    NEW_ACTIVITY_TREASURE_HUNT_V4(4302),

    // TODO document used models
    /**
     * This is the 4.3 "[Gazing Up at Eternity, Looking Down at the World](https://genshin-impact.fandom.com/wiki/Gazing_Up_at_Eternity,_Looking_Down_at_the_World)" event
     * @since 4.3
     */
    NEW_ACTIVITY_FURNITURE_BROADCAST(4303),

    // TODO document used models
    /**
     * This is the 4.4 "[Triumphant Frenzy](https://genshin-impact.fandom.com/wiki/Triumphant_Frenzy)" event
     * @since 4.4
     */
    NEW_ACTIVITY_STAMINA_FIGHT(4401),

    // TODO document used models
    /**
     * This is the 4.4 flagship event "[Vibrant Harriers Aloft in Spring Breeze](https://genshin-impact.fandom.com/wiki/Vibrant_Harriers_Aloft_in_Spring_Breeze)".
     * @since 4.4
     */
    NEW_ACTIVITY_LANTERN_RITE_V4(4402),

    // TODO document used models
    /**
     * This is the 4.4 "[Journey Through Hilinigmatic Terrain](https://genshin-impact.fandom.com/wiki/Journey_Through_Hilinigmatic_Terrain)" event
     * @since 4.4
     */
    NEW_ACTIVITY_LOST_SAMACHURL(4403),

    // TODO document used models
    /**
     * This is the 4.4 "[Receiver of Friends From Afar](https://genshin-impact.fandom.com/wiki/Receiver_of_Friends_From_Afar)" event
     * @since 4.4
     */
    NEW_ACTIVITY_COOK_GAME(4404),

    // TODO document used models
    /**
     * This is the 4.5 "[Feline Fortress Furrdyssey](https://genshin-impact.fandom.com/wiki/Feline_Fortress_Furrdyssey)" event
     * @since 4.5
     */
    NEW_ACTIVITY_CATCAFE(4501),

    // TODO document used models
    /**
     * This is the 4.5 flagship event "[Alchemical Ascension](https://genshin-impact.fandom.com/wiki/Alchemical_Ascension)".
     * @since 4.5
     */
    NEW_ACTIVITY_ALCHEMY_SIM(4502),

    // TODO document used models
    /**
     * This is the 4.5 "[The Great Fayz Reaction Debate](https://genshin-impact.fandom.com/wiki/Fayz_Trials/2024-03-22)" event
     * @see NEW_ACTIVITY_MUQADAS_POTION For other Fayz Trials
     * @since 4.5
     */
    NEW_ACTIVITY_AUTO_TIME_STOP(4503),

    // TODO document used models
    /**
     * This is used for cannon shooting events related to the "Genius Inventor" from the Gardes:
     * * 4.5 "[Rolling Crossfire](https://genshin-impact.fandom.com/wiki/Rolling_Crossfire)"
     * * 5.7 "[Fearsome Ferocious Firepower](https://genshin-impact.fandom.com/wiki/Fearsome_Ferocious_Firepower"
     * @since 4.5
     */
    NEW_ACTIVITY_SLIME_CANNON(4504),

    // TODO document used models
    /**
     * This is the 4.6 "[Specially-Shaped Saurian Search](https://genshin-impact.fandom.com/wiki/Specially-Shaped_Saurian_Search)" event
     * This is the 5.3 "[On the Trail of Behemoths](https://genshin-impact.fandom.com/wiki/On_the_Trail_of_Behemoths)" event
     * @see NEW_ACTIVITY_EFFIGY for the 1.2 "Hypostatic Symphony" and 1.6 "Legend of the Vagabond Sword"
     * @see NEW_ACTIVITY_EFFIGY_CHALLENGE_V2 for the 3.2 "Hypostatic Symphony: Dissonant Verse"
     * @see NEW_ACTIVITY_EFFIGY_CHALLENGE_V4 For the 3.7 "Feast of the Departed Warriors" event
     * @since 4.6
     */
    NEW_ACTIVITY_EFFIGY_CHALLENGE_V5(4601),

    // TODO document used models
    /**
     * This is the 4.6 flaghsip event "[Iridescent Arataki Rockin' for Life Tour de Force of Awesomeness](https://genshin-impact.fandom.com/wiki/Iridescent_Arataki_Rockin%27_for_Life_Tour_de_Force_of_Awesomeness)".
     * @since 4.6
     */
    NEW_ACTIVITY_GREAT_FESTIVAL_V2(4602),

    // TODO document used models
    /**
     * This is the 4.6 "[Windtrace: Seekers and Strategy](https://genshin-impact.fandom.com/wiki/Windtrace/2024-05-14)" event
     * @since 4.6
     */
    NEW_ACTIVITY_HIDE_AND_SEEK_V4(4603),

    // TODO document used models
    /**
     * This is the 4.7 "[Spino Doubleblaster](https://genshin-impact.fandom.com/wiki/Spino_Doubleblaster)" event
     * @since 4.7
     */
    NEW_ACTIVITY_WATERGUN(4701),

    // TODO document used models
    /**
     * This is the 4.7 "[Endless Forms Most Martial](https://genshin-impact.fandom.com/wiki/Endless_Forms_Most_Martial)" event
     * @since 4.7
     */
    NEW_ACTIVITY_ACROBATICS_BATTLE(4702),

    // TODO document used models
    /**
     * This is the 4.7 flagship event "[Mutual Security Enhancing Simulation](https://genshin-impact.fandom.com/wiki/Mutual_Security_Enhancing_Simulation)".
     * @since 4.7
     */
    NEW_ACTIVITY_MONSTER_VS_MONSTER(4703),

    // TODO document used models
    /**
     * This banner is used to show the Imaginarium Theater reset
     * @since 4.7
     */
    NEW_ACTIVITY_ROLE_COMBAT_RESET(4704),

    // TODO document used models
    /**
     * This is the 4.7 "[Record of Reflective Writing](https://genshin-impact.fandom.com/wiki/Record_of_Reflective_Writing)" event
     * @since 4.7
     */
    NEW_ACTIVITY_BULLET_HELL(4705),

    // TODO document used models
    /**
     * This is the 4.8 "[Bing-Bang Finchball 2024-08-06](https://genshin-impact.fandom.com/wiki/Bing-Bang_Finchball/2024-08-06)" event
     * @see NEW_ACTIVITY_BIRD_PIN_BALL For the 6.2 occurrence
     * @since 4.8
     */
    NEW_ACTIVITY_BIRD_BALL(4801),

    // TODO document used models
    /**
     * This is the 4.8 flagship event "[Summertide Scales and Tales](https://genshin-impact.fandom.com/wiki/Summertide_Scales_and_Tales)".
     * @since 4.8
     */
    NEW_ACTIVITY_FAIRY_TALES(4802),

    // TODO document used models
    /**
     * This is the 4.8 "[Energy Amplifier: Lemma](https://genshin-impact.fandom.com/wiki/Energy_Amplifier/2024-08-12)" event
     * @see NEW_ACTIVITY_CHANNELER_SLAB for previous Energy Amplifier events
     * @since 4.8
     */
    NEW_ACTIVITY_RECHARGE_DISK(4803),

    // TODO document used models
    /**
     * This is the 4.8 "[Envisaged Echoes](https://genshin-impact.fandom.com/wiki/Envisaged_Echo?file=Envisaged_Echoes_Event_Menu.png)" announcement
     * @since 4.8
     */
    NEW_ACTIVITY_CHAR_MASTER_BROADCAST(4804),

    // TODO document used models
    /**
     * This is the 5.0 "[Dodoco's Boom-Bastic Escapades](https://genshin-impact.fandom.com/wiki/Dodoco%27s_Boom-Bastic_Escapades)" event
     * @see NEW_ACTIVITY_FISHBLASTER For the 4.1 "Dodoco's Bomb-Tastic Adventure" event
     * @see NEW_ACTIVITY_BOMBER_V3 For the 6.0 "Dodoco's Blow-Up-Erative Bomb-Nanza"
     * @since 5.0
     */
    NEW_ACTIVITY_BOMBER_DODOCO(5001),

    // TODO document used models
    /**
     * This is the 5.0 "[Of Thorns and Crowns](https://genshin-impact.fandom.com/wiki/Of_Thorns_and_Crowns)" event
     * @since 5.0
     */
    NEW_ACTIVITY_GAIN_BUFF(5002),

    // TODO document used models
    /**
     * This is used for multiple main quest banners since 5.0:
     * * 5.0 "[Flowers Resplendent on the Sun-Scorched Sojourn](https://genshin-impact.fandom.com/wiki/Flowers_Resplendent_on_the_Sun-Scorched_Sojourn_(Event))"
     * * 5.1 "[The Rainbow Destined to Burn](https://genshin-impact.fandom.com/wiki/The_Rainbow_Destined_to_Burn_(Event))"
     * * 5.3 "[Incandescent Ode of Resurrection](https://genshin-impact.fandom.com/wiki/Incandescent_Ode_of_Resurrection_(Event))"
     * * 5.8 "[The Journey Home](https://genshin-impact.fandom.com/wiki/The_Journey_Home_(Event))"
     * * 6.0 "[A Dance of Snowy Tides and Hoarfrost Groves](https://genshin-impact.fandom.com/wiki/A_Dance_of_Snowy_Tides_and_Hoarfrost_Groves_(Event))"
     * * 6.1 "[An Elegy for Faded Moonlight](https://genshin-impact.fandom.com/wiki/An_Elegy_for_Faded_Moonlight_(Event))"
     * * 6.2 "[A Nocturne of the Far North](https://genshin-impact.fandom.com/wiki/A_Nocturne_of_the_Far_North_(Event))"
     * * 6.3 "[A Traveler on a Winter's Night](https://genshin-impact.fandom.com/wiki/A_Traveler_on_a_Winter's_Night_(Event))"
     * @since 5.0
     */
    NEW_ACTIVITY_MAIN_LINE_BANNER(5003),

    // TODO document used models
    /**
     * This is used as advertisement and quick launch banner for multiple side stories:
     * * 5.0 "[Flowers Resplendent on the Sun-Scorched Sojourn](https://genshin-impact.fandom.com/wiki/Flowers_Resplendent_on_the_Sun-Scorched_Sojourn_(Event))"
     * * 5.2 "[All Fires Fuel the Flame](https://genshin-impact.fandom.com/wiki/All_Fires_Fuel_the_Flame)"
     * * 5.6 "[Paralogism](https://genshin-impact.fandom.com/wiki/Paralogism)"
     * * 5.7 "[A Space and Time for You](https://genshin-impact.fandom.com/wiki/A_Space_and_Time_for_You)"
     * * 6.0 "[A Dance of Snowy Tides and Hoarfrost Groves](https://genshin-impact.fandom.com/wiki/A_Dance_of_Snowy_Tides_and_Hoarfrost_Groves_(Event))"
     * @since 5.0
     */
    NEW_ACTIVITY_QUICK_LAUNCH_BANNER(5004),

    // TODO document used models
    /**
     * This is the 5.0 flagship event "[Traces of Artistry](https://genshin-impact.fandom.com/wiki/Traces_of_Artistry)".
     * @since 5.0
     */
    NEW_ACTIVITY_NATLAN_TOUR(5005),

    // TODO document used models
    /**
     * This is used since 5.0 for newer free character banners:
     * * 5.0+ "[Turbo Twirly!](https://genshin-impact.fandom.com/wiki/Turbo_Twirly!)"
     * * 6.0+ "[The Clink Clank Whiz-Kid!](https://genshin-impact.fandom.com/wiki/The_Clink_Clank_Whiz-Kid!)"
     * @since 5.0
     */
    NEW_ACTIVITY_BONUS_AVATAR_BANNER(5006),

    // TODO document used models
    /**
     * This is used for 5.x natlan tribe release events
     * * 5.0 "[Yupanqui's Turnfire](https://genshin-impact.fandom.com/wiki/Yupanqui%27s_Turnfire_(Event))" event
     * * 5.0 "[Where the Springs Return](https://genshin-impact.fandom.com/wiki/Where_the_Springs_Return_(Event))" event
     * * 5.1 "[A Prayer for Blessings, Told to Crested Peaks](https://genshin-impact.fandom.com/wiki/A_Prayer_for_Blessings,_Told_to_Crested_Peaks_(Event))" event
     * * 5.2 "[Of Fading Flowers and Falling Feathers](https://genshin-impact.fandom.com/wiki/Of_Fading_Flowers_and_Falling_Feathers_(Event))" event
     * * 5.3 "[Memories Flowing With Color](https://genshin-impact.fandom.com/wiki/Memories_Flowing_With_Color_(Event))" event
     * * 5.5 "[Mushroom Realm Mystery](https://genshin-impact.fandom.com/wiki/Mushroom_Realm_Mystery_(Event))"
     * @since 5.0
     */
    NEW_ACTIVITY_TRIBAL_PERSONAL_LINE_BANNER(5007),

    // TODO document used models
    /**
     * This was used for free 5-star selection events since 5.0:
     * * 5.0 "[A Quest to Kindle Ancient Flames](https://genshin-impact.fandom.com/wiki/A_Quest_to_Kindle_Ancient_Flames)"
     * * 6.0 "[Uncover Lunar Realms, Hone the Eventide Radiance](https://genshin-impact.fandom.com/wiki/Uncover_Lunar_Realms,_Hone_the_Eventide_Radiance/2025-09-10)"
     * @since 5.0
     */
    NEW_ACTIVITY_PERMANENT_BANNER(5008),

    // TODO document used models
    /**
     * This is used for "[Reminiscent Regiment](https://genshin-impact.fandom.com/wiki/Reminiscent_Regimen)" coop challenge events since 5.1
     * * 5.1 "[Reminiscent Regimen: Thrill](https://genshin-impact.fandom.com/wiki/Reminiscent_Regimen/2024-10-17)" event
     * * 5.7 "[Reminiscent Regimen: Frenzy](https://genshin-impact.fandom.com/wiki/Reminiscent_Regimen/2025-07-14)"
     * @see NEW_ACTIVITY_ISLAND_PARTY for the 2.8 "Reminiscent Regiment" event
     * @since 5.1
     */
    NEW_ACTIVITY_COOPERATE_CHALLENGE(5101),

    // TODO document used models
    /**
     * This is the 5.1 "[Feast of Pursuit](https://genshin-impact.fandom.com/wiki/Feast_of_Pursuit)" event
     * @since 5.1
     */
    NEW_ACTIVITY_ARENA_CHALLENGE_V5(5102),

    // TODO document used models
    /**
     * This is the 5.1 flagship event "[Chromatic Ode of Candies and Roses](https://genshin-impact.fandom.com/wiki/Chromatic_Ode_of_Candies_and_Roses)".
     * @since 5.1
     */
    NEW_ACTIVITY_NAHIDA_BIRTH(5103),

    // TODO document used models
    /**
     * This is the 5.1 "[Aphid Treasure Trace](https://genshin-impact.fandom.com/wiki/Aphid_Treasure_Trace)" event
     * @since 5.1
     */
    NEW_ACTIVITY_BOLTBUG_ABYSS(5104),

    // TODO document used models
    /**
     * Starting with 5.1 this is used for limited time exploration rewards:
     * * 5.1 "[Land of Vibrant Stone and Flaming Springs](https://genshin-impact.fandom.com/wiki/Land_of_Vibrant_Stone_and_Flaming_Springs_(Event))"
     * * 5.2 "[Facing the Windborne Cliff and City of Flowing Ash](https://genshin-impact.fandom.com/wiki/Facing_the_Windborne_Cliff_and_City_of_Flowing_Ash_(Event))"
     * * 5.6 "[The Sacred Mountain and Sanctified Land](https://genshin-impact.fandom.com/wiki/The_Sacred_Mountain_and_Sanctified_Land)"
     * * 5.8 "[An Easy-Breezy Natlan in an Easy-Breezy Summer!](https://genshin-impact.fandom.com/wiki/An_Easy-Breezy_Natlan_in_an_Easy-Breezy_Summer!)"
     * * 6.0 "[The Isle of Cold Moonlight](https://genshin-impact.fandom.com/wiki/The_Isle_of_Cold_Moonlight)"
     * * 6.3 "[The Lament of the Cliff-Shadowed Hollow](https://genshin-impact.fandom.com/wiki/The_Lament_of_the_Cliff-Shadowed_Hollow)"
     * @since 5.1
     */
    NEW_ACTIVITY_LIMITED_TIME_REWARD_AREA_BANNER(5105),

    // TODO document used models
    /**
     * Starting with 5.2 its used for the "[Heated Battle Mode: Automatic Artistry](https://genshin-impact.fandom.com/wiki/Heated_Battle_Mode)" events
     * @see NEW_ACTIVITY_GCG_FESTIVAL For other "Heated Battle Mode" tcg events
     * @since 5.2
     */
    NEW_ACTIVITY_GCG_AUTO_BATTLE_CARD(5201),

    // TODO document used models
    /**
     * This is the 5.2 "[Exercise Surging Storm](https://genshin-impact.fandom.com/wiki/Exercise_Surging_Storm)" event
     * @see NEW_ACTIVITY_MONSTER_CHESS_V2 For the newer version
     * @since 5.2
     */
    NEW_ACTIVITY_MONSTER_CHESS(5202),

    // TODO document used models
    /**
     * This is the 5.2 flagship event "[Iktomi Spiritseeking Scrolls](https://genshin-impact.fandom.com/wiki/Iktomi_Spiritseeking_Scrolls)".
     * @since 5.2
     */
    NEW_ACTIVITY_CEREMONY(5203),

    // TODO document used models
    /**
     * This is the 5.3 flagship event "[Springtime Charms](https://genshin-impact.fandom.com/wiki/Springtime_Charms)".
     * @since 5.2
     */
    NEW_ACTIVITY_LANTERN_RITE_V5(5204),

    // TODO document used models
    /**
     * This is the 5.3 "[Shuyu's Baffling Beetle Battle Bowl](https://genshin-impact.fandom.com/wiki/Shuyu%27s_Baffling_Beetle_Battle_Bowl)" event
     * See [NEW_ACTIVITY_ELECTROHERCULES_BATTLE] for the older Beetle battle events
     * @since 5.3
     */
    NEW_ACTIVITY_ELECTROHERCULES_BATTLE_V3(5301),

    // TODO document used models
    /**
     * This is the 5.3 "[Emblem of Steadfast Valor](https://genshin-impact.fandom.com/wiki/Emblem_of_Steadfast_Valor)" event
     * @since 5.3
     */
    NEW_ACTIVITY_NATLAN_RACE(5302),

    // TODO document used models
    /**
     * This is the 5.3 "[Repertoire of Myriad Melodies](https://genshin-impact.fandom.com/wiki/Repertoire_of_Myriad_Melodies)" announcement
     * @since 5.3
     */
    NEW_ACTIVITY_MUSIC_GAME_BOOK_BANNER(5303),

    // TODO document used models
    /**
     * This is the 5.4 flagship event "[Enchanted Tales of the Mikawa Festival](https://genshin-impact.fandom.com/wiki/Enchanted_Tales_of_the_Mikawa_Festival)".
     * @since 5.4
     */
    NEW_ACTIVITY_MIKAWA_FLOWER(5401),

    // TODO document used models
    /**
     * This is the 5.4 "[Reel Ad-Venture](https://genshin-impact.fandom.com/wiki/Reel_Ad-Venture)" event
     * @since 5.4
     */
    NEW_ACTIVITY_AD_SHOOTING(5402),

    // TODO document used models
    /**
     * This is the 5.4 "[Invasive Fish Wrangler](https://genshin-impact.fandom.com/wiki/Invasive_Fish_Wrangler)" event
     * @since 5.4
     */
    NEW_ACTIVITY_FISHING_JOY(5403),

    // TODO document used models
    /**
     * This is the 5.4 "[Realm of Tempered Valor](https://genshin-impact.fandom.com/wiki/Realm_of_Tempered_Valor)" event
     * @since 5.4
     */
    NEW_ACTIVITY_TOWER_CHALLENGE(5404),

    // TODO document used models
    /**
     * This is used for the "[Travelers' Tales](https://genshin-impact.fandom.com/wiki/Travelers'_Tales)" Anecdote events and info banners:
     * * 5.4 "[Travelers' Tales: Anthology Chapter](https://genshin-impact.fandom.com/wiki/Travelers%27_Tales_(Event)/2025-02-12)"
     * * 5.7 "[Travelers' Tales: Gilded Chapter](https://genshin-impact.fandom.com/wiki/Travelers%27_Tales_(Event)/2025-06-18)"
     *
     * Since 6.0 its permanent content so replaced with announcement banners
     * @since 5.4
     */
    NEW_ACTIVITY_ANECDOTE(5405),

    // TODO document used models
    /**
     * This is the 5.5 flagship event "[Tournament of Glory in Bloom](https://genshin-impact.fandom.com/wiki/Tournament_of_Glory_in_Bloom)".
     * @since 5.5
     */
    NEW_ACTIVITY_NATLAN_DRILL(5501),

    // TODO document used models
    /**
     * This is the 5.5 "[Quirky Quaking Arena](https://genshin-impact.fandom.com/wiki/Quirky_Quaking_Arena)" event
     * @since 5.5
     */
    NEW_ACTIVITY_PARTY(5502),

    // TODO document used models
    /**
     * This is the 5.5 "[Unlimited Fighting Championship](https://genshin-impact.fandom.com/wiki/Unlimited_Fighting_Championship)" event
     * @since 5.5
     */
    NEW_ACTIVITY_NATLAN_ARENA(5503),

    // TODO document used models
    /**
     * This is the 5.6 "[Chronicle of Shifting Stratagems](https://genshin-impact.fandom.com/wiki/Chronicle_of_Shifting_Stratagems)" event
     * @since 5.6
     */
    NEW_ACTIVITY_DIVERSITY_BATTLE(5601),

    // TODO document used models
    /**
     * This is the 5.6 flagship event "[Whirling_Waltz](https://genshin-impact.fandom.com/wiki/Whirling_Waltz)".
     * @since 5.6
     */
    NEW_ACTIVITY_THEME_PARK_SIM(5602),

    // TODO document used models
    /**
     * This is the 5.6 "[Legends Ablaze: Cross-Border Brawl](https://genshin-impact.fandom.com/wiki/Legends_Ablaze:_Cross-Border_Brawl)" event
     * @since 5.6
     */
    NEW_ACTIVITY_SAURUS_1V3(5603),

    // TODO document used models
    /**
     * This is the 5.6 "[Operation Downpour Simulation](https://genshin-impact.fandom.com/wiki/Operation_Downpour_Simulation)" event
     * @since 5.6
     */
    NEW_ACTIVITY_MVM2(5604),

    // TODO document used models
    /**
     * This is the "Stygian Onslaught" banner
     * @since 5.7
     */
    NEW_ACTIVITY_LEY_LINE_CHALLENGE(5701),

    // TODO document used models
    /**
     * This is the 5.7 flagship event "[Battle of Imagined Arrays](https://genshin-impact.fandom.com/wiki/Battle_of_Imagined_Arrays)".
     * @since 5.7
     */
    NEW_ACTIVITY_AUTO_CHESS(5702),

    // TODO document used models
    /**
     * This is the 5.8 flagship event "[Sunspray Summer Resort](https://genshin-impact.fandom.com/wiki/Sunspray_Summer_Resort_(Event))"
     * @since 5.8
     */
    NEW_ACTIVITY_HOLIDAY_RESORT(5801),

    // TODO document used models
    /**
     * This is the 5.8 "[Tracing Vanishing Trails](https://genshin-impact.fandom.com/wiki/Tracing_Vanishing_Trails)" event
     * @since 5.8
     */
    NEW_ACTIVITY_AGENTRECON(5802),

    // TODO document used models
    /**
     * Starting with 5.8 this is used for multiple limited time music game events.
     * This includes:
     * 5.8 "[Natlan: Plains of Flowing Flames](https://genshin-impact.fandom.com/wiki/Natlan:_Plains_of_Flowing_Flames_(Event))"
     * 6.0 "[Encounter: Memories of a Boundless Journey](https://genshin-impact.fandom.com/wiki/Encounter:_Memories_of_a_Boundless_Journey_(Event))"
     * 6.4 "[Nod-Krai: Gateway to the Borderland Elysium](https://genshin-impact.fandom.com/wiki/Nod-Krai:_Gateway_to_the_Borderland_Elysium_(Event))"
     * @since 5.8
     */
    NEW_ACTIVITY_MUSIC_GAME_BOOK_LIMITED_TIME_BANNER(5803),


    // TODO document used models
    /**
     * This is the 6.0 "[Dodoco's Blow-Up-Erative Bomb-Nanza](https://genshin-impact.fandom.com/wiki/Dodoco%27s_Blow-Up-Erative_Bomb-Nanza)" event
     * @see NEW_ACTIVITY_FISHBLASTER For the 4.1 "Dodoco's Bomb-Tastic Adventure" event
     * @see NEW_ACTIVITY_BOMBER_DODOCO For the 5.0 "Dodoco's Boom-Bastic Escapades"
     * @since 6.0
     */
    @AddedIn(GI_6_0_0)
    NEW_ACTIVITY_BOMBER_V3(6001),

    // TODO document used models
    /**
     * This is the 6.0 flagship event "[Clink Clank Clash](https://genshin-impact.fandom.com/wiki/Clink_Clank_Clash)"
     * @since 6.0
     */
    @AddedIn(GI_6_0_0)
    NEW_ACTIVITY_NODKRAI_TOUR(6002),

    // TODO document used models
    /**
     * Since 6.0 this is used for the "[To Temper Thyself and Journey Far](https://genshin-impact.fandom.com/wiki/To_Temper_Thyself_and_Journey_Far)" daily challenge event that rewards stella fortunas
     * @since 6.0
     */
    @AddedIn(GI_6_0_0)
    NEW_ACTIVITY_WEEK_ACTIVE(6003),


    // TODO document used models
    // TODO check why it is in [NEW_ACTIVITY_NEWBIE_PERMANENT_BANNER] and [NEW_ACTIVITY_PERMANENT_BANNER]
    /**
     * This is used for the "[Uncover Lunar Realms, Hone the Eventide Radiance](https://genshin-impact.fandom.com/wiki/Uncover_Lunar_Realms,_Hone_the_Eventide_Radiance/2025-09-10)" event banner
     * @since 6.1
     */
    @AddedIn(GI_6_1_0)
    NEW_ACTIVITY_NEWBIE_PERMANENT_BANNER(6101),

    // TODO document used models
    /**
     * This is the 6.1 flagship event "[Ruins Exploration: Fieldwise Center](https://genshin-impact.fandom.com/wiki/Ruins_Exploration:_Fieldwise_Center)".
     * @since 6.1
     */
    @AddedIn(GI_6_1_0)
    NEW_ACTIVITY_SUMERU_ADVENTURE_TRAINING(6102),

    // TODO document used models
    /**
     * This is the 6.1 "[Saurian Sojourn](https://genshin-impact.fandom.com/wiki/Saurian_Sojourn)" event.
     * @since 6.1
     */
    @AddedIn(GI_6_1_0)
    NEW_ACTIVITY_HUMAN_DRAGON_PUZZLE(6103),

    // TODO document used models
    /**
     * This is the 6.1 "[Dance Dance Dynamic Disco](https://genshin-impact.fandom.com/wiki/Dance_Dance_Dynamic_Disco)" event.
     * @since 6.1
     */
    @AddedIn(GI_6_1_0)
    NEW_ACTIVITY_MUSIC_PARTY(6104),

    // TODO document used models
    /**
     * Since 6.1 this is used to advertise new ugc costumes under the name "Wonderland Treasures"
     * @since 6.1
     */
    @AddedIn(GI_6_1_0)
    NEW_ACTIVITY_BEYOND_COSTUME_BANNER(6105),

    // TODO document used models
    /**
     * TODO identify 6.1 event
     * @since 6.1
     */
    @AddedIn(GI_6_1_0)
    NEW_ACTIVITY_BEYOND_INITIAL_ACTIVE(6106),


    // TODO document used models
    /**
     * This is the 6.2 "[Bing-Bang Finchball](https://genshin-impact.fandom.com/wiki/Bing-Bang_Finchball)" event.
     * @see NEW_ACTIVITY_BIRD_BALL For the 4.8 occurrence
     * @since 6.2
     */
    @AddedIn(GI_6_2_0)
    NEW_ACTIVITY_BIRD_PIN_BALL(6201),

    // TODO document used models
    /**
     * This is the 6.2 flagship event "[Soulblazers' Snowbound Journey](https://genshin-impact.fandom.com/wiki/Soulblazers%27_Snowbound_Journey)"
     * @since 6.2
     */
    @AddedIn(GI_6_2_0)
    NEW_ACTIVITY_SNOW_RACE(6202),

    // TODO document used models
    /**
     * This is the 6.2 "[Heroic Clash: Saurian Brawl](https://genshin-impact.fandom.com/wiki/Heroic_Clash:_Saurian_Brawl)" event
     * @since 6.2
     */
    @AddedIn(GI_6_2_0)
    NEW_ACTIVITY_NATLAN_DRAGON_PARTY(6203),


    // TODO document used models
    /**
     * This is the 6.3 "[Moonlit Patrol Exercise](https://genshin-impact.fandom.com/wiki/Moonlit_Patrol_Exercise)" event
     * @see NEW_ACTIVITY_MONSTER_CHESS For the previous version
     * @since 6.3
     */
    @AddedIn(GI_6_3_0)
    NEW_ACTIVITY_MONSTER_CHESS_V2 (6301),

    // TODO document used models
    /**
     * This is the 6.3 "[Shutterflash Memory Hunt](https://genshin-impact.fandom.com/wiki/Shutterflash_Memory_Hunt)" event
     * @since 6.3
     */
    @AddedIn(GI_6_3_0)
    NEW_ACTIVITY_TIME_STOP_PHOTO (6302),

    // TODO document used models
    /**
     * This is the 6.3 flagship/lantern rite event "[A Lanternlit Ode to the Silver Moon](https://genshin-impact.fandom.com/wiki/A_Lanternlit_Ode_to_the_Silver_Moon)".
     * @since 6.3
     */
    @AddedIn(GI_6_3_0)
    NEW_ACTIVITY_LANTERN_RITE_V6 (6303),

    // TODO document used models
    /**
     * This is a banner for the 6.3 world quest "[A Gift From the Sea Spirits](https://genshin-impact.fandom.com/wiki/A_Gift_From_the_Sea_Spirits)"
     * @since 6.3
     */
    @AddedIn(GI_6_3_0)
    NEW_ACTIVITY_SKIN_BANNER (6304),


    /**
     * This is a placeholder used when the actual activity string can not be identified. Check [ActivityData.activityTypeString] in this case.
     */
    NEW_ACTIVITY_UNKNOWN(999999);

    override fun getIntKey() = id
}
