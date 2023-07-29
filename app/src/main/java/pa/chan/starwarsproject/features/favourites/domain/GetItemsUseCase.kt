package pa.chan.starwarsproject.features.favourites.domain

import pa.chan.starwarsproject.features.home.domain.model.StarWarsUnitModel
import javax.inject.Inject

class GetItemsUseCase @Inject constructor(
    private val favouritesRepository: FavouritesRepository
) {

    suspend operator fun invoke(): List<StarWarsUnitModel> {
        return favouritesRepository.getItems()
    }

}