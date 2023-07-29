package pa.chan.starwarsproject.features.favourites.data.entity

import androidx.room.PrimaryKey

data class PeopleEntity(
    @PrimaryKey
    val name: String?,
    val gender: String?,
    val starships: List<String?>
) : StarWarsEntity
