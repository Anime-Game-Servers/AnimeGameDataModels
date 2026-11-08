package org.anime_game_servers.game_data_models.loader.enums

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.intOrNull
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.serializer
import kotlin.enums.EnumEntries
import kotlin.enums.enumEntries

class EnumWrapperBaseSerializer<T: Enum<T>>(
    private val metadata: EnumMetadata<T>
) : KSerializer<EnumWrapper<T>> {
    val enumSerializer = metadata.serializer

    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor(
            "EnumContainer<${enumSerializer.descriptor.serialName}>",
            PrimitiveKind.STRING
        )

    override fun deserialize(decoder: Decoder): EnumWrapper<T> =
        if (decoder is JsonDecoder) deserializeJson(decoder) else deserializeText(decoder)


    // JSON: the primitive tells us whether it was quoted.
    private fun deserializeJson(decoder: JsonDecoder): EnumWrapper<T> {
        val primitive = decoder.decodeJsonElement().jsonPrimitive
        val key = primitive.content
        val value = if (primitive.isString) {
            // Name first; a quoted number like "2" falls back to the int route.
            metadata.fromStringKey(key) ?: key.toIntOrNull()?.let(metadata::fromIntKey)
        } else {
            primitive.intOrNull?.let(metadata::fromIntKey)
        }
        return EnumWrapper(key = key, value = value ?: metadata.unknownEntry)
    }

    // Text formats (TSV): mostly int keys, so try int first, then the name.
    private fun deserializeText(decoder: Decoder): EnumWrapper<T> {
        val key = decoder.decodeString()
        val value = key.toIntOrNull()?.let(metadata::fromIntKey) ?: metadata.fromStringKey(key)
        return EnumWrapper(key = key, value = value ?: metadata.unknownEntry)
    }


    override fun serialize(
        encoder: Encoder,
        value: EnumWrapper<T>
    ) {
        encoder.encodeString(value.key)
    }
}
