package pa.chan.starwarsproject.features.utils.ext

import android.content.Context
import android.view.View
import pa.chan.starwarsproject.R
import pa.chan.starwarsproject.databinding.FragmentHomePageBinding
import pa.chan.starwarsproject.databinding.PeopleCardBinding
import pa.chan.starwarsproject.databinding.PlanetCardBinding
import pa.chan.starwarsproject.databinding.StarshipCardBinding
import pa.chan.starwarsproject.features.home.domain.model.PeopleModel
import pa.chan.starwarsproject.features.home.domain.model.PlanetsModel
import pa.chan.starwarsproject.features.home.domain.model.StarshipsModel

fun PeopleCardBinding.fillCard(peopleModel: PeopleModel, context: Context) {
    this.name.text =
        String.format(context.getString(R.string.card_format_str), peopleModel.name, "Name")
    this.gender.text =
        String.format(context.getString(R.string.card_format_str), peopleModel.gender, "Gender")
    this.starships.text = String.format(
        context.getString(R.string.card_format_str),
        peopleModel.starships?.joinToString(";\n"),
        "Starship"
    )
}

fun PlanetCardBinding.fillCard(planetsModel: PlanetsModel, context: Context) {
    this.name.text =
        String.format(context.getString(R.string.card_format_str), planetsModel.name, "Name")
    this.diameter.text = String.format(
        context.getString(R.string.card_format_str),
        planetsModel.diameter,
        "Diameter"
    )
    this.population.text = String.format(
        context.getString(R.string.card_format_str),
        planetsModel.population,
        "Population"
    )
}

fun StarshipCardBinding.fillCard(starshipsModel: StarshipsModel, context: Context) {
    this.name.text =
        String.format(context.getString(R.string.card_format_str), starshipsModel.name, "Name")
    this.model.text =
        String.format(context.getString(R.string.card_format_str), starshipsModel.model, "Model")
    this.passengers.text = String.format(
        context.getString(R.string.card_format_str),
        starshipsModel.passengers,
        "Passengers"
    )
    this.manufacturer.text = String.format(
        context.getString(R.string.card_format_str),
        starshipsModel.manufacturer,
        "Manufacturer"
    )
}

fun FragmentHomePageBinding.succeedFinishAction(peopleModel: PeopleModel, context: Context) {
    this.planetCard.planetCard.visibility = View.GONE
    this.peopleCard.peopleCard.visibility = View.VISIBLE
    this.starshipCard.starshipCard.visibility = View.GONE
    this.peopleCard.fillCard(peopleModel, context)
}

fun FragmentHomePageBinding.succeedFinishAction(planetsModel: PlanetsModel, context: Context) {
    this.planetCard.planetCard.visibility = View.VISIBLE
    this.peopleCard.peopleCard.visibility = View.GONE
    this.starshipCard.starshipCard.visibility = View.GONE
    this.planetCard.fillCard(planetsModel, context)
}

fun FragmentHomePageBinding.succeedFinishAction(starshipsModel: StarshipsModel, context: Context) {
    this.planetCard.planetCard.visibility = View.GONE
    this.peopleCard.peopleCard.visibility = View.GONE
    this.starshipCard.starshipCard.visibility = View.VISIBLE
    this.starshipCard.fillCard(starshipsModel, context)
}