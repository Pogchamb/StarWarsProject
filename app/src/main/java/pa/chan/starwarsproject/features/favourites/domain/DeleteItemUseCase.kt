package pa.chan.starwarsproject.features.favourites.domain

import pa.chan.starwarsproject.features.home.domain.model.StarWarsUnitModel
import javax.inject.Inject

class DeleteItemUseCase @Inject constructor(
    private val favouritesRepository: FavouritesRepository
) {

    suspend operator fun invoke(starWarsUnitModel: StarWarsUnitModel) {
        favouritesRepository.deleteItem(starWarsUnitModel)
    }

}