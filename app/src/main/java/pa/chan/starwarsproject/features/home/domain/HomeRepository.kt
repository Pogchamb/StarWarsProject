package pa.chan.starwarsproject.features.home.domain

import pa.chan.starwarsproject.features.home.domain.model.StarWarsUnitsModel

interface HomeRepository {

    suspend fun getUnits(): StarWarsUnitsModel

}