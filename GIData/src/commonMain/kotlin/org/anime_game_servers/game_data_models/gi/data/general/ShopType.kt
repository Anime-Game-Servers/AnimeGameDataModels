package org.anime_game_servers.game_data_models.gi.data.general

import org.anime_game_servers.core.base.annotations.AddedIn
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.activity.ActivityShopOverallData
import org.anime_game_servers.game_data_models.gi.data.activity.ActivityType

/**
 * These are the known shop types used in different shop definitions, including [ActivityShopOverallData], [ShopData] and more
 * TODO Identify all shops
 */
enum class ShopType(val id: Int) : IntKey {
    SHOP_TYPE_NONE(0),
    SHOP_TYPE_RECOMMEND(900),
    SHOP_TYPE_HCOIN(901),
    SHOP_TYPE_PACKAGE(902),
    SHOP_TYPE_MCOIN(903),
    SHOP_TYPE_PAIMON(1001),
    SHOP_TYPE_CITY(1002),
    SHOP_TYPE_BLACKSMITH(1003),
    SHOP_TYPE_GROCERY(1004),
    SHOP_TYPE_FOOD(1005),

    /**
     * Shop from the [ActivityType.NEW_ACTIVITY_SEA_LAMP]/Lantern Rite (CB2) event
     */
    SHOP_TYPE_SEA_LAMP(1006),
    SHOP_TYPE_VIRTUAL_SHOP(1007),
    SHOP_TYPE_LIYUE_GROCERY(1008),
    SHOP_TYPE_LIYUE_SOUVENIR(1009),
    SHOP_TYPE_LIYUE_RESTAURANT(1010),
    SHOP_TYPE_NPC_Flora(1011),
    SHOP_TYPE_NPC_Charles(1012),
    SHOP_TYPE_NPC_Shiliu(1013),
    SHOP_TYPE_NPC_Schulz(1014),
    SHOP_TYPE_NPC_Brook(1015),
    SHOP_TYPE_NPC_Hopkins(1016),
    SHOP_TYPE_NPC_Draff(1017),
    SHOP_TYPE_NPC_Chloris(1018),
    SHOP_TYPE_NPC_Licai(1019),
    SHOP_TYPE_NPC_Yueshu(1020),
    SHOP_TYPE_NPC_Gui(1021),
    SHOP_TYPE_NPC_Gao(1022),
    SHOP_TYPE_NPC_Sun(1023),
    SHOP_TYPE_NPC_Qiming(1024),
    SHOP_TYPE_NPC_Zhangshun(1025),
    SHOP_TYPE_NPC_Chen(1026),
    SHOP_TYPE_NPC_ErNiang(1027),
    SHOP_TYPE_NPC_Shitou(1028),
    SHOP_TYPE_NPC_Jifang(1029),
    SHOP_TYPE_NPC_Zhu(1030),
    SHOP_TYPE_NPC_Bai(1031),
    SHOP_TYPE_NPC_Kai(1032),
    SHOP_TYPE_NPC_Linglang(1033),
    SHOP_TYPE_NPC_VerrGoldet(1034),
    SHOP_TYPE_NPC_Zhou(1035),
    SHOP_TYPE_TASK_Ekaterina(1036),

    /**
     * Shop from the [ActivityType.NEW_ACTIVITY_ASTER]/Unreconciled Stars (v1.1) event
     */
    SHOP_TYPE_ACTIVITY_ASTER(1037),
    SHOP_TYPE_TASK_Tartaglia(1038),
    SHOP_TYPE_NPC_Harris(1039),

    /**
     * Shop from the [ActivityType.NEW_ACTIVITY_DRAGONSPINE]/The Chalk Prince and the Dragon (v1.2) event
     */
    SHOP_TYPE_ACTIVITY_DRAGON_SPINE(1040),
    SHOP_TYPE_ACTIVITY_TREASURE_MAP(1041),
    SHOP_TYPE_NPC_Yinian(1042),

    /**
     * Shop from the [ActivityType.NEW_ACTIVITY_SEA_LAMP_NEW]/Lantern Rite (v1.3) event
     */
    SHOP_TYPE_ACTIVITY_SEA_LAMP(1043),

    /**
     * Shop from the [ActivityType.NEW_ACTIVITY_FLEUR_FAIR]/Windblume Festival (v1.4) event
     */
    SHOP_TYPE_ACTIVITY_FLEUR_FAIR(1044),
    SHOP_TYPE_NPC_Changshun(1045),
    SHOP_TYPE_NPC_Bolai(1046),
    SHOP_TYPE_NPC_Ashanpo(1047),
    SHOP_TYPE_HOME(1048),
    SHOP_TYPE_HOME_LIMIT(1049),
    SHOP_TYPE_NPC_MasterLu(1050),
    SHOP_TYPE_NPC_Goth(1051),
    SHOP_TYPE_COSTUME(1052),
    SHOP_TYPE_NPC_Obata(1053),
    SHOP_TYPE_NPC_Qiuyue(1054),
    SHOP_TYPE_NPC_Ryouko(1055),
    SHOP_TYPE_INAZUMA_GROCERY(1056),
    SHOP_TYPE_INAZUMA_SOUVENIR(1057),
    SHOP_TYPE_INAZUMA_RESTAURANT(1058),
    SHOP_TYPE_NPC_Kuroda(1059),
    SHOP_TYPE_NPC_KiminamiAnna(1060),
    SHOP_TYPE_NPC_Tomoki(1061),
    SHOP_TYPE_NPC_Karpillia(1062),
    SHOP_TYPE_BLACKSMITH_INAZUMA(1063),
    SHOP_TYPE_FISH(1064),
    SHOP_TYPE_FISH_LIYUE(1065),
    SHOP_TYPE_FISH_INAZUMA(1066),
    SHOP_TYPE_NPC_Kiyoko(1067),
    SHOP_TYPE_EXPIRED_WIDGET_MENGDE(1068),
    SHOP_TYPE_CAPTURE_ANIMAL_SHOP(1069),
    SHOP_TYPE_NPC_YamashiroKenta(1070),
    SHOP_TYPE_FISH_SUMERU(1071),
    SHOP_TYPE_NPC_Pam(1072),
    SHOP_TYPE_NPC_Lambad(1073),
    SHOP_TYPE_NPC_Hamawi(1074),
    SHOP_TYPE_NPC_Khalid(1075),
    SHOP_TYPE_NPC_Ahangar(1076),
    SHOP_TYPE_NPC_Afshin(1077),
    SHOP_TYPE_NPC_Jut(1078),
    SHOP_TYPE_NPC_Butrus(1079),
    SHOP_TYPE_NPC_Jahangir(1080),
    SHOP_TYPE_NPC_Qiuwei(1081),
    SHOP_TYPE_NPC_Babak(1082),
    SHOP_TYPE_NPC_Rama(1083),
    SHOP_TYPE_NPC_Ashpazi(1084),
    SHOP_TYPE_NPC_Aramani(1085),
    SHOP_TYPE_NPC_Aravinay(1086),
    SHOP_TYPE_NPC_Enteka(1087),
    SHOP_TYPE_NPC_Azalai(1088),
    SHOP_TYPE_EXPIRED_WIDGET_INAZUMA(1089),
    SHOP_TYPE_FISH_FONTAINE(1090),
    SHOP_TYPE_NPC_Establet(1091),
    SHOP_TYPE_NPC_Mequignon(1092),
    SHOP_TYPE_NPC_Boucicaut(1093),
    SHOP_TYPE_NPC_Sanguinetti(1094),
    SHOP_TYPE_NPC_Hubel(1095),
    SHOP_TYPE_NPC_Eugene(1096),
    SHOP_TYPE_NPC_Louis(1097),
    SHOP_TYPE_NPC_Crassa(1098),
    SHOP_TYPE_NPC_Xana(1099),
    SHOP_TYPE_NPC_Arouet(1100),
    SHOP_TYPE_NPC_Hinterman(1101),
    SHOP_TYPE_NPC_Alvard_01(1102),
    SHOP_TYPE_NPC_Alvard_02(1103),
    SHOP_TYPE_NPC_Wolsey(1104),
    SHOP_TYPE_NPC_Pitot(1105),
    SHOP_TYPE_NPC_Fonta_make_meka(1106),
    SHOP_TYPE_NPC_Pahsiv_01(1107),
    SHOP_TYPE_NPC_Pahsiv_02(1108),
    SHOP_TYPE_NPC_Lianfang(1109),
    SHOP_TYPE_NPC_Fengtai(1110),
    SHOP_TYPE_NPC_Zhenyuan(1111),
    SHOP_TYPE_NPC_Siyah(1112),
    SHOP_TYPE_NPC_Chanca(1113),
    SHOP_TYPE_NPC_Alom(1114),
    SHOP_TYPE_NPC_Echuah(1115),
    SHOP_TYPE_NPC_Cipac(1116),
    SHOP_TYPE_NPC_Bounama(1117),
    SHOP_TYPE_NPC_Cintli(1118),
    SHOP_TYPE_NPC_Imix(1119),
    SHOP_TYPE_NPC_Amazolli(1120),
    SHOP_TYPE_NPC_Oroluk(1121),
    SHOP_TYPE_FISH_NATLAN(1122),
    SHOP_TYPE_NPC_Anchieta(1123),
    SHOP_TYPE_EXPIRED_WIDGET_FONTAIN(1124),
    HOP_TYPE_NPC_Macuahuitl(1125),
    SHOP_TYPE_NPC_Teuciztli(1126),
    SHOP_TYPE_NPC_Fournier(1127),
    SHOP_TYPE_NPC_Motolinia(1128),
    SHOP_TYPE_FISH_NODKRAI(1129),
    SHOP_TYPE_NPC_Katya(1130),
    SHOP_TYPE_NPC_Lyulka(1131),
    SHOP_TYPE_NPC_Reko(1132),
    SHOP_TYPE_NPC_Limppu(1133),
    SHOP_TYPE_NPC_CaiRuo(1134),
    SHOP_TYPE_NPC_Thabit(1135),
    SHOP_TYPE_NPC_Richeza(1136),
    SHOP_TYPE_NPC_Hedvika(1137),
    SHOP_TYPE_NPC_Demyan(1138),
    SHOP_TYPE_NPC_Tarno(1139),
    SHOP_TYPE_NPC_Punchkickduck(1140),
    SHOP_TYPE_NPC_Nataba(1141),
    @AddedIn(GI_6_3_0)
    SHOP_TYPE_NPC_Kofitse (1142),
    @AddedIn(GI_6_3_0)
    SHOP_TYPE_NPC_Kuzmich01 (1143),
    @AddedIn(GI_6_3_0)
    SHOP_TYPE_NPC_Kuzmich02 (1144),
    @AddedIn(GI_6_3_0)
    SHOP_TYPE_NPC_Kuzmich03 (1145),

    SHOP_TYPE_GCG_CARD(2000),
    SHOP_TYPE_GCG_CARD_FACE(2001),
    SHOP_TYPE_GCG_APPEARANCE(2002),
    SHOP_TYPE_GCG_EXCHANGE(2003),

    SHOP_TYPE_NPC_WOLF_POSE(2100),
    SHOP_TYPE_NPC_WOLF_BOOK(2101),

    SHOP_TYPE_MUSIC_GAME_BOOK(2200),

    /**
     * Shop from the [ActivityType.NEW_ACTIVITY_CHANNELER_SLAB]/Energy Amplifier (v1.5) event.
     */
    SHOP_TYPE_ACTIVITY_CHANNELLER_SLAB(15001),

    /**
     * Shop from the [ActivityType.NEW_ACTIVITY_SUMMER_TIME]/Midsummer Island Adventure (v1.6) event.
     */
    SHOP_TYPE_ACTIVITY_SUMMER_TIME(16001),
    SHOP_TYPE_ACTIVITY_BOUNCE_CONJURING(16002),
    SHOP_TYPE_ACTIVITY_BLITZ_RUSH(20001),
    SHOP_TYPE_ACTIVITY_CHESS(20002),
    SHOP_TYPE_ACTIVITY_ROGUELIKE_DUNGEON(20003),

    /**
     * Shop from the [ActivityType.NEW_ACTIVITY_WINTER_CAMP]/Shadows Amidst Snowstorms (v2.3) event
     */
    SHOP_TYPE_ACTIVITY_WINTER_CAMP(20004),

    /**
     * Shop from the [ActivityType.NEW_ACTIVITY_SEA_LAMP_2_4]/Fleeting Colors in Flight (v2.4) event
     */
    SHOP_TYPE_ACTIVITY_LANTERN_RITE(20005),
    SHOP_TYPE_ACTIVITY_ROGUE_DIARY(27001),

    /**
     * Shop from the [ActivityType.NEW_ACTIVITY_SUMMER_TIME_2_8]/Summertime Odyssey (v2.8) event.
     */
    SHOP_TYPE_ACTIVITY_SUMMER_TIME_V2(28001),
    SHOP_TYPE_ACTIVITY_GRAVEN_INNOCENCE(30001),
    SHOP_TYPE_ACTIVITY_TREASURE_SEELIE(30002),
    SHOP_TYPE_ACTIVITY_VINTAGE_ANGEL_S_SHARE(31001),
    SHOP_TYPE_ACTIVITY_FUNGUS_FIGHTER(32001),
    SHOP_TYPE_ACTIVITY_EFFIGY_V2(32002),
    SHOP_TYPE_ACTIVITY_BRICK_BREAKER(33001),
    SHOP_TYPE_ACTIVITY_FLEURFAIR_V2(35001),
    SHOP_TYPE_ACTIVITY_JOURNEY(37001),
    SHOP_TYPE_ACTIVITY_TOY_BATTLE (40001),
    SHOP_TYPE_ACTIVITY_TREASURE_HUNT_V4 (43001),
    SHOP_TYPE_ACTIVITY_FILMFEST (43002),
    SHOP_TYPE_ACTIVITY_ALCHEMY_SIM (45001),
    SHOP_TYPE_ACTIVITY_GREAT_FESTIVAL_V2_NPC (46001),
    @AddedIn(GI_6_3_0)
    SHOP_TYPE_ACTIVITY_LANTERN_RITE_V6 (63001),

    @AddedIn(GI_6_1_0)
    SHOP_TYPE_BEYOND_MCOIN(100000),
    @AddedIn(GI_6_1_0)
    SHOP_TYPE_BEYOND_COSTUME(101000),
    @AddedIn(GI_6_1_0)
    SHOP_TYPE_BEYOND_FACE_PART(102000),
    @AddedIn(GI_6_1_0)
    SHOP_TYPE_BEYOND_EXCHANGE(103000),
    @AddedIn(GI_6_3_0)
    SHOP_TYPE_BEYOND_RECOMMEND(104000),
    SHOP_TYPE_UNKNOWN(99999);

    override fun getIntKey() = id
}