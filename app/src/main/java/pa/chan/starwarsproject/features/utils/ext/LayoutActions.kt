package pa.chan.starwarsproject.features.utils.ext

import android.view.View
import pa.chan.starwarsproject.databinding.FragmentHomePageBinding
import pa.chan.starwarsproject.databinding.ProgressBtnBinding

fun FragmentHomePageBinding.startAction() {
    this.errorLayout.errorLayout.visibility = View.GONE
    this.homeProgressBar.visibility = View.VISIBLE
    this.starshipCard.starshipCard.visibility = View.GONE
    this.planetCard.planetCard.visibility = View.GONE
    this.peopleCard.peopleCard.visibility = View.GONE
    this.spinnerTypes.visibility = View.VISIBLE
    this.textInputLayout.visibility = View.VISIBLE
    this.logo.visibility = View.VISIBLE
}

fun FragmentHomePageBinding.failedFinishAction() {
    this.errorLayout.errorLayout.visibility = View.VISIBLE
    this.homeProgressBar.visibility = View.GONE
    this.searchBtn.progressBtn.visibility = View.GONE
    this.starshipCard.starshipCard.visibility = View.GONE
    this.planetCard.planetCard.visibility = View.GONE
    this.peopleCard.peopleCard.visibility = View.GONE
    this.spinnerTypes.visibility = View.GONE
    this.textInputLayout.visibility = View.GONE
    this.logo.visibility = View.GONE
}

fun FragmentHomePageBinding.succeedFinishAction() {
    this.errorLayout.errorLayout.visibility = View.GONE
    this.homeProgressBar.visibility = View.GONE
    this.searchBtn.progressBtn.visibility = View.VISIBLE
    this.spinnerTypes.visibility = View.VISIBLE
    this.textInputLayout.visibility = View.VISIBLE
    this.logo.visibility = View.VISIBLE
}

fun ProgressBtnBinding.startAction() {
    this.progressBar.visibility = View.VISIBLE
    this.btnText.visibility = View.GONE
}

fun ProgressBtnBinding.finishAction() {
    this.progressBar.visibility = View.GONE
    this.btnText.visibility = View.VISIBLE
}