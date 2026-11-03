package org.anime_game_servers.game_data_models.loader.enums

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.serializer
import kotlin.enums.EnumEntries
import kotlin.enums.enumEntries

class EnumWrapperBaseSerializer<T: Enum<T>>(
    private val enumSerializer: KSerializer<T>,
    private val enumValues: EnumEntries<T>,
    private val unknown: T
) : KSerializer<EnumWrapper<T>> {

    constructor(metadata: EnumMetadata<T>) : this(
        enumSerializer = metadata.serializer,
        enumValues = metadata.values,
        unknown = metadata.unknownEntry
    )

    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor(
            "EnumContainer<${enumSerializer.descriptor.serialName}>",
            PrimitiveKind.STRING
        )

    override fun deserialize(decoder: Decoder): EnumWrapper<T> {
        val key = decoder.decodeString()

        val index = enumSerializer.descriptor.getElementIndex(key)

        val value = if (index != CompositeDecoder.UNKNOWN_NAME) {
            enumValues[index]
        } else {
            unknown
        }

        return EnumWrapper(key = key, value = value)
    }

    override fun serialize(
        encoder: Encoder,
        value: EnumWrapper<T>
    ) {
        encoder.encodeString(value.key)
    }
}

inline fun <reified T : Enum<T>> enumContainerSerializer(
    unknown: T
): KSerializer<EnumWrapper<T>> =
    EnumWrapperBaseSerializer(
        enumSerializer = serializer<T>(),
        enumValues = enumEntries<T>(),
        unknown = unknown
    )