package pa.chan.starwarsproject.features.home.data

import pa.chan.starwarsproject.features.home.data.dto.PeopleDto
import pa.chan.starwarsproject.features.home.data.dto.PlanetsDto
import pa.chan.starwarsproject.features.home.data.dto.StarshipsDto
import javax.inject.Inject

class HomeRemoteDatasourse @Inject constructor(
    private val starWarsApi: StarWarsApi
) {

    suspend fun getPeople(): List<PeopleDto> {
        return starWarsApi.getPeople().result
    }

    suspend fun getPlanets(): List<PlanetsDto> {
        return starWarsApi.getPlanets().result
    }

    suspend fun getStarships(): List<StarshipsDto> {
        return starWarsApi.getStarships().result
    }
}