package pa.chan.starwarsproject.features.home.data

import pa.chan.starwarsproject.features.home.data.extension.toModel
import pa.chan.starwarsproject.features.home.domain.HomeRepository
import pa.chan.starwarsproject.features.home.domain.model.StarWarsUnitsModel
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeRemoteDatasourse: HomeRemoteDatasourse
) : HomeRepository {

    override suspend fun getUnits(): StarWarsUnitsModel {
        return try {
            val peoplesModel = homeRemoteDatasourse.getPeople().map {
                it.toModel()
            }
            val planetsModel = homeRemoteDatasourse.getPlanets().map {
                it.toModel()
            }
            val starshipsModel = homeRemoteDatasourse.getStarships().map {
                it.toModel()
            }

            StarWarsUnitsModel(planetsModel, starshipsModel, peoplesModel)
        } catch (e: Exception) {
            throw e
        }
    }
}