package pa.chan.starwarsproject.features.home.domain

import pa.chan.starwarsproject.features.home.domain.model.StarWarsUnitsModel
import javax.inject.Inject

class GetUnitsUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {

    suspend operator fun invoke(): StarWarsUnitsModel {
        return homeRepository.getUnits()
    }

}