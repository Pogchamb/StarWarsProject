package pa.chan.starwarsproject.features.favourites.data.entity

import androidx.room.PrimaryKey

data class PlanetEntity(
    @PrimaryKey
    val name: String?,
    val diameter: String?,
    val population: String?
) : StarWarsEntity
