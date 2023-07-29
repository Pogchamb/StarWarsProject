package pa.chan.starwarsproject.features.home.domain

import pa.chan.starwarsproject.features.favourites.domain.FavouritesRepository
import pa.chan.starwarsproject.features.home.data.extension.toEntity
import pa.chan.starwarsproject.features.home.domain.model.PeopleModel
import pa.chan.starwarsproject.features.home.domain.model.PlanetsModel
import pa.chan.starwarsproject.features.home.domain.model.StarWarsUnitModel
import pa.chan.starwarsproject.features.home.domain.model.StarshipsModel
import javax.inject.Inject

class AddItemUseCase @Inject constructor(
    private val favouritesRepository: FavouritesRepository
){
    suspend operator fun invoke(starWarsUnitModel: StarWarsUnitModel) {
        when (starWarsUnitModel) {
            is PeopleModel -> favouritesRepository.addItem(starWarsUnitModel.toEntity())
            is PlanetsModel -> favouritesRepository.addItem(starWarsUnitModel.toEntity())
            is StarshipsModel -> favouritesRepository.addItem(starWarsUnitModel.toEntity())
        }
    }
}