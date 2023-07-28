package pa.chan.starwarsproject.features.home.data.dto

data class StarWarsPeopleDto(
    val results: List<PeopleDto?>
)

data class StarWarsPlanetsDto(
    val results: List<PlanetsDto?>
)

data class StarWarsStarshipsDto(
    val results: List<StarshipsDto?>
)
