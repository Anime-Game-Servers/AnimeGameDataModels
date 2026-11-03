package org.anime_game_servers.game_data_models.loader.stripping

interface Strippable<T: Strippable<T>> {
    fun strip(config: StripConfig): T
}

fun <T> T.stripElement(stripConfig: StripConfig) : T {
    return if (this is Strippable<*>){
        @Suppress("UNCHECKED_CAST")
        this.strip(config = stripConfig) as T
    } else {
        this
    }
}
