package org.anime_game_servers.game_data_models.loader.enums

import kotlinx.serialization.KSerializer
import org.anime_game_servers.game_data_models.loader.DataFile
import kotlin.enums.EnumEntries
import kotlin.reflect.KClass

interface EnumMetadata<T : Enum<T>> {
    val unknownEntry: T
    val noneEntry: T?
    val kClass: KClass<T>
    val serializer: KSerializer<T>
    val values: EnumEntries<T>
}
