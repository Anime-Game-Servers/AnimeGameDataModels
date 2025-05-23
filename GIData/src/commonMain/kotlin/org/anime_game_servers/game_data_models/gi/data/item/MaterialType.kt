package org.anime_game_servers.game_data_models.gi.data.item

import org.anime_game_servers.core.base.interfaces.IntKey

enum class MaterialType(val id: Int) : IntKey {
    MATERIAL_NONE (0),
    MATERIAL_FOOD (1),
    MATERIAL_QUEST (2),
    MATERIAL_EXCHANGE (4),
    MATERIAL_CONSUME (5),
    MATERIAL_EXP_FRUIT (6),
    MATERIAL_AVATAR (7),
    MATERIAL_ADSORBATE (8),
    MATERIAL_CRICKET (9),
    MATERIAL_ELEM_CRYSTAL (10),
    MATERIAL_WEAPON_EXP_STONE (11),
    MATERIAL_CHEST (12),
    MATERIAL_RELIQUARY_MATERIAL (13),
    MATERIAL_AVATAR_MATERIAL (14),
    MATERIAL_NOTICE_ADD_HP (15),
    MATERIAL_SEA_LAMP (16),
    MATERIAL_SELECTABLE_CHEST (17),
    MATERIAL_FLYCLOAK (18),
    MATERIAL_NAMECARD (19),
    MATERIAL_TALENT (20),
    MATERIAL_WIDGET (21),
    MATERIAL_CHEST_BATCH_USE (22),
    MATERIAL_FAKE_ABSORBATE (23),
    MATERIAL_CONSUME_BATCH_USE (24),
    MATERIAL_WOOD (25),
    MATERIAL_FURNITURE_FORMULA (27),
    MATERIAL_CHANNELLER_SLAB_BUFF (28),
    MATERIAL_FURNITURE_SUITE_FORMULA (29),
    MATERIAL_COSTUME (30),
    MATERIAL_HOME_SEED (31),
    MATERIAL_FISH_BAIT (32),
    MATERIAL_FISH_ROD (33),
    MATERIAL_SUMO_BUFF (34),
    MATERIAL_FIREWORKS (35),
    MATERIAL_BGM (36),
    MATERIAL_SPICE_FOOD (37),
    MATERIAL_ACTIVITY_ROBOT (38),
    MATERIAL_ACTIVITY_GEAR (39),
    MATERIAL_ACTIVITY_JIGSAW (40),
    MATERIAL_ARANARA (41),
    MATERIAL_GCG_CARD (42),
    MATERIAL_GCG_CARD_FACE (43),
    MATERIAL_GCG_CARD_BACK (44),
    MATERIAL_GCG_Field (45),
    MATERIAL_DESHRET_MANUAL (46),
    MATERIAL_RENAME_ITEM (47),
    MATERIAL_GCG_EXCHANGE_ITEM (48),
    MATERIAL_QUEST_EVENT_BOOK (49),
    MATERIAL_PROFILE_PICTURE (50),
    MATERIAL_RAINBOW_PRINCE_HAND_BOOK (51),
    MATERIAL_PHOTO_DISPLAY_BOOK (52),
    MATERIAL_REMUS_MUSIC_BOX (4601),
    MATERIAL_GREATEFESTIVALV2_INVITE (4602),
    MATERIAL_PHOTOGRAPH_POSE (53),
    MATERIAL_AVATAR_TRACE (54),
    MATERIAL_PHOTOV5_HAND_BOOK (55),
    MATERIAL_FIRE_MASTER_AVATAR_TALENT_ITEM (56),
    MATERIAL_CHEST_BATCH_USE_WITH_GROUP (58),
    MATERIAL_NATLAN_RELATION_A (59),
    MATERIAL_NATLAN_RELATION_B (60),
    MATERIAL_NATLAN_RACE_ALBUM (62),
    MATERIAL_NATLAN_RACE_ENVELOPE (62),
    MATERIAL_LANV5_PAIMON_GREETING_CARD (63),
    MATERIAL_QUEST_ALBUM (64),
    MATERIAL_MIKAWA_FLOWER_INVITE (65),
    MATERIAL_UNKNOWN(9999);

    override fun getIntKey() = id
}