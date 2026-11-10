package org.anime_game_servers.game_data_models.gi.data.general

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.anime_game_servers.core.base.annotations.AddedIn
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.gi.data.activity.ActivityShopOverallData
import org.anime_game_servers.game_data_models.gi.data.activity.ActivityType
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.NoneEntry
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

/**
 * These are the known shop types used in different shop definitions, including [ActivityShopOverallData], [ShopData] and more
 * TODO Identify all shops
 */
@DataEnum
@Serializable
enum class ShopType(val id: Int) : IntKey {
    @NoneEntry
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
    @SerialName("SHOP_TYPE_NPC_Flora")
    SHOP_TYPE_NPC_FLORA(1011),
    @SerialName("SHOP_TYPE_NPC_Charles")
    SHOP_TYPE_NPC_CHARLES(1012),
    @SerialName("SHOP_TYPE_NPC_Shiliu")
    SHOP_TYPE_NPC_SHILIU(1013),
    @SerialName("SHOP_TYPE_NPC_Schulz")
    SHOP_TYPE_NPC_SCHULZ(1014),
    @SerialName("SHOP_TYPE_NPC_Brook")
    SHOP_TYPE_NPC_BROOK(1015),
    @SerialName("SHOP_TYPE_NPC_Hopkins")
    SHOP_TYPE_NPC_HOPKINS(1016),
    @SerialName("SHOP_TYPE_NPC_Draff")
    SHOP_TYPE_NPC_DRAFF(1017),
    @SerialName("SHOP_TYPE_NPC_Chloris")
    SHOP_TYPE_NPC_CHLORIS(1018),
    @SerialName("SHOP_TYPE_NPC_Licai")
    SHOP_TYPE_NPC_LICAI(1019),
    @SerialName("SHOP_TYPE_NPC_Yueshu")
    SHOP_TYPE_NPC_YUESHU(1020),
    @SerialName("SHOP_TYPE_NPC_Gui")
    SHOP_TYPE_NPC_GUI(1021),
    @SerialName("SHOP_TYPE_NPC_Gao")
    SHOP_TYPE_NPC_GAO(1022),
    @SerialName("SHOP_TYPE_NPC_Sun")
    SHOP_TYPE_NPC_SUN(1023),
    @SerialName("SHOP_TYPE_NPC_Qiming")
    SHOP_TYPE_NPC_QIMING(1024),
    @SerialName("SHOP_TYPE_NPC_Zhangshun")
    SHOP_TYPE_NPC_ZHANGSHUN(1025),
    @SerialName("SHOP_TYPE_NPC_Chen")
    SHOP_TYPE_NPC_CHEN(1026),
    @SerialName("SHOP_TYPE_NPC_ErNiang")
    SHOP_TYPE_NPC_ER_NIANG(1027),
    @SerialName("SHOP_TYPE_NPC_Shitou")
    SHOP_TYPE_NPC_SHITOU(1028),
    @SerialName("SHOP_TYPE_NPC_Jifang")
    SHOP_TYPE_NPC_JIFANG(1029),
    @SerialName("SHOP_TYPE_NPC_Zhu")
    SHOP_TYPE_NPC_ZHU(1030),
    @SerialName("SHOP_TYPE_NPC_Bai")
    SHOP_TYPE_NPC_BAI(1031),
    @SerialName("SHOP_TYPE_NPC_Kai")
    SHOP_TYPE_NPC_KAI(1032),
    @SerialName("SHOP_TYPE_NPC_Linglang")
    SHOP_TYPE_NPC_LINGLANG(1033),
    @SerialName("SHOP_TYPE_NPC_VerrGoldet")
    SHOP_TYPE_NPC_VERR_GOLDET(1034),
    @SerialName("SHOP_TYPE_NPC_Zhou")
    SHOP_TYPE_NPC_ZHOU(1035),
    @SerialName("SHOP_TYPE_TASK_Ekaterina")
    SHOP_TYPE_TASK_EKATERINA(1036),

    /**
     * Shop from the [ActivityType.NEW_ACTIVITY_ASTER]/Unreconciled Stars (v1.1) event
     */
    SHOP_TYPE_ACTIVITY_ASTER(1037),
    @SerialName("SHOP_TYPE_TASK_Tartaglia")
    SHOP_TYPE_TASK_TARTAGLIA(1038),
    @SerialName("SHOP_TYPE_NPC_Harris")
    SHOP_TYPE_NPC_HARRIS(1039),

    /**
     * Shop from the [ActivityType.NEW_ACTIVITY_DRAGONSPINE]/The Chalk Prince and the Dragon (v1.2) event
     */
    SHOP_TYPE_ACTIVITY_DRAGON_SPINE(1040),
    SHOP_TYPE_ACTIVITY_TREASURE_MAP(1041),
    @SerialName("SHOP_TYPE_NPC_Yinian")
    SHOP_TYPE_NPC_YINIAN(1042),

    /**
     * Shop from the [ActivityType.NEW_ACTIVITY_SEA_LAMP_NEW]/Lantern Rite (v1.3) event
     */
    SHOP_TYPE_ACTIVITY_SEA_LAMP(1043),

    /**
     * Shop from the [ActivityType.NEW_ACTIVITY_FLEUR_FAIR]/Windblume Festival (v1.4) event
     */
    SHOP_TYPE_ACTIVITY_FLEUR_FAIR(1044),
    @SerialName("SHOP_TYPE_NPC_Changshun")
    SHOP_TYPE_NPC_CHANGSHUN(1045),
    @SerialName("SHOP_TYPE_NPC_Bolai")
    SHOP_TYPE_NPC_BOLAI(1046),
    @SerialName("SHOP_TYPE_NPC_Ashanpo")
    SHOP_TYPE_NPC_ASHANPO(1047),
    SHOP_TYPE_HOME(1048),
    SHOP_TYPE_HOME_LIMIT(1049),
    @SerialName("SHOP_TYPE_NPC_MasterLu")
    SHOP_TYPE_NPC_MASTER_LU(1050),
    @SerialName("SHOP_TYPE_NPC_Goth")
    SHOP_TYPE_NPC_GOTH(1051),
    SHOP_TYPE_COSTUME(1052),
    @SerialName("SHOP_TYPE_NPC_Obata")
    SHOP_TYPE_NPC_OBATA(1053),
    @SerialName("SHOP_TYPE_NPC_Qiuyue")
    SHOP_TYPE_NPC_QIUYUE(1054),
    @SerialName("SHOP_TYPE_NPC_Ryouko")
    SHOP_TYPE_NPC_RYOUKO(1055),
    SHOP_TYPE_INAZUMA_GROCERY(1056),
    SHOP_TYPE_INAZUMA_SOUVENIR(1057),
    SHOP_TYPE_INAZUMA_RESTAURANT(1058),
    @SerialName("SHOP_TYPE_NPC_Kuroda")
    SHOP_TYPE_NPC_KURODA(1059),
    @SerialName("SHOP_TYPE_NPC_KiminamiAnna")
    SHOP_TYPE_NPC_KIMINAMI_ANNA(1060),
    @SerialName("SHOP_TYPE_NPC_Tomoki")
    SHOP_TYPE_NPC_TOMOKI(1061),
    @SerialName("SHOP_TYPE_NPC_Karpillia")
    SHOP_TYPE_NPC_KARPILLIA(1062),
    SHOP_TYPE_BLACKSMITH_INAZUMA(1063),
    SHOP_TYPE_FISH(1064),
    SHOP_TYPE_FISH_LIYUE(1065),
    SHOP_TYPE_FISH_INAZUMA(1066),
    @SerialName("SHOP_TYPE_NPC_Kiyoko")
    SHOP_TYPE_NPC_KIYOKO(1067),
    SHOP_TYPE_EXPIRED_WIDGET_MENGDE(1068),
    SHOP_TYPE_CAPTURE_ANIMAL_SHOP(1069),
    @SerialName("SHOP_TYPE_NPC_YamashiroKenta")
    SHOP_TYPE_NPC_YAMASHIRO_KENTA(1070),
    @AddedIn(GI_3_0_0)
    SHOP_TYPE_FISH_SUMERU(1071),
    @AddedIn(GI_3_0_0)
    @SerialName("SHOP_TYPE_NPC_Pam")
    SHOP_TYPE_NPC_PAM(1072),
    @AddedIn(GI_3_0_0)
    @SerialName("SHOP_TYPE_NPC_Lambad")
    SHOP_TYPE_NPC_LAMBAD(1073),
    @AddedIn(GI_3_0_0)
    @SerialName("SHOP_TYPE_NPC_Hamawi")
    SHOP_TYPE_NPC_HAMAWI(1074),
    @AddedIn(GI_3_0_0)
    @SerialName("SHOP_TYPE_NPC_Khalid")
    SHOP_TYPE_NPC_KHALID(1075),
    @AddedIn(GI_3_0_0)
    @SerialName("SHOP_TYPE_NPC_Ahangar")
    SHOP_TYPE_NPC_AHANGAR(1076),
    @AddedIn(GI_3_0_0)
    @SerialName("SHOP_TYPE_NPC_Afshin")
    SHOP_TYPE_NPC_AFSHIN(1077),
    @AddedIn(GI_3_0_0)
    @SerialName("SHOP_TYPE_NPC_Jut")
    SHOP_TYPE_NPC_JUT(1078),
    @AddedIn(GI_3_0_0)
    @SerialName("SHOP_TYPE_NPC_Butrus")
    SHOP_TYPE_NPC_BUTRUS(1079),
    @AddedIn(GI_3_0_0)
    @SerialName("SHOP_TYPE_NPC_Jahangir")
    SHOP_TYPE_NPC_JAHANGIR(1080),
    @AddedIn(GI_3_0_0)
    @SerialName("SHOP_TYPE_NPC_Qiuwei")
    SHOP_TYPE_NPC_QIUWEI(1081),
    @AddedIn(GI_3_0_0)
    @SerialName("SHOP_TYPE_NPC_Babak")
    SHOP_TYPE_NPC_BABAK(1082),
    @AddedIn(GI_3_0_0)
    @SerialName("SHOP_TYPE_NPC_Rama")
    SHOP_TYPE_NPC_RAMA(1083),
    @AddedIn(GI_3_0_0)
    @SerialName("SHOP_TYPE_NPC_Ashpazi")
    SHOP_TYPE_NPC_ASHPAZI(1084),
    @AddedIn(GI_3_0_0)
    @SerialName("SHOP_TYPE_NPC_Aramani")
    SHOP_TYPE_NPC_ARAMANI(1085),
    @AddedIn(GI_3_0_0)
    @SerialName("SHOP_TYPE_NPC_Aravinay")
    SHOP_TYPE_NPC_ARAVINAY(1086),
    @AddedIn(GI_3_1_0)
    @SerialName("SHOP_TYPE_NPC_Enteka")
    SHOP_TYPE_NPC_ENTEKA(1087),
    @AddedIn(GI_3_1_0)
    @SerialName("SHOP_TYPE_NPC_Azalai")
    SHOP_TYPE_NPC_AZALAI(1088),
    SHOP_TYPE_EXPIRED_WIDGET_INAZUMA(1089),
    SHOP_TYPE_FISH_FONTAINE(1090),
    @SerialName("SHOP_TYPE_NPC_Establet")
    SHOP_TYPE_NPC_ESTABLET(1091),
    @SerialName("SHOP_TYPE_NPC_Mequignon")
    SHOP_TYPE_NPC_MEQUIGNON(1092),
    @SerialName("SHOP_TYPE_NPC_Boucicaut")
    SHOP_TYPE_NPC_BOUCICAUT(1093),
    @SerialName("SHOP_TYPE_NPC_Sanguinetti")
    SHOP_TYPE_NPC_SANGUINETTI(1094),
    @SerialName("SHOP_TYPE_NPC_Hubel")
    SHOP_TYPE_NPC_HUBEL(1095),
    @SerialName("SHOP_TYPE_NPC_Eugene")
    SHOP_TYPE_NPC_EUGENE(1096),
    @SerialName("SHOP_TYPE_NPC_Louis")
    SHOP_TYPE_NPC_LOUIS(1097),
    @SerialName("SHOP_TYPE_NPC_Crassa")
    SHOP_TYPE_NPC_CRASSA(1098),
    @SerialName("SHOP_TYPE_NPC_Xana")
    SHOP_TYPE_NPC_XANA(1099),
    @SerialName("SHOP_TYPE_NPC_Arouet")
    SHOP_TYPE_NPC_AROUET(1100),
    @SerialName("SHOP_TYPE_NPC_Hinterman")
    SHOP_TYPE_NPC_HINTERMAN(1101),
    @SerialName("SHOP_TYPE_NPC_Alvard_01")
    SHOP_TYPE_NPC_ALVARD_01(1102),
    @SerialName("SHOP_TYPE_NPC_Alvard_02")
    SHOP_TYPE_NPC_ALVARD_02(1103),
    @SerialName("SHOP_TYPE_NPC_Wolsey")
    SHOP_TYPE_NPC_WOLSEY(1104),
    @SerialName("SHOP_TYPE_NPC_Pitot")
    SHOP_TYPE_NPC_PITOT(1105),
    @SerialName("SHOP_TYPE_NPC_Fonta_make_meka")
    SHOP_TYPE_NPC_FONTA_MAKE_MEKA(1106),
    @SerialName("SHOP_TYPE_NPC_Pahsiv_01")
    SHOP_TYPE_NPC_PAHSIV_01(1107),
    @SerialName("SHOP_TYPE_NPC_Pahsiv_02")
    SHOP_TYPE_NPC_PAHSIV_02(1108),
    @SerialName("SHOP_TYPE_NPC_Lianfang")
    SHOP_TYPE_NPC_LIANFANG(1109),
    @SerialName("SHOP_TYPE_NPC_Fengtai")
    SHOP_TYPE_NPC_FENGTAI(1110),
    @SerialName("SHOP_TYPE_NPC_Zhenyuan")
    SHOP_TYPE_NPC_ZHENYUAN(1111),
    @SerialName("SHOP_TYPE_NPC_Siyah")
    SHOP_TYPE_NPC_SIYAH(1112),
    @SerialName("SHOP_TYPE_NPC_Chanca")
    SHOP_TYPE_NPC_CHANCA(1113),
    @SerialName("SHOP_TYPE_NPC_Alom")
    SHOP_TYPE_NPC_ALOM(1114),
    @SerialName("SHOP_TYPE_NPC_Echuah")
    SHOP_TYPE_NPC_ECHUAH(1115),
    @SerialName("SHOP_TYPE_NPC_Cipac")
    SHOP_TYPE_NPC_CIPAC(1116),
    @SerialName("SHOP_TYPE_NPC_Bounama")
    SHOP_TYPE_NPC_BOUNAMA(1117),
    @SerialName("SHOP_TYPE_NPC_Cintli")
    SHOP_TYPE_NPC_CINTLI(1118),
    @SerialName("SHOP_TYPE_NPC_Imix")
    SHOP_TYPE_NPC_IMIX(1119),
    @SerialName("SHOP_TYPE_NPC_Amazolli")
    SHOP_TYPE_NPC_AMAZOLLI(1120),
    @SerialName("SHOP_TYPE_NPC_Oroluk")
    SHOP_TYPE_NPC_OROLUK(1121),
    SHOP_TYPE_FISH_NATLAN(1122),
    @SerialName("SHOP_TYPE_NPC_Anchieta")
    SHOP_TYPE_NPC_ANCHIETA(1123),
    SHOP_TYPE_EXPIRED_WIDGET_FONTAIN(1124),
    @SerialName("HOP_TYPE_NPC_Macuahuitl")
    HOP_TYPE_NPC_MACUAHUITL(1125),
    @SerialName("SHOP_TYPE_NPC_Teuciztli")
    SHOP_TYPE_NPC_TEUCIZTLI(1126),
    @SerialName("SHOP_TYPE_NPC_Fournier")
    SHOP_TYPE_NPC_FOURNIER(1127),
    @SerialName("SHOP_TYPE_NPC_Motolinia")
    SHOP_TYPE_NPC_MOTOLINIA(1128),
    SHOP_TYPE_FISH_NODKRAI(1129),
    @SerialName("SHOP_TYPE_NPC_Katya")
    SHOP_TYPE_NPC_KATYA(1130),
    @SerialName("SHOP_TYPE_NPC_Lyulka")
    SHOP_TYPE_NPC_LYULKA(1131),
    @SerialName("SHOP_TYPE_NPC_Reko")
    SHOP_TYPE_NPC_REKO(1132),
    @SerialName("SHOP_TYPE_NPC_Limppu")
    SHOP_TYPE_NPC_LIMPPU(1133),
    @SerialName("SHOP_TYPE_NPC_CaiRuo")
    SHOP_TYPE_NPC_CAI_RUO(1134),
    @SerialName("SHOP_TYPE_NPC_Thabit")
    SHOP_TYPE_NPC_THABIT(1135),
    @SerialName("SHOP_TYPE_NPC_Richeza")
    SHOP_TYPE_NPC_RICHEZA(1136),
    @SerialName("SHOP_TYPE_NPC_Hedvika")
    SHOP_TYPE_NPC_HEDVIKA(1137),
    @SerialName("SHOP_TYPE_NPC_Demyan")
    SHOP_TYPE_NPC_DEMYAN(1138),
    @SerialName("SHOP_TYPE_NPC_Tarno")
    SHOP_TYPE_NPC_TARNO(1139),
    @SerialName("SHOP_TYPE_NPC_Punchkickduck")
    SHOP_TYPE_NPC_PUNCHKICKDUCK(1140),
    @SerialName("SHOP_TYPE_NPC_Nataba")
    SHOP_TYPE_NPC_NATABA(1141),
    @AddedIn(GI_6_3_0)
    @SerialName("SHOP_TYPE_NPC_Kofitse")
    SHOP_TYPE_NPC_KOFITSE (1142),
    @AddedIn(GI_6_3_0)
    @SerialName("SHOP_TYPE_NPC_Kuzmich01")
    SHOP_TYPE_NPC_KUZMICH01 (1143),
    @AddedIn(GI_6_3_0)
    @SerialName("SHOP_TYPE_NPC_Kuzmich02")
    SHOP_TYPE_NPC_KUZMICH02 (1144),
    @AddedIn(GI_6_3_0)
    @SerialName("SHOP_TYPE_NPC_Kuzmich03")
    SHOP_TYPE_NPC_KUZMICH03 (1145),
    @AddedIn(GI_6_5_0)
    @SerialName("SHOP_TYPE_NPC_Josephus")
    SHOP_TYPE_NPC_JOSEPHUS(1146),
    @AddedIn(GI_6_5_0)
    @SerialName("SHOP_TYPE_NPC_Frith")
    SHOP_TYPE_NPC_FRITH(1147),
    @AddedIn(GI_6_5_0)
    @SerialName("SHOP_TYPE_NPC_Benthem")
    SHOP_TYPE_NPC_BENTHEM(1148),
    // todo identify version added
    SHOP_TYPE_NPC_SNOW_FAIRY(1149),
    @SerialName("SHOP_TYPE_NPC_Kuzmichev")
    SHOP_TYPE_NPC_KUZMICHEV(1150),
    @SerialName("SHOP_TYPE_NPC_Buturlina")
    SHOP_TYPE_NPC_BUTURLINA(1151),
    @SerialName("SHOP_TYPE_NPC_Zyryanov")
    SHOP_TYPE_NPC_ZYRYANOV(1152),
    @SerialName("SHOP_TYPE_NPC_Grigory")
    SHOP_TYPE_NPC_GRIGORY(1153),
    @SerialName("SHOP_TYPE_NPC_Moes")
    SHOP_TYPE_NPC_MOES(1154),
    @SerialName("SHOP_TYPE_NPC_Blyushko")
    SHOP_TYPE_NPC_BLYUSHKO(1155),
    @SerialName("SHOP_TYPE_NPC_Zherebtsov")
    SHOP_TYPE_NPC_ZHEREBTSOV(1156),
    @SerialName("SHOP_TYPE_NPC_Yaroslav")
    SHOP_TYPE_NPC_YAROSLAV(1157),
    @SerialName("SHOP_TYPE_NPC_Knyazev")
    SHOP_TYPE_NPC_KNYAZEV(1158),
    @SerialName("SHOP_TYPE_NPC_Zheleznov")
    SHOP_TYPE_NPC_ZHELEZNOV(1159),
    @SerialName("SHOP_TYPE_NPC_Tolstaya")
    SHOP_TYPE_NPC_TOLSTAYA(1160),


    @AddedIn(GI_3_2_0)
    SHOP_TYPE_GCG_CARD(2000),
    @AddedIn(GI_3_2_0)
    SHOP_TYPE_GCG_CARD_FACE(2001),
    @AddedIn(GI_3_2_0)
    SHOP_TYPE_GCG_APPEARANCE(2002),
    @AddedIn(GI_3_2_0)
    SHOP_TYPE_GCG_EXCHANGE(2003),


    SHOP_TYPE_NPC_WOLF_POSE(2100),
    SHOP_TYPE_NPC_WOLF_BOOK(2101),

    @AddedIn(GI_5_3_0)

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
    @AddedIn(GI_2_7_0)
    SHOP_TYPE_ACTIVITY_ROGUE_DIARY(27001),

    /**
     * Shop from the [ActivityType.NEW_ACTIVITY_SUMMER_TIME_2_8]/Summertime Odyssey (v2.8) event.
     */
    @AddedIn(GI_2_8_0)
    SHOP_TYPE_ACTIVITY_SUMMER_TIME_V2(28001),
    @AddedIn(GI_3_0_0)
    SHOP_TYPE_ACTIVITY_GRAVEN_INNOCENCE(30001),
    @AddedIn(GI_3_0_0)
    SHOP_TYPE_ACTIVITY_TREASURE_SEELIE(30002),
    @AddedIn(GI_3_1_0)
    SHOP_TYPE_ACTIVITY_VINTAGE_ANGEL_S_SHARE(31001),
    @AddedIn(GI_3_2_0)
    SHOP_TYPE_ACTIVITY_FUNGUS_FIGHTER(32001),
    @AddedIn(GI_3_2_0)
    SHOP_TYPE_ACTIVITY_EFFIGY_V2(32002),
    @AddedIn(GI_3_3_0)
    SHOP_TYPE_ACTIVITY_BRICK_BREAKER(33001),
    @AddedIn(GI_3_5_0)
    SHOP_TYPE_ACTIVITY_FLEURFAIR_V2(35001),
    @AddedIn(GI_3_7_0)
    SHOP_TYPE_ACTIVITY_JOURNEY(37001),
    @AddedIn(GI_4_0_0)
    SHOP_TYPE_ACTIVITY_TOY_BATTLE (40001),
    @AddedIn(GI_4_3_0)
    SHOP_TYPE_ACTIVITY_TREASURE_HUNT_V4 (43001),
    @AddedIn(GI_4_3_0)
    SHOP_TYPE_ACTIVITY_FILMFEST (43002),
    @AddedIn(GI_4_5_0)
    SHOP_TYPE_ACTIVITY_ALCHEMY_SIM (45001),
    @AddedIn(GI_4_6_0)
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

    // todo identify version added
    SHOP_TYPE_BEYOND_RERUN(105000),


    @UnknownEntry
    SHOP_TYPE_UNKNOWN(99999);

    override fun getIntKey() = id
}
