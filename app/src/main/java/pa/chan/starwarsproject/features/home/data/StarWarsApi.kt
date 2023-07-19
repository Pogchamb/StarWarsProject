package pa.chan.starwarsproject.features.home.data

import pa.chan.starwarsproject.features.home.data.dto.StarWarsPeopleDto
import pa.chan.starwarsproject.features.home.data.dto.StarWarsPlanetsDto
import pa.chan.starwarsproject.features.home.data.dto.StarWarsStarshipsDto
import retrofit2.http.GET

interface StarWarsApi {

    @GET("/people")
    suspend fun getPeople(): StarWarsPeopleDto

    @GET("/planets")
    suspend fun getPlanets(): StarWarsPlanetsDto

    @GET("/starships")
    suspend fun getStarships(): StarWarsStarshipsDto

}