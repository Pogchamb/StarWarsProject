package pa.chan.starwarsproject.features.core

import androidx.room.Database
import androidx.room.RoomDatabase
import pa.chan.starwarsproject.features.favourites.data.FavouritesDao
import pa.chan.starwarsproject.features.favourites.data.entity.PeopleEntity
import pa.chan.starwarsproject.features.favourites.data.entity.PlanetEntity
import pa.chan.starwarsproject.features.favourites.data.entity.StarshipEntity

@Database(
    entities = [PeopleEntity::class, StarshipEntity::class, PlanetEntity::class],
    version = 1
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun favouritesDao(): FavouritesDao
}