package pa.chan.starwarsproject.features.favourites.data.entity

import androidx.room.PrimaryKey

data class StarshipEntity(
    @PrimaryKey
    val name: String?,
    val model: String?,
    val manufacturer: String?,
    val passengers: String?
): StarWarsEntity
