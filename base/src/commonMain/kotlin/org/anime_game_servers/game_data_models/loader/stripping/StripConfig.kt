package org.anime_game_servers.game_data_models.loader.stripping

import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

data class StripConfig @JvmOverloads constructor(
    val minify: Boolean = false,
    val removeUnknown: Boolean = false,
    val removeNulls: Boolean = false,
    val removeServerOnly: Boolean = false,
    val removeClientOnly: Boolean = false,
) {
    fun shouldStrip() = minify || removeUnknown || removeNulls || removeServerOnly || removeClientOnly

    companion object {
        @JvmField
        val NONE: StripConfig = StripConfig()
        @JvmField
        val SAFE: StripConfig = StripConfig(minify = true, removeNulls = true)
        @JvmField
        val FULL = StripConfig(minify = true, removeUnknown = true, removeNulls = true)
    }
}
