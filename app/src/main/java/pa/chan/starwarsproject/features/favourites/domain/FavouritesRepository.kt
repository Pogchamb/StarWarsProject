package pa.chan.starwarsproject.features.favourites.domain

import pa.chan.starwarsproject.features.favourites.data.entity.StarWarsEntity
import pa.chan.starwarsproject.features.home.domain.model.StarWarsUnitModel

interface FavouritesRepository {

    suspend fun getItems(): List<StarWarsUnitModel>

    suspend fun deleteItem(starWarsUnitModel: StarWarsUnitModel)

    suspend fun addItem(starWarsEntity: StarWarsEntity)
}