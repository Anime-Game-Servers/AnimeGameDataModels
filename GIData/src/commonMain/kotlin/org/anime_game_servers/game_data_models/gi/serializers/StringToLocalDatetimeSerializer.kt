@file:OptIn(ExperimentalSerializationApi::class)

package org.anime_game_servers.game_data_models.gi.serializers

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlinx.datetime.format.char
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object StringToLocalDatetimeSerializer : KSerializer<LocalDateTime?> {
    private val format = LocalDateTime.Format {
        date(LocalDate.Formats.ISO)
        char(' ')
        time(LocalTime.Formats.ISO)
    }
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("org.animegameservers.models.gi.StringToLocalDatetimeSerializer",
        PrimitiveKind.STRING)
    override fun serialize(encoder: Encoder, value: LocalDateTime?) {
        encoder.encodeString(value?.let {
            format.format(value)
        } ?: "")
    }
    override fun deserialize(decoder: Decoder): LocalDateTime? {
        val s = decoder.decodeNullableSerializableValue(String.serializer())
        if (s.isNullOrBlank()) return null
        return LocalDateTime.parse(s, format)
    }
}