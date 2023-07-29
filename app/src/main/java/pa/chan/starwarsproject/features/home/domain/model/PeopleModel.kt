package pa.chan.starwarsproject.features.home.domain.model

data class PeopleModel(
    val name: String?,
    val gender: String?,
    val starships: List<String?>
) : StarWarsUnitModel
