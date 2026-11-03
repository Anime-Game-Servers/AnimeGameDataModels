@file:OptIn(ExperimentalSerializationApi::class)

package org.anime_game_servers.game_data_models.gi.data.item

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.core.base.interfaces.IntKey
import org.anime_game_servers.game_data_models.loader.enums.DataEnum
import org.anime_game_servers.game_data_models.loader.enums.UnknownEntry

@DataEnum
@Serializable
enum class SpecialFurnitureType(val id: Int) : IntKey {
    @JsonNames("NormalFurnitrue", "NormalFurniture", "NORMAL_FURNITRUE")
    NORMAL_FURNITURE(0),
    @JsonNames("BlockDependent")
    BLOCK_DEPENDENT(1),
    @JsonNames("FarmField")
    FARM_FIELD(2),
    @JsonNames("TeleportPoint")
    TELEPORT_POINT(3),
    @JsonNames("Fishpond")
    FISHPOND(4),
    NPC(5),
    @JsonNames("Apartment")
    APARTMENT(6),
    @JsonNames("FurnitureSuite")
    FURNITURE_SUITE(7),
    @JsonNames("Paimon")
    PAIMON(8),
    @JsonNames("Fish")
    FISH(9),
    @JsonNames("CustomBaseFurnitrue", "CustomBaseFurniture", "CUSTOM_BASE_FURNITRUE")
    CUSTOM_BASE_FURNITURE(10),
    @JsonNames("CustomNodeFurnitrue", "CustomNodeFurniture", "CUSTOM_NODE_FURNITRUE")
    CUSTOM_NODE_FURNITURE(11),
    @JsonNames("VirtualFurnitrue", "VirtualFurniture", "VIRTUAL_FURNITRUE")
    VIRTUAL_FURNITURE(12),
    @JsonNames("GroupFurnitrue", "GroupFurniture", "GROUP_FURNITRUE")
    GROUP_FURNITURE(13),
    @JsonNames("CoopPictureFrame")
    COOP_PICTURE_FRAME(14),
    @JsonNames("ChangeBgmFurniture")
    CHANGE_BGM_FURNITURE(15),
    @JsonNames("ServerGadget")
    SERVER_GADGET(16),
    @JsonNames("Fishtank", "FishTank", "FISHTANK")
    FISH_TANK(17),
    @JsonNames("LavaFish")
    LAVA_FISH(18),
    @JsonNames("LavaFishpond")
    LAVA_FISHPOND(19),

    @UnknownEntry
    UNKNOWN(9999);

    override fun getIntKey() = id
}
