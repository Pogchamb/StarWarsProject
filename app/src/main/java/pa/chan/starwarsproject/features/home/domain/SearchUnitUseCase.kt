package pa.chan.starwarsproject.features.home.domain

import pa.chan.starwarsproject.features.home.domain.model.StarWarsUnitModel
import javax.inject.Inject

class SearchUnitUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {

    suspend operator fun invoke(name: String, type: String): StarWarsUnitModel? {
        return homeRepository.getStarWarsUnit(name, type)
    }

}