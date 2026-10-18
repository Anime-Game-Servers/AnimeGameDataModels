package org.anime_game_servers.game_data_models.loader

/**
 * Type of a file that can be loaded.
 * Currently only JSON is supported, but TSV is planned.
 * JSON patch can contain full or incomplete data that needs to be applied on existing data
 */
enum class FileType {
    JSON,
    TSV,
    BLK,
    OTHER,
}
