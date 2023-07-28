package pa.chan.starwarsproject.features.home.data

import pa.chan.starwarsproject.features.home.data.dto.*
import javax.inject.Inject

class HomeRemoteDatasourse @Inject constructor(
    private val starWarsApi: StarWarsApi
) {

    suspend fun getPeople(name: String): List<PeopleDto?> {
        return starWarsApi.getPeople(name).results
    }

    suspend fun getPlanets(name: String): List<PlanetsDto?> {
        return starWarsApi.getPlanets(name).results
    }

    suspend fun getStarships(name: String): List<StarshipsDto?> {
        return starWarsApi.getStarships(name).results
    }

    suspend fun getStarship(num: String?): StarshipsDto {
        return num?.let { starWarsApi.getStarshipName(it) } as StarshipsDto
    }
}