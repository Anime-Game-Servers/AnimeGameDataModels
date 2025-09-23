package org.anime_game_servers.game_data_models.gi.data.activity

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

    /**
     * Closed beta (CB2) lantern rite has its own activity specific packages.
     * This event also uses special activity groups in `Activity/1001/`
     * TODO document used models
     */
    NEW_ACTIVITY_SEA_LAMP(1),

    /**
     * The elemental crucible event: [see here](https://genshin-impact.fandom.com/wiki/Elemental_Crucible)
     * From here on the normal activity info packages are used.
     * Some instances of this event use special activity groups in `Activity/5001/`
     * TODO document used models
     */
    NEW_ACTIVITY_CRUCIBLE(2),

    /**
     * The Marvelous Merchandise event: [first occurrence see here](https://genshin-impact.fandom.com/wiki/Marvelous_Merchandise/2020-10-26)
     * This event also uses special activity groups in `Activity/5003/`
     * TODO document used models
     */
    NEW_ACTIVITY_SALESMAN(3),

    /**
     * This is the Character Trial Event: [see here](https://genshin-impact.fandom.com/wiki/Test_Run_-_Character_Trial_Event)
     * This event also uses special activity groups in `Activity/5002/`
     * TODO document used models
     */
    NEW_ACTIVITY_TRIAL_AVATAR(4),

    /**
     * TODO identify this activity, it doesn't have an entry in NewActivityExcelConfigData
     * TODO document used models
     */
    NEW_ACTIVITY_SIGNIN(5),

    /**
     * TODO identify this activity, it doesn't have an entry in NewActivityExcelConfigData
     * TODO document used models
     */
    NEW_ACTIVITY_BONUS(6),

    /**
     * TODO identify this activity, it doesn't have an entry in NewActivityExcelConfigData
     * TODO document used models
     */
    NEW_ACTIVITY_NEWBEEBONUS(7),

    /**
     * This is used for showing activity/event banners for new storylines
     * TODO document used models
     */
    NEW_ACTIVITY_PERSONAL_LIINE(8),

    /**
     * This is the "[While It's Watm](https://genshin-impact.fandom.com/wiki/While_It%27s_Warm)" Event from version 1.1
     * TODO document used models
     */
    NEW_ACTIVITY_DELIVERY(9),

    /**
     * This is the "[Gliding Challenge](https://genshin-impact.fandom.com/wiki/Gliding_Challenge)" Event from version 1.1
     * This event also uses special activity groups in `Activity/5007/`
     * TODO document used models
     */
    NEW_ACTIVITY_FLIGHT(10),

    /**
     * TODO identify this activity, it doesn't have an entry in NewActivityExcelConfigData, probably some type of placeholder
     * TODO document used models
     */
    NEW_ACTIVITY_TEMP(99),

    /**
     * This is the [Unreconciled Stars](https://genshin-impact.fandom.com/wiki/Unreconciled_Stars) Event.
     * This event also uses special activity groups in `Activity/2001/`
     * TODO document used models
     */
    NEW_ACTIVITY_ASTER(1100),

    /**
     * The "[The Chalk Prince and the Dragon](https://genshin-impact.fandom.com/wiki/The_Chalk_Prince_and_the_Dragon)" event was
     * a dragon spine event.
     * This event also uses special activity groups in `Activity/3001/`
     * TODO document used models
     */
    NEW_ACTIVITY_DRAGONSPINE(1200),

    /**
     * TODO identify this activity, it doesn't have an entry in NewActivityExcelConfigData
     * TODO document used models
     */
    NEW_ACTIVITY_REUNION(1201),

    /**
     * This is the "[Hypostatic Symphony](https://genshin-impact.fandom.com/wiki/Hypostatic_Symphony/2021-01-16)" Event
     * TODO document used models
     */
    NEW_ACTIVITY_EFFIGY(1202),

    /**
     * TODO identify this activity, it doesn't have an entry in NewActivityExcelConfigData, likely to show the Tower schedule has changed
     * TODO document used models
     */
    NEW_ACTIVITY_TOWER_RESET(1203),

    /**
     * This is the "[Lost Riches](https://genshin-impact.fandom.com/wiki/Lost_Riches)" Event, first run during 1.2
     * This is the 2.0 "[Lost Riches](https://genshin-impact.fandom.com/wiki/Lost_Riches/2021-08-06) event as well.
     * Some instances of this event also use special activity groups in `Activity/5011/`
     * see NEW_ACTIVITY_TREASURE_SEELIE for the 3.0 version
     * TODO document used models
     */
    NEW_ACTIVITY_TREASURE_MAP(1204),

    /**
     * This is a newer version of "[Marvelous Merchandise](https://genshin-impact.fandom.com/wiki/Marvelous_Merchandise)"
     * This event also uses special activity groups in `Activity/5012/`
     * TODO identify the differences  between both salesman activities
     * TODO document used models
     */
    NEW_ACTIVITY_SALESMAN_MP(1205),

    /**
     * This should be the the "[May Fortune Find You](https://genshin-impact.fandom.com/wiki/May_Fortune_Find_You/2021-02-11)" Event from version 1.3
     * TODO document used models
     */
    NEW_ACTIVITY_BLESSING(1300),

    /**
     * This events first occurence should be the "[Five Flushes of Fortune](https://genshin-impact.fandom.com/wiki/Five_Flushes_of_Fortune)" event.
     * TODO document used models
     */
    NEW_ACTIVITY_EXPEDITION(1301),

    /**
     * This is the 1.3 "[Lantern Rite](https://genshin-impact.fandom.com/wiki/Lantern_Rite)" event
     * This event also uses special activity groups in `Activity/2002/`
     * TODO document used models
     */
    NEW_ACTIVITY_SEA_LAMP_NEW(1302),

    /**
     * This is the 1.4 "[Invitation of Windblume](https://genshin-impact.fandom.com/wiki/Invitation_of_Windblume)" Event.
     * This event also uses special activity groups in `Activity/2003/`
     * TODO document used models
     */
    NEW_ACTIVITY_FLEUR_FAIR(1400),

    /**
     * TODO identify this activity, it doesn't have an entry in NewActivityExcelConfigData
     * TODO document used models
     */
    NEW_ACTIVITY_OPERATIONS_BONUS(1401),

    /**
     * This event first occurred during version 1.4. This is the "[Contending Tides](https://genshin-impact.fandom.com/wiki/Contending_Tides)" event
     * TODO document used models
     */
    NEW_ACTIVITY_ARENA_CHALLENGE(1402),

    /**
     * This should be the "[Wishful Drops](https://genshin-impact.fandom.com/wiki/Wishful_Drops)" Event from version 1.4.
     * TODO document used models
     */
    NEW_ACTIVITY_WATER_SPIRIT_CHALLENGE(1403),

    /**
     * This is likely the 1.4 "[Outland Gastronomy](https://genshin-impact.fandom.com/wiki/Outland_Gastronomy)" event.
     * TODO verify this
     * TODO document used models
     */
    NEW_ACTIVITY_SIGNIN_COMPANION(1404),

    /**
     * This is an announcement activity/event to inform the user about new [Handout Events](https://genshin-impact.fandom.com/wiki/Hangout_Event), and was first used in 1.4.
Known occurrences include:
     * [1.4 Hangout Events Series I](https://genshin-impact.fandom.com/wiki/Hangout_Event?file=Hangout_Events_Series_I.png),
[1.5 Hangout Events Series II](https://genshin-impact.fandom.com/wiki/Hangout_Event?file=Hangout_Events_Series_II.png),
[2.2 Hangout Events Series III](https://genshin-impact.fandom.com/wiki/Hangout_Event?file=Hangout_Events_Series_III.png),
[2.3 Hangout Events Series IV](https://genshin-impact.fandom.com/wiki/Hangout_Event?file=Hangout_Events_Series_IV.png),
[2.4 Hangout Events Series V](https://genshin-impact.fandom.com/wiki/Hangout_Event?file=Hangout_Events_Series_V.png),
[2.7 Hangout Events Series VI](https://genshin-impact.fandom.com/wiki/Hangout_Event?file=Hangout_Events_Series_VI.png),
[2.8 Hangout Events Series VII](https://genshin-impact.fandom.com/wiki/Hangout_Event?file=Hangout_Events_Series_VII.png),
[3.5 Hangout Events Series VIII](https://genshin-impact.fandom.com/wiki/Hangout_Event?file=Hangout_Events_Series_VIII.png),
[3.6 Hangout Events Series IX](https://genshin-impact.fandom.com/wiki/Hangout_Event?file=Hangout_Events_Series_IX.png),
[3.7 Hangout Events Series X](https://genshin-impact.fandom.com/wiki/Hangout_Event?file=Hangout_Events_Series_X.png),
[3.8 Hangout Events Series XI](https://genshin-impact.fandom.com/wiki/Hangout_Event?file=Hangout_Events_Series_XI.png),
[4.5 Hangout Events Series XII](https://genshin-impact.fandom.com/wiki/Hangout_Event?file=Hangout_Events_Series_XII.png)
     * TODO document used models
     */
    NEW_ACTIVITY_COOP(1405),

    /**
     * This is the 1.3(!?) "[Even Mountains Tremble](https://genshin-impact.fandom.com/wiki/No_Restoring_This_Past_Land_of_Beauty#Even_Mountains_Tremble) boss announcement banner
     * TODO document used models
     */
    NEW_ACTIVITY_MONSTER_BANNER_DRAKE_PRIMO_ROCK(1501),

    /**
     * This is the 1.5 "[Energy Amplifier](https://genshin-impact.fandom.com/wiki/Energy_Amplifier)" event
     * This is the 2.3 "[Energy Amplifier Fruition](https://genshin-impact.fandom.com/wiki/Energy_Amplifier/2021-12-24)" event
     * for Energy Amplifier: Lemma, see NEW_ACTIVITY_RECHARGE_DISK
     * TODO document used models
     */
    NEW_ACTIVITY_CHANNELER_SLAB(1502),

    /**
     * This is the "[Battlefront: Misty Dungeon](https://genshin-impact.fandom.com/wiki/Battlefront:_Misty_Dungeon)" Event, which first occurred during version 1.5
     * TODO document used models
     */
    NEW_ACTIVITY_MISTTRIAL(1503),

    /**
     * This is the "[Windtrace](https://genshin-impact.fandom.com/wiki/Windtrace)" Event, which first occurred during version 1.5
     * TODO document used models
     */
    NEW_ACTIVITY_HIDEANDSEEK(1504),

    /**
     * This is the "[Mimi Tomo](https://genshin-impact.fandom.com/wiki/Mimi_Tomo)" Event, which first occurred during version 1.5
     * TODO document used models
     */
    NEW_ACTIVITY_FIND_HILICHURL(1505),

    /**
     * this is the 1.5 "[Chilled to the Bone](https://genshin-impact.fandom.com/wiki/Cryo_Hypostasis?file=Chilled_to_the_Bone.png)" boss announcement banner
     * TODO document used models
     */
    NEW_ACTIVITY_MONSTER_BANNER_EFFIGY_ICE(1506),

    /**
     * TODO identify this activity, probably the Teapot announcement banner
     * TODO document used models
     */
    NEW_ACTIVITY_HOMEWORLD(1507),

    /**
     * TODO identify this activity, it doesn't have an entry in NewActivityExcelConfigData
     * TODO document used models
     */
    NEW_ACTIVITY_H5(1508),

    /**
     * This is the "[Midsummer Island Adventure](https://genshin-impact.fandom.com/wiki/Midsummer_Island_Adventure)" Event from version 1.6.
     * In this event the player gets to visit the Golden Apple Archipelago. The tide level of the sea changes based on the
     * scene tags controlled by [ActivityCondData].
     * TODO document used models
     */
    NEW_ACTIVITY_SUMMER_TIME(1600),

    /**
     * This is the "[Never-Ending Battle](https://genshin-impact.fandom.com/wiki/Never-Ending_Battle)" Event from version 1.6.
     * TODO document used models
     */
    NEW_ACTIVITY_BUOYANT_COMBAT(1601),

    /**
     * This event ran twice, once as [Echoing Tales](https://genshin-impact.fandom.com/wiki/Echoing_Tales) and once as
     * [Resonating Visions](https://genshin-impact.fandom.com/wiki/Resonating_Visions), both times accompanying the Summer Times events
     * [NEW_ACTIVITY_SUMMER_TIME] and [NEW_ACTIVITY_SUMMER_TIME_2_8].
     * In these events the player needs to collect echo shells to unlock voice lines and rewards.
     * Used Models: [EchoShellData], [EchoShellFloatSignalData], [EchoShellPreviewData], [EchoShellRewardData],
     * [EchoShellSummerTimeDungeonData]
     */
    NEW_ACTIVITY_ECHO_SHELL(1602),

    /**
     * This is the "[Kaboomball Kombat](https://genshin-impact.fandom.com/wiki/Kaboomball_Kombat)" Event from version 1.6.
     * TODO document used models
     */
    NEW_ACTIVITY_BOUNCE_CONJURING(1603),

    /**
     * This is might be the "[Legend of the Vagabond Sword](https://genshin-impact.fandom.com/wiki/Legend_of_the_Vagabond_Sword)" Event from version 1.6.
     * This is might be the 1.6 announcement for "[Autumn Winds, Scarlet Leaves](https://genshin-impact.fandom.com/wiki/Autumn_Winds,_Scarlet_Leaves?file=Autumn_Winds%2C_Scarlet_Leaves_Event_Page.png)"
     * TODO verify this. Where did Legend of the Vagabond Sword go?
     * TODO document used models
     */
    NEW_ACTIVITY_DAOQI_ADVERTISEMENT(1604),

    /**
     * This is the 2.0 "[Thunder Sojourn](https://genshin-impact.fandom.com/wiki/Thunder_Sojourn)" event
     * TODO document used models
     */
    NEW_ACTIVITY_BLITZ_RUSH(2001),

    /**
     * This is the 2.0 "[Theater Mechanicus: Stage of Wonders](https://genshin-impact.fandom.com/wiki/Theater_Mechanicus/2021-08-12)" event
     * TODO document used models
     */
    NEW_ACTIVITY_CHESS(2002),

    /**
     * This is the 2.0 "[Bellowing Blaze](https://genshin-impact.fandom.com/wiki/Pyro_Hypostasis#Bellowing_Blaze)" boss announcement banner
     * TODO document used models
     */
    NEW_ACTIVITY_MONSTER_BANNER_EFFIGY_FIRE(2003),

    /**
     * This is the 2.0 "[Machine Battlefront](https://genshin-impact.fandom.com/wiki/Perpetual_Mechanical_Array#Machine_Battlefront)" boss announcement banner
     * TODO document used models
     */
    NEW_ACTIVITY_MONSTER_BANNER_PERPETUAL(2004),

    /**
     * This is the 2.0 "[Grus Nivis Chapter](https://genshin-impact.fandom.com/wiki/Grus_Nivis_Chapter?file=Grus_Nivis_Chapter_Event_Menu.png)" story quest banner announcement
     * Typically NEW_ACTIVITY_PERSONAL_LIINE(8) is used for these
     * TODO document used models
     */
    NEW_ACTIVITY_PERSONAL_LIINE_2(2005),

    /**
     * Various 2.1+ boss announcement banners
     * TODO document used models
     */
    NEW_ACTIVITY_GENERAL_BANNER(2100),

    /**
     * This is the 2.1 "[Moonlight Merriment](https://genshin-impact.fandom.com/wiki/Moonlight_Merriment)" event
     * TODO document used models
     */
    NEW_ACTIVITY_LUNA_RITE(2101),

    /**
     * This is the 2.1/2.5/3.1 [Hyakunin Ikki](https://genshin-impact.fandom.com/wiki/Hyakunin_Ikki)" event
     * TODO document used models
     */
    NEW_ACTIVITY_SUMO(2102),

    /**
     * This is the 2.1 [Lunar Realm](https://genshin-impact.fandom.com/wiki/Lunar_Realm)" event
     * TODO document used models
     */
    NEW_ACTIVITY_MOONFIN_TRIAL(2103),

    /**
     * This is the 2.1 "[Mendacious Waves](https://genshin-impact.fandom.com/wiki/Hydro_Hypostasis#Mendacious_Waves)" boss announcement banner
     * TODO document used models
     */
    NEW_ACTIVITY_MONSTER_BANNER_EFFIGY_WATER(2104),

    /**
     * This is the 2.1 "[Distant Storm](https://genshin-impact.fandom.com/wiki/Thunder_Manifestation#Distant_Storm)" boss announcement banner
     * TODO document used models
     */
    NEW_ACTIVITY_MONSTER_BANNER_RAIJIN(2105),

    /**
     * This is the 2.2 "[Dreams of Bloom](https://genshin-impact.fandom.com/wiki/Dreams_of_Bloom)" event
     * TODO document used models
     */
    NEW_ACTIVITY_PLANT_FLOWER(2200),

    /**
     * This is the 2.2 "[Labyrinth Warriors](https://genshin-impact.fandom.com/wiki/Labyrinth_Warriors)" event
     * TODO document used models
     */
    NEW_ACTIVITY_ROGUELIKE_DUNGEON(2201),

    /**
     * This is the 2.2 "[Tuned to the World's Sounds](https://genshin-impact.fandom.com/wiki/Tuned_to_the_World%27s_Sounds)" event
     * This is also the 2.7 "[The Almighty Arataki Great and Glorious Drumalong Festival](https://genshin-impact.fandom.com/wiki/The_Almighty_Arataki_Great_and_Glorious_Drumalong_Festival)" event
     * TODO document used models
     */
    NEW_ACTIVITY_MUSIC_GAME(2202),

    /**
     * This is the 2.2 "[Shadow of the Ancients](https://genshin-impact.fandom.com/wiki/Shadow_of_the_Ancients)" event
     * TODO document used models
     */
    NEW_ACTIVITY_DIG(2203),

    /**
     * This is the 2.1(?) "[Exploding Population](https://genshin-impact.fandom.com/wiki/Exploding_Population)" world quest(?)
     * TODO document used models
     */
    NEW_ACTIVITY_MOONFIN_BANNER(2204),

    /**
     * This is the "[Shadows Amidst Snowstorms](https://genshin-impact.fandom.com/wiki/Shadows_Amidst_Snowstorms)" Event from version 2.3.
     * TODO document used models
     */
    NEW_ACTIVITY_WINTER_CAMP(2301),

    /**
     * This is the 2.3 "[Bantan Sango Case Files: The Warrior Dog](https://genshin-impact.fandom.com/wiki/Bantan_Sango_Case_Files:_The_Warrior_Dog)" event
     * TODO document used models
     */
    NEW_ACTIVITY_HACHI(2302),

    /**
     * This is the 2.4 "[A Study in Potions](https://genshin-impact.fandom.com/wiki/A_Study_in_Potions)" event
     * TODO document used models
     */
    NEW_ACTIVITY_POTION(2400),

    /**
     * This is the 2.4 "[Eight Locales Over Mountains and Seas](https://genshin-impact.fandom.com/wiki/Eight_Locales_Over_Mountains_and_Seas)" event
     * TODO document used models
     */
    NEW_ACTIVITY_TANUKI_TRAVEL(2401),

    /**
     * This is the "[Fleeting Colors in Flight](https://genshin-impact.fandom.com/wiki/Fleeting_Colors_in_Flight)"/Lantern rite Event from version 2.4.
     * TODO document used models
     */
    NEW_ACTIVITY_SEA_LAMP_2_4(2402),

    /**
     * TODO identify this activity
     * TODO document used models
     */
    NEW_ACTIVITY_MICHIAE_MATSURI(2501),

    /**
     * This is the 2.5 "[Of Drink A-Dreaming](https://genshin-impact.fandom.com/wiki/Of_Drink_A-Dreaming)" event
     * TODO document used models
     */
    NEW_ACTIVITY_BARTENDER(2502),

    /**
     * This is the 2.5 "[Divine Ingenuity](https://genshin-impact.fandom.com/wiki/Divine_Ingenuity/2022-03-02)" event
     * TODO document used models
     */
    NEW_ACTIVITY_UGC(2503),

    /**
     * This is the 2.6 "[Hues of the Violet Garden](https://genshin-impact.fandom.com/wiki/Hues_of_the_Violet_Garden)" event
     * TODO document used models
     */
    NEW_ACTIVITY_IRODORI(2600),

    /**
     * This is the 2.6 "[Vibro-Crystal Research](https://genshin-impact.fandom.com/wiki/Vibro-Crystal/2022-04-21)" event
     * This is the 3.5 "[Vibro-Crystal Verification](https://genshin-impact.fandom.com/wiki/Vibro-Crystal/2023-03-14)" event
     * This is the 4.6 "[Vibro-Crystal Applications](https://genshin-impact.fandom.com/wiki/Vibro-Crystal/2024-04-28)" event
     * TODO document used models
     */
    NEW_ACTIVITY_CRYSTAL_LINK(2601),

    /**
     * This is the 2.6 "[Spices From the West](https://genshin-impact.fandom.com/wiki/Spices_From_the_West/2022-05-14)" event
     * This is the 3.5 "[Spices From the West: Northerly Search](https://genshin-impact.fandom.com/wiki/Spices_From_the_West/2023-03-31)" event
     * TODO document used models
     */
    NEW_ACTIVITY_SPICE(2602),

    /**
     * This is the 2.6 "[Outside the Canvas, Inside the Lens](https://genshin-impact.fandom.com/wiki/Outside_the_Canvas,_Inside_the_Lens/2022-04-01)" event
     * This is the 3.2 "[Outside the Canvas, Inside the Lens: Greenery Chapter](https://genshin-impact.fandom.com/wiki/Outside_the_Canvas,_Inside_the_Lens/2022-11-16)" event
     * This is the 4.8 "[Outside the Canvas, Inside the Lens: Dew-Kissed Chapter](https://genshin-impact.fandom.com/wiki/Outside_the_Canvas,_Inside_the_Lens/2024-07-29)" event
     * This is the 5.0 "[Mementos of Teyvat](https://genshin-impact.fandom.com/wiki/Mementos_of_Teyvat)" event
     * TODO document used models
     */
    NEW_ACTIVITY_PHOTO(2603),

    /**
     * This is the 2.7 "[A Muddy Bizarre Adventure](https://genshin-impact.fandom.com/wiki/A_Muddy_Bizarre_Adventure)" event
     * TODO document used models
     */
    NEW_ACTIVITY_LUMINANCE_STONE_CHALLENGE(2702),

    /**
     * This is the 2.7 "[Core of the Apparatus](https://genshin-impact.fandom.com/wiki/Core_of_the_Apparatus)" event
     * TODO document used models
     */
    NEW_ACTIVITY_GACHA(2703),

    /**
     * TODO identify this activity
     * TODO document used models
     */
    NEW_ACTIVITY_ROGUE_DIARY(2704),

    /**
     * This is the "[Summertime Odyssey](https://genshin-impact.fandom.com/wiki/Summertime_Odyssey)" Event from version 2.8.
     * TODO document used models
     */
    NEW_ACTIVITY_SUMMER_TIME_2_8(2801),

    /**
     * This is the 2.8 "[Evermotion Mechanical Painting](https://genshin-impact.fandom.com/wiki/Evermotion_Mechanical_Painting)" event
     * TODO document used models
     */
    NEW_ACTIVITY_GEAR(2802),

    /**
     * This is the 2.8 "[Reminiscent Regimen](https://genshin-impact.fandom.com/wiki/Reminiscent_Regimen/2022-08-04)" event
     * TODO document used models
     */
    NEW_ACTIVITY_ISLAND_PARTY(2803),

    /**
     * This is the 3.0 "[Graven Innocence](https://genshin-impact.fandom.com/wiki/Graven_Innocence)" event
     * TODO document used models
     */
    NEW_ACTIVITY_GRAVEN_INNOCENCE(3000),

    /**
     * This is the 3.0 "[Tablet Analytics](https://genshin-impact.fandom.com/wiki/Tablet_Analytics)" event
     * TODO document used models
     */
    NEW_ACTIVITY_INSTABLE_SPRAY(3001),

    /**
     * This is the 3.0 "[Fayz Trials](https://genshin-impact.fandom.com/wiki/Fayz_Trials/2022-09-08)" event
     * This is the 3.7 "[Fayz Trials: Hypothesis](https://genshin-impact.fandom.com/wiki/Fayz_Trials/2023-06-21)" event
     * For the The Great Fayz Reaction Debate, see NEW_ACTIVITY_AUTO_TIME_STOP
     * TODO document used models
     */
    NEW_ACTIVITY_MUQADAS_POTION(3002),

    /**
     * This is the 3.0 "[Lost Riches](https://genshin-impact.fandom.com/wiki/Lost_Riches/2022-09-02)" event
     * see NEW_ACTIVITY_TREASURE_MAP for the 1.2 and 2.0 version
     * TODO document used models
     */
    NEW_ACTIVITY_TREASURE_SEELIE(3003),

    /**
     * This is the 3.1 "[Wind Chaser](https://genshin-impact.fandom.com/wiki/Wind_Chaser)" event
     * TODO document used models
     */
    NEW_ACTIVITY_WIND_FIELD(3101),

    /**
     * This is the 3.1 "[Star-Seeker's Sojourn](https://genshin-impact.fandom.com/wiki/Star-Seeker%27s_Sojourn)" event
     * TODO document used models
     */
    NEW_ACTIVITY_ROCK_BOARD_EXPLORE(3102),

    /**
     * This is the 3.1 "[Of Ballads and Brews](https://genshin-impact.fandom.com/wiki/Of_Ballads_and_Brews)" event
     * TODO document used models
     */
    NEW_ACTIVITY_VINTAGE(3103),

    /**
     * This is the 3.2 "[Fabulous Fungus Frenzy](https://genshin-impact.fandom.com/wiki/Fabulous_Fungus_Frenzy)" event
     * TODO document used models
     */
    NEW_ACTIVITY_FUNGUS_FIGHTER(3201),

    /**
     * This is the 3.2 "[Adventurer's Trials](https://genshin-impact.fandom.com/wiki/Adventurer%27s_Trials/2022-11-04)" event
     * TODO document used models
     */
    NEW_ACTIVITY_CHAR_AMUSEMENT(3202),

    /**
     * This is the 3.2 "[Hypostatic Symphony: Dissonant Verse](https://genshin-impact.fandom.com/wiki/Hypostatic_Symphony/2022-11-24)" event
     * TODO document used models
     */
    NEW_ACTIVITY_EFFIGY_CHALLENGE_V2(3203),

    /**
     * This is the 3.3 "[Akitsu Kimodameshi](https://genshin-impact.fandom.com/wiki/Akitsu_Kimodameshi)" event
     * TODO document used models
     */
    NEW_ACTIVITY_BRICK_BREAKER(3300),

    /**
     * this is maybe the 3.3 "[Across the Wilderness](https://genshin-impact.fandom.com/wiki/Across_the_Wilderness)" event
     * TODO verify this.
     * TODO document used models
     */
    NEW_ACTIVITY_COIN_COLLECT(3301),

    /**
     * This is the 3.4 "[Warrior's Spirit](https://genshin-impact.fandom.com/wiki/Warrior%27s_Spirit)" event
     * TODO document used models
     */
    NEW_ACTIVITY_DUEL_HEART(3400),

    /**
     * This is the 3.4 "[The Exquisite Night Chimes](https://genshin-impact.fandom.com/wiki/The_Exquisite_Night_Chimes)" event
     * TODO document used models
     */
    NEW_ACTIVITY_SEA_LAMP_3_4(3401),

    /**
     * This is the 3.4 "[Almighty Arataki Extraordinary and Exhilarating Extreme Beetle Brawl](https://genshin-impact.fandom.com/wiki/Almighty_Arataki_Extraordinary_and_Exhilarating_Extreme_Beetle_Brawl)" event
     * TODO document used models
     */
    NEW_ACTIVITY_ELECTROHERCULES_BATTLE(3402),

    /**
     * This is the 3.4 "[Second Blooming](https://genshin-impact.fandom.com/wiki/Second_Blooming](https://genshin-impact.fandom.com/wiki/Second_Blooming)" event
     * TODO document used models
     */
    NEW_ACTIVITY_TEAM_CHAIN(3403),

    /**
     * This is maybe the 3.4 "[Heated Battle Mode: Omnipotent Guide](https://genshin-impact.fandom.com/wiki/Heated_Battle_Mode/2023-01-28)
     * As of 5.3, this banner shows [Heated Battle Mode: Sprinting Stratagems](https://genshin-impact.fandom.com/wiki/Heated_Battle_Mode/2024-01-06) instead of the expected "Omnipotent Guide"
     * TODO document used models
     */
    NEW_ACTIVITY_GCG_FESTIVAL(3404),

    /**
     * This is the 3.4 "[Desert of Hadramaveth](https://genshin-impact.fandom.com/wiki/Desert_of_Hadramaveth?file=Desert_of_Hadramaveth_Event_Menu.png)" location announcement
     * TODO document used models
     */
    NEW_ACTIVITY_SANDY_LAND_BANNER(3405),

    /**
     * This is the 3.5 "[Windblume's Breath](https://genshin-impact.fandom.com/wiki/Windblume%27s_Breath)" event
     * TODO document used models
     */
    NEW_ACTIVITY_FLEURFAIR_V2(3500),

    /**
     * This is the 3.5 "[Fungus Mechanicus](https://genshin-impact.fandom.com/wiki/Fungus_Mechanicus)" event
     * TODO document used models
     */
    NEW_ACTIVITY_FUNGUS_FIGHTER_V2(3501),

    /**
     * This is the 3.6 "[Fulminating Sandstorm](https://genshin-impact.fandom.com/wiki/Fulminating_Sandstorm)" event
     * TODO document used models
     */
    NEW_ACTIVITY_SANDWORM_CANNON(3600),

    /**
     * This is the 3.6 "[A Parade of Providence](https://genshin-impact.fandom.com/wiki/A_Parade_of_Providence)" event
     * TODO document used models
     */
    NEW_ACTIVITY_AKA_FES(3601),

    /**
     * This is the 3.6 "[The Recollector's Path](https://genshin-impact.fandom.com/wiki/The_Recollector%27s_Path)" event
     * TODO document used models
     */
    NEW_ACTIVITY_SORUSH_TRIAL(3602),

    /**
     * This is the 3.7 "[Divine Ingenuity: Collector's Chapter](https://genshin-impact.fandom.com/wiki/Divine_Ingenuity/2023-06-08)" event
     * TODO document used models
     */
    NEW_ACTIVITY_UGC_V2(3701),

    /**
     * This is the 3.7 "[Feast of the Departed Warriors](https://genshin-impact.fandom.com/wiki/Feast_of_the_Departed_Warriors)" event
     * TODO document used models
     */
    NEW_ACTIVITY_EFFIGY_CHALLENGE_V4(3702),

    /**
     * This is the 3.7 "[Duel! The Summoners' Summit!](https://genshin-impact.fandom.com/wiki/Duel!_The_Summoners%27_Summit!)" event
     * TODO document used models
     */
    NEW_ACTIVITY_JOURNEY(3703),

    /**
     * TODO identify this activity
     * TODO document used models
     */
    NEW_ACTIVITY_GCG_PVE(3705),

    /**
     * This is the 3.8 "[Secret Summer Paradise](https://genshin-impact.fandom.com/wiki/Secret_Summer_Paradise)" event
     * TODO document used models
     */
    NEW_ACTIVITY_PENUMBRA_ADVENTURE(3800),

    /**
     * This is the 3.8 "[Perilous Expedition](https://genshin-impact.fandom.com/wiki/Perilous_Expedition)" event
     * TODO document used models
     */
    NEW_ACTIVITY_MULTI_CHARACTER_FIGHT(3801),

    /**
     * This is the 3.8 "[Shared Sight](https://genshin-impact.fandom.com/wiki/Shared_Sight)" event
     * This is the 5.2 "[Claw Convoy](https://genshin-impact.fandom.com/wiki/Claw_Convoy)" event
     * TODO document used models
     */
    NEW_ACTIVITY_ANIMAL_VIEW(3802),

    /**
     * TODO identify this activity
     * TODO document used models
     */
    NEW_ACTIVITY_GCG_PVE_INFINITE(3803),

    /**
     * This is the 4.0 "[Studies in Light and Shadow: A Fontaine of Enchantment](https://genshin-impact.fandom.com/wiki/Studies_in_Light_and_Shadow:_A_Fontaine_of_Enchantment)" event
     * TODO document used models
     */
    NEW_ACTIVITY_PHOTO_UNDERSEA(4000),

    /**
     * This is the 4.0 "[Mega Meka Melee](https://genshin-impact.fandom.com/wiki/Mega_Meka_Melee)" event
     * TODO document used models
     */
    NEW_ACTIVITY_TOY_BATTLE(4001),

    /**
     * This is the 4.0 "[Relic Records: Creations of the Hydro Nation](https://genshin-impact.fandom.com/wiki/Relic_Records:_Creations_of_the_Hydro_Nation)" event
     * TODO document used models
     */
    NEW_ACTIVITY_FONTAINE_GATHER(4002),

    /**
     * TODO identify this activity
     * TODO document used models
     */
    NEW_ACTIVITY_GCG_PVE_PUZZLE(4003),

    /**
     * This is the 4.1 "[Radiant Harvest](https://genshin-impact.fandom.com/wiki/Radiant_Harvest): event
     * TODO document used models
     */
    NEW_ACTIVITY_COLLECT_UNDERWATER(4100),

    /**
     * This is the 4.1 "[The Peaks and Troughs of Life](https://genshin-impact.fandom.com/wiki/The_Peaks_and_Troughs_of_Life)" event
     * TODO document used models
     */
    NEW_ACTIVITY_QUICK_TIME_COMBAT(4101),

    /**
     * This is the 4.1 "[Waterborne Poetry](https://genshin-impact.fandom.com/wiki/Waterborne_Poetry)" event
     * TODO document used models
     */
    NEW_ACTIVITY_POETRY_FESTIVAL(4102),

    /**
     * TODO identify this activity
     * TODO document used models
     */
    NEW_ACTIVITY_FISHBLASTER(4103),

    /**
     * This is the 4.2 "[Thelxie's Fantastic Adventures](https://genshin-impact.fandom.com/wiki/Thelxie%27s_Fantastic_Adventures)" event
     * TODO document used models
     */
    NEW_ACTIVITY_RAINBOW_PRINCE(4200),

    /**
     * This is the 4.2 "[Graph Adversarial Technology Experiment Log](https://genshin-impact.fandom.com/wiki/Graph_Adversarial_Technology_Experiment_Log)" event
     * TODO document used models
     */
    NEW_ACTIVITY_BLESSING_V2(4201),

    /**
     * This is the 4.2 "[Lil' Fungi's Fun-Tastic Fiesta](https://genshin-impact.fandom.com/wiki/Lil%27_Fungi%27s_Fun-Tastic_Fiesta)" event
     * TODO document used models
     */
    NEW_ACTIVITY_FUNGUS_FIGHTER_V3(4202),

    /**
     * This is the 4.3 "[Roses and Muskets](https://genshin-impact.fandom.com/wiki/Roses_and_Muskets) event
     * TODO document used models
     */
    NEW_ACTIVITY_FILMFEST(4300),

    /**
     * This is the 4.3 "[Dance of Resolute Will](https://genshin-impact.fandom.com/wiki/Dance_of_Resolute_Will)" event
     * TODO document used models
     */
    NEW_ACTIVITY_GOAL_CHALLENGE(4301),

    /**
     * TODO identify this activity
     * TODO document used models
     */
    NEW_ACTIVITY_TREASURE_HUNT_V4(4302),

    /**
     * This is the 4.3 "[Gazing Up at Eternity, Looking Down at the World](https://genshin-impact.fandom.com/wiki/Gazing_Up_at_Eternity,_Looking_Down_at_the_World)" event
     * TODO document used models
     */
    NEW_ACTIVITY_FURNITURE_BROADCAST(4303),

    /**
     * This is the 4.4 "[Triumphant Frenzy](https://genshin-impact.fandom.com/wiki/Triumphant_Frenzy)" event
     * TODO document used models
     */
    NEW_ACTIVITY_STAMINA_FIGHT(4401),

    /**
     * TODO identify this activity
     * TODO document used models
     */
    NEW_ACTIVITY_LANTERN_RITE_V4(4402),

    /**
     * This is the 4.4 "[Journey Through Hilinigmatic Terrain](https://genshin-impact.fandom.com/wiki/Journey_Through_Hilinigmatic_Terrain)" event
     * TODO document used models
     */
    NEW_ACTIVITY_LOST_SAMACHURL(4403),

    /**
     * This is the 4.4 "[Receiver of Friends From Afar](https://genshin-impact.fandom.com/wiki/Receiver_of_Friends_From_Afar)" event
     * TODO document used models
     */
    NEW_ACTIVITY_COOK_GAME(4404),

    /**
     * This is the 4.5 "[Feline Fortress Furrdyssey](https://genshin-impact.fandom.com/wiki/Feline_Fortress_Furrdyssey)" event
     * TODO document used models
     */
    NEW_ACTIVITY_CATCAFE(4501),

    /**
     * This is the 4.5 "[Alchemical Ascension](https://genshin-impact.fandom.com/wiki/Alchemical_Ascension)" event
     * TODO document used models
     */
    NEW_ACTIVITY_ALCHEMY_SIM(4502),

    /**
     * This is the 4.5 "[The Great Fayz Reaction Debate](https://genshin-impact.fandom.com/wiki/Fayz_Trials/2024-03-22)" event
     * For other Fayz Trials, see NEW_ACTIVITY_MUQADAS_POTION
     * TODO document used models
     */
    NEW_ACTIVITY_AUTO_TIME_STOP(4503),

    /**
     * This is the 4.5 "[Rolling Crossfire](https://genshin-impact.fandom.com/wiki/Rolling_Crossfire)" event
     * TODO document used models
     */
    NEW_ACTIVITY_SLIME_CANNON(4504),

    /**
     * This is the 4.6 "[Specially-Shaped Saurian Search](https://genshin-impact.fandom.com/wiki/Specially-Shaped_Saurian_Search)" event
     * This is the 5.3 "[On the Trail of Behemoths](https://genshin-impact.fandom.com/wiki/On_the_Trail_of_Behemoths)" event
     * TODO document used models
     */
    NEW_ACTIVITY_EFFIGY_CHALLENGE_V5(4601),

    /**
     * TODO identify this activity
     * TODO document used models
     */
    NEW_ACTIVITY_GREAT_FESTIVAL_V2(4602),

    /**
     * This is the 4.6 "[Windtrace: Seekers and Strategy](https://genshin-impact.fandom.com/wiki/Windtrace/2024-05-14)" event
     * TODO document used models
     */
    NEW_ACTIVITY_HIDE_AND_SEEK_V4(4603),

    /**
     * This is the 4.7 "[Spino Doubleblaster](https://genshin-impact.fandom.com/wiki/Spino_Doubleblaster)" event
     * TODO document used models
     */
    NEW_ACTIVITY_WATERGUN(4701),

    /**
     * This is the 4.7 "[Endless Forms Most Martial](https://genshin-impact.fandom.com/wiki/Endless_Forms_Most_Martial)" event
     * TODO document used models
     */
    NEW_ACTIVITY_ACROBATICS_BATTLE(4702),

    /**
     * This is the 4.7 "[Mutual Security Enhancing Simulation](https://genshin-impact.fandom.com/wiki/Mutual_Security_Enhancing_Simulation)" event
     * TODO document used models
     */
    NEW_ACTIVITY_MONSTER_VS_MONSTER(4703),

    /**
     * TODO identify this activity, it doesn't have an entry in NewActivityExcelConfigData
     * TODO document used models
     */
    NEW_ACTIVITY_ROLE_COMBAT_RESET(4704),

    /**
     * This is the 4.7 "[Record of Reflective Writing](https://genshin-impact.fandom.com/wiki/Record_of_Reflective_Writing)" event
     * TODO document used models
     */
    NEW_ACTIVITY_BULLET_HELL(4705),

    /**
     * This is the 4.8 "[Bing-Bang Finchball 2024-08-06](https://genshin-impact.fandom.com/wiki/Bing-Bang_Finchball/2024-08-06)" event
     * TODO document used models
     */
    NEW_ACTIVITY_BIRD_BALL(4801),

    /**
     * TODO identify this activity
     * TODO document used models
     */
    NEW_ACTIVITY_FAIRY_TALES(4802),

    /**
     * This is the 4.8 "[Energy Amplifier: Lemma](https://genshin-impact.fandom.com/wiki/Energy_Amplifier/2024-08-12)" event
     * For previous Energy Amplifier events, see NEW_ACTIVITY_CHANNELER_SLAB
     * TODO document used models
     */
    NEW_ACTIVITY_RECHARGE_DISK(4803),

    /**
     * This is the 4.8 "[Envisaged Echoes](https://genshin-impact.fandom.com/wiki/Envisaged_Echo?file=Envisaged_Echoes_Event_Menu.png)" announcement
     * TODO document used models
     */
    NEW_ACTIVITY_CHAR_MASTER_BROADCAST(4804),

    /**
     * This is the 5.0 "[Dodoco's Boom-Bastic Escapades](https://genshin-impact.fandom.com/wiki/Dodoco%27s_Boom-Bastic_Escapades)" event
     * TODO document used models
     */
    NEW_ACTIVITY_BOMBER_DODOCO(5001),

    /**
     * This is the 5.0 "[Of Thorns and Crowns](https://genshin-impact.fandom.com/wiki/Of_Thorns_and_Crowns)" event
     * TODO document used models
     */
    NEW_ACTIVITY_GAIN_BUFF(5002),

    /**
     * This is the 5.0 "[Flowers Resplendent on the Sun-Scorched Sojourn](https://genshin-impact.fandom.com/wiki/Flowers_Resplendent_on_the_Sun-Scorched_Sojourn_(Event))" event
     * This is the 5.1 "[The Rainbow Destined to Burn](https://genshin-impact.fandom.com/wiki/The_Rainbow_Destined_to_Burn_(Event))" event
     * This is the 5.3 "[Incandescent Ode of Resurrection](https://genshin-impact.fandom.com/wiki/Incandescent_Ode_of_Resurrection_(Event))" event
     * TODO document used models
     */
    NEW_ACTIVITY_MAIN_LINE_BANNER(5003),

    /**
     * This is the 5.3(?!) "[All Fires Fuel the Flame](https://genshin-impact.fandom.com/wiki/All_Fires_Fuel_the_Flame)(?)" announcement
     * TODO document used models
     */
    NEW_ACTIVITY_QUICK_LAUNCH_BANNER(5004),

    /**
     * This is the 5.0 "[Traces of Artistry](https://genshin-impact.fandom.com/wiki/Traces_of_Artistry)" event
     * TODO document used models
     */
    NEW_ACTIVITY_NATLAN_TOUR(5005),

    /**
     * This is the 5.0 "[Turbo Twirly!](https://genshin-impact.fandom.com/wiki/Turbo_Twirly!)" event
     * TODO document used models
     */
    NEW_ACTIVITY_BONUS_AVATAR_BANNER(5006),

    /**
     * This is the 5.0 "[Yupanqui's Turnfire](https://genshin-impact.fandom.com/wiki/Yupanqui%27s_Turnfire_(Event))" event
     * This is the 5.0 "[Where the Springs Return](https://genshin-impact.fandom.com/wiki/Where_the_Springs_Return_(Event))" event
     * This is the 5.1 "[A Prayer for Blessings, Told to Crested Peaks](https://genshin-impact.fandom.com/wiki/A_Prayer_for_Blessings,_Told_to_Crested_Peaks_(Event))" event
     * This is the 5.2 "[Of Fading Flowers and Falling Feathers](https://genshin-impact.fandom.com/wiki/Of_Fading_Flowers_and_Falling_Feathers_(Event))" event
     * This is the 5.3 "[Memories Flowing With Color](https://genshin-impact.fandom.com/wiki/Memories_Flowing_With_Color_(Event))" event
     * TODO document used models
     */
    NEW_ACTIVITY_TRIBAL_PERSONAL_LINE_BANNER(5007),

    /**
     * This is the 5.0 "[A Quest to Kindle Ancient Flames](https://genshin-impact.fandom.com/wiki/A_Quest_to_Kindle_Ancient_Flames)" event
     * TODO document used models
     */
    NEW_ACTIVITY_PERMANENT_BANNER(5008),

    /**
     * This is the 5.1 "[Reminiscent Regimen: Thrill](https://genshin-impact.fandom.com/wiki/Reminiscent_Regimen/2024-10-17)" event
     * TODO document used models
     */
    NEW_ACTIVITY_COOPERATE_CHALLENGE(5101),

    /**
     * This is the 5.1 "[Feast of Pursuit](https://genshin-impact.fandom.com/wiki/Feast_of_Pursuit)" event
     * TODO document used models
     */
    NEW_ACTIVITY_ARENA_CHALLENGE_V5(5102),

    /**
     * This is the 5.1 "[Chromatic Ode of Candies and Roses](https://genshin-impact.fandom.com/wiki/Chromatic_Ode_of_Candies_and_Roses)" event
     * TODO document used models
     */
    NEW_ACTIVITY_NAHIDA_BIRTH(5103),

    /**
     * This is the 5.1 "[Aphid Treasure Trace](https://genshin-impact.fandom.com/wiki/Aphid_Treasure_Trace)" event
     * TODO document used models
     */
    NEW_ACTIVITY_BOLTBUG_ABYSS(5104),

    /**
     * This is the 5.2(!?) "[https://genshin-impact.fandom.com/wiki/Facing_the_Windborne_Cliff_and_City_of_Flowing_Ash_(Event))" event
     * This is likely the 5.1 [Land of Vibrant Stone and Flaming Springs](https://genshin-impact.fandom.com/wiki/Land_of_Vibrant_Stone_and_Flaming_Springs_(Event))" event as well
     * TODO document used models
     */
    NEW_ACTIVITY_LIMITED_TIME_REWARD_AREA_BANNER(5105),

    /**
     * This is the 5.2 "[Heated Battle Mode: Automatic Artistry](https://genshin-impact.fandom.com/wiki/Heated_Battle_Mode/2024-11-22)" event
     * TODO document used models
     */
    NEW_ACTIVITY_GCG_AUTO_BATTLE_CARD(5201),

    /**
     * This is the 5.2 "[Exercise Surging Storm](https://genshin-impact.fandom.com/wiki/Exercise_Surging_Storm)" event
     * TODO document used models
     */
    NEW_ACTIVITY_MONSTER_CHESS(5202),

    /**
     * This is the 5.2 "[Iktomi Spiritseeking Scrolls](https://genshin-impact.fandom.com/wiki/Iktomi_Spiritseeking_Scrolls)" event
     * TODO document used models
     */
    NEW_ACTIVITY_CEREMONY(5203),

    /**
     * TODO identify this activity
     * TODO document used models
     */
    NEW_ACTIVITY_LANTERN_RITE_V5(5204),

    /**
     * This is the 5.3 "[Shuyu's Baffling Beetle Battle Bowl](https://genshin-impact.fandom.com/wiki/Shuyu%27s_Baffling_Beetle_Battle_Bowl)" event
     * TODO document used models
     */
    NEW_ACTIVITY_ELECTROHERCULES_BATTLE_V3(5301),

    /**
     * This is the 5.3 "[Emblem of Steadfast Valor](https://genshin-impact.fandom.com/wiki/Emblem_of_Steadfast_Valor)" event
     * TODO document used models
     */
    NEW_ACTIVITY_NATLAN_RACE(5302),

    /**
     * This is the 5.3 "[Repertoire of Myriad Melodies](https://genshin-impact.fandom.com/wiki/Repertoire_of_Myriad_Melodies)" announcement
     * TODO document used models
     */
    NEW_ACTIVITY_MUSIC_GAME_BOOK_BANNER(5303),

    /**
     * TODO identify 5.4 event
     */
    NEW_ACTIVITY_MIKAWA_FLOWER(5401),

    /**
     * TODO identify 5.4 event
     */
    NEW_ACTIVITY_AD_SHOOTING(5402),

    /**
     * TODO identify 5.4 event
     */
    NEW_ACTIVITY_FISHING_JOY(5403),

    /**
     * TODO identify 5.4 event
     */
    NEW_ACTIVITY_TOWER_CHALLENGE(5404),

    /**
     * TODO identify 5.4 event
     */
    NEW_ACTIVITY_ANECDOTE(5405),

    /**
     * TODO identify 5.5 event
     */
    NEW_ACTIVITY_NATLAN_DRILL(5501),

    /**
     * TODO identify 5.5 event
     */
    NEW_ACTIVITY_PARTY(5502),

    /**
     * TODO identify 5.5 event
     */
    NEW_ACTIVITY_NATLAN_ARENA(5503),

    /**
     * TODO identify 5.6 event
     */
    NEW_ACTIVITY_DIVERSITY_BATTLE(5601),

    /**
     * TODO identify 5.6 event
     */
    NEW_ACTIVITY_THEME_PARK_SIM(5602),

    /**
     * TODO identify 5.6 event
     */
    NEW_ACTIVITY_SAURUS_1V3(5603),

    /**
     * TODO identify 5.6 event
     */
    NEW_ACTIVITY_MVM2(5604),

    /**
     * TODO identify 5.7 event
     */
    NEW_ACTIVITY_LEY_LINE_CHALLENGE(5701),

    /**
     * TODO identify 5.7 event
     */
    NEW_ACTIVITY_AUTO_CHESS(5702),

    /**
     * TODO identify 5.8 event
     */
    NEW_ACTIVITY_HOLIDAY_RESORT(5801),

    /**
     * TODO identify 5.8 event
     */
    NEW_ACTIVITY_AGENTRECON(5802),

    /**
     * TODO identify 5.8 event
     */
    NEW_ACTIVITY_MUSIC_GAME_BOOK_LIMITED_TIME_BANNER(5803),

    /**
     * TODO identify 6.0 event
     */
    NEW_ACTIVITY_BOMBER_V3(6001),

    /**
     * TODO identify 6.0 event
     */
    NEW_ACTIVITY_NODKRAI_TOUR(6002),

    /**
     * TODO identify 6.0 event
     */
    NEW_ACTIVITY_WEEK_ACTIVE(6003),

    /**
     * This is a placeholder used when the actual activity string can not be identified. Check [ActivityData.activityTypeString] in this case.
     */
    NEW_ACTIVITY_UNKNOWN(999999);

    override fun getIntKey() = id
}
