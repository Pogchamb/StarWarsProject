package pa.chan.starwarsproject.features.home.domain.model

data class StarWarsUnitsModel(
    val planets: List<PlanetsModel>,
    val starships: List<StarshipsModel>,
    val people: List<PeopleModel>
)
