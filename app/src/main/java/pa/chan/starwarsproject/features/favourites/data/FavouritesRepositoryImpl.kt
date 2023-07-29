package pa.chan.starwarsproject.features.favourites.data

import pa.chan.starwarsproject.features.favourites.data.entity.StarWarsEntity
import pa.chan.starwarsproject.features.favourites.domain.FavouritesRepository
import pa.chan.starwarsproject.features.home.data.extension.toModel
import pa.chan.starwarsproject.features.home.domain.model.StarWarsUnitModel
import javax.inject.Inject

class FavouritesRepositoryImpl @Inject constructor(
    private val favouritesLocalDataSource: FavouritesLocalDataSource
) : FavouritesRepository {
    override suspend fun getItems(): List<StarWarsUnitModel> {
        val peoples = favouritesLocalDataSource.getPeoples().map {
            it.toModel()
        }
        val starships = favouritesLocalDataSource.getStarships().map {
            it.toModel()
        }
        val planets = favouritesLocalDataSource.getPlanets().map {
            it.toModel()
        }

        return peoples + starships + planets
    }

    override suspend fun deleteItem(starWarsUnitModel: StarWarsUnitModel) {
        favouritesLocalDataSource.deleteItem(starWarsUnitModel)
    }

    override suspend fun addItem(starWarsEntity: StarWarsEntity) {
        favouritesLocalDataSource.insertItem(starWarsEntity)
    }
}