package org.anime_game_servers.game_data_models.gi.serializers

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object CStringToIntListSerializer : KSerializer<List<Int>> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("org.animegameservers.models.gi.StringToList",
        PrimitiveKind.STRING)
    override fun serialize(encoder: Encoder, value: List<Int>) {
        val str = value.joinToString(separator = ",")
        encoder.encodeString(str)
    }
    override fun deserialize(decoder: Decoder): List<Int> {
        val str = decoder.decodeString()
        if(str.isEmpty()) return emptyList()
        return str.split(",").mapNotNull { it.toIntOrNull() }
    }
}