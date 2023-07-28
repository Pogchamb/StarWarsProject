package pa.chan.starwarsproject.features.home.data.extension

import pa.chan.starwarsproject.features.home.data.dto.PeopleDto
import pa.chan.starwarsproject.features.home.data.dto.PlanetsDto
import pa.chan.starwarsproject.features.home.data.dto.StarshipsDto
import pa.chan.starwarsproject.features.home.domain.model.PeopleModel
import pa.chan.starwarsproject.features.home.domain.model.PlanetsModel
import pa.chan.starwarsproject.features.home.domain.model.StarshipsModel

fun PeopleDto.toModel(starshipList: List<String?>?): PeopleModel = PeopleModel(
    name = this.name,
    gender = this.gender,
    starships = starshipList
)

fun PlanetsDto.toModel(): PlanetsModel = PlanetsModel(
    name = this.name,
    diameter = this.diameter,
    population = this.population
)

fun StarshipsDto.toModel(): StarshipsModel = StarshipsModel(
    name = this.name,
    model = this.model,
    manufacturer = this.manufacturer,
    passengers = this.passengers
)