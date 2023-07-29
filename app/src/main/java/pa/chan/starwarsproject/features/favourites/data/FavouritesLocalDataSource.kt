package pa.chan.starwarsproject.features.favourites.data

import pa.chan.starwarsproject.features.favourites.data.entity.PeopleEntity
import pa.chan.starwarsproject.features.favourites.data.entity.PlanetEntity
import pa.chan.starwarsproject.features.favourites.data.entity.StarWarsEntity
import pa.chan.starwarsproject.features.favourites.data.entity.StarshipEntity
import pa.chan.starwarsproject.features.home.domain.model.PeopleModel
import pa.chan.starwarsproject.features.home.domain.model.PlanetsModel
import pa.chan.starwarsproject.features.home.domain.model.StarWarsUnitModel
import pa.chan.starwarsproject.features.home.domain.model.StarshipsModel
import javax.inject.Inject

class FavouritesLocalDataSource @Inject constructor(
    private val favouritesDao: FavouritesDao
) {

    suspend fun getPeoples(): List<PeopleEntity> {
        return favouritesDao.getPeoples()
    }

    suspend fun getPlanets(): List<PlanetEntity> {
        return favouritesDao.getPlanets()
    }

    suspend fun getStarships(): List<StarshipEntity> {
        return favouritesDao.getStarships()
    }

    suspend fun deleteItem(starWarsUnitModel: StarWarsUnitModel) {
        when (starWarsUnitModel) {
            is PeopleModel -> starWarsUnitModel.name?.let { favouritesDao.deletePeople(it) }
            is PlanetsModel -> starWarsUnitModel.name?.let { favouritesDao.deletePlanet(it) }
            is StarshipsModel -> starWarsUnitModel.name?.let { favouritesDao.deleteStarship(it) }
        }
    }

    suspend fun insertItem(starWarsEntity: StarWarsEntity) {
        when (starWarsEntity) {
            is PeopleEntity -> favouritesDao.insertItem(starWarsEntity)
            is PlanetEntity -> favouritesDao.insertItem(starWarsEntity)
            is StarshipEntity -> favouritesDao.insertItem(starWarsEntity)
        }
    }


}