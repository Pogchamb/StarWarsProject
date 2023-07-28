package pa.chan.starwarsproject.features.home.data

import pa.chan.starwarsproject.features.home.data.dto.StarWarsPeopleDto
import pa.chan.starwarsproject.features.home.data.dto.StarWarsPlanetsDto
import pa.chan.starwarsproject.features.home.data.dto.StarWarsStarshipsDto
import pa.chan.starwarsproject.features.home.data.dto.StarshipsDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StarWarsApi {

    @GET("people/")
    suspend fun getPeople(@Query("search") name : String): StarWarsPeopleDto

    @GET("planets/")
    suspend fun getPlanets(@Query("search") name : String): StarWarsPlanetsDto

    @GET("starships/")
    suspend fun getStarships(@Query("search") name : String): StarWarsStarshipsDto

    @GET("starships/{num}")
    suspend fun getStarshipName(@Path(value = "num") num : String) : StarshipsDto

}