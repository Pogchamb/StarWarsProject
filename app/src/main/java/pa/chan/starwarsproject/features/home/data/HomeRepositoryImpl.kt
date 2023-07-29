package pa.chan.starwarsproject.features.home.data

import pa.chan.starwarsproject.features.home.data.extension.toModel
import pa.chan.starwarsproject.features.home.domain.HomeRepository
import pa.chan.starwarsproject.features.home.domain.model.StarWarsUnitModel
import pa.chan.starwarsproject.features.utils.userExceptions.ConnectionException
import pa.chan.starwarsproject.features.utils.userExceptions.NotFoundException
import retrofit2.HttpException
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeRemoteDatasourse: HomeRemoteDatasourse
) : HomeRepository {

    override suspend fun getStarWarsUnit(name: String, type: String): StarWarsUnitModel? {
        try {

            when(type) {
                "Planet" -> {
                    return try {
                        homeRemoteDatasourse.getPlanets(name)[0]?.toModel()
                    } catch (e: HttpException) {
                        throw NotFoundException
                    }
                }
                "People" -> {
                    return try {
                        val people = homeRemoteDatasourse.getPeople(name)[0]
                        val starshipsList = people?.starships?.map {
                            val str = it?.substringBeforeLast("/")?.substringAfterLast("/")
                            homeRemoteDatasourse.getStarship(str).name
                        }

                        people?.toModel(starshipsList)
                    } catch (e: HttpException) {
                        throw NotFoundException
                    }
                }
                "Starship" -> {
                    return try {
                        homeRemoteDatasourse.getStarships(name)[0]?.toModel()
                    } catch (e: HttpException) {
                        throw NotFoundException
                    }
                }
                else -> {
                    return null
                }
            }

        } catch (e: Exception) {
            throw ConnectionException
        }
    }
}