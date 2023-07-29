package pa.chan.starwarsproject.features.favourites.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import pa.chan.starwarsproject.features.favourites.data.entity.PeopleEntity
import pa.chan.starwarsproject.features.favourites.data.entity.PlanetEntity
import pa.chan.starwarsproject.features.favourites.data.entity.StarWarsEntity
import pa.chan.starwarsproject.features.favourites.data.entity.StarshipEntity

@Dao
interface FavouritesDao {

    @Query("SELECT * FROM peopleEntity")
    suspend fun getPeoples(): List<PeopleEntity>

    @Query("SELECT * FROM starshipEntity")
    suspend fun getStarships(): List<StarshipEntity>

    @Query("SELECT * FROM planetEntity")
    suspend fun getPlanets(): List<PlanetEntity>

    @Query("DELETE FROM peopleEntity WHERE name = :name")
    suspend fun deletePeople(name: String)

    @Query("DELETE FROM planetEntity WHERE name = :name")
    suspend fun deletePlanet(name: String)

    @Query("DELETE FROM starshipEntity WHERE name = :name")
    suspend fun deleteStarship(name: String)

    @Insert
    suspend fun insertItem(starWarsEntity: StarWarsEntity)
}