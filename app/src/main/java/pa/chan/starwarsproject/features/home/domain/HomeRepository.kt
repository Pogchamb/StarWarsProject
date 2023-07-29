package pa.chan.starwarsproject.features.home.domain

import pa.chan.starwarsproject.features.home.domain.model.StarWarsUnitModel

interface HomeRepository {

    suspend fun getStarWarsUnit(name: String, type: String): StarWarsUnitModel?

}