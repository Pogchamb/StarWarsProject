package pa.chan.starwarsproject.features.home.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import pa.chan.starwarsproject.R
import pa.chan.starwarsproject.databinding.FragmentHomePageBinding
import pa.chan.starwarsproject.features.home.domain.model.PeopleModel
import pa.chan.starwarsproject.features.home.domain.model.PlanetsModel
import pa.chan.starwarsproject.features.home.domain.model.StarshipsModel
import pa.chan.starwarsproject.features.utils.ext.failedFinishAction
import pa.chan.starwarsproject.features.utils.ext.startAction
import pa.chan.starwarsproject.features.utils.ext.succeedFinishAction
import pa.chan.starwarsproject.features.utils.userExceptions.ConnectionException
import pa.chan.starwarsproject.features.utils.userExceptions.NotFoundException

@AndroidEntryPoint
class HomePageFragment : Fragment() {
    private val vm: HomeViewModel by viewModels()

    private var _binding: FragmentHomePageBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomePageBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val searchBtn = binding?.searchBtn
        val inputLayout = binding?.textInputLayout
        val editText = binding?.inputEditText

        vm.unitsLiveData.observe(viewLifecycleOwner) {
            binding?.succeedFinishAction()
            when (it) {
                is PeopleModel -> binding?.succeedFinishAction(
                    peopleModel = it,
                    context = requireContext()
                )
                is PlanetsModel -> binding?.succeedFinishAction(
                    planetsModel = it,
                    context = requireContext()
                )
                is StarshipsModel -> binding?.succeedFinishAction(
                    starshipsModel = it,
                    context = requireContext()
                )
                else -> {}
            }
        }
        vm.errorLiveData.observe(viewLifecycleOwner) {
            when(it) {
                ConnectionException -> {
                    it.errorImg?.let { img ->
                        binding?.errorLayout?.ErrorImg?.setBackgroundResource(
                            img
                        )
                    }
                    binding?.errorLayout?.ErrorMessage?.text = getString(it.errorMessage)
                    binding?.failedFinishAction()
                }
                NotFoundException -> {
                    val snackbar = Snackbar.make(view, getString(it.errorMessage), Snackbar.LENGTH_SHORT)
                    snackbar.show()
                }
            }
            binding?.failedFinishAction()
        }

        binding?.inputEditText?.addTextChangedListener {

            if (inputLayout?.isErrorEnabled == true) {
                inputLayout.isErrorEnabled = false
            }

            if (editText?.text.isNullOrEmpty()) {
                inputLayout?.isErrorEnabled = true
                inputLayout?.error = getString(R.string.emptyStr)
            }
        }

        var favouritesFlag = false

        binding?.peopleCard?.favouritesBtn?.setOnClickListener {

            favouritesFlag = if (favouritesFlag) {
                it.setBackgroundResource(R.drawable.ic_baseline_star_outline)
                false
            } else {
                it.setBackgroundResource(R.drawable.ic_baseline_star_fill)
                true
            }
        }

        binding?.planetCard?.favouritesBtn?.setOnClickListener {
            it.setBackgroundResource(R.drawable.ic_baseline_star_fill)
        }

        binding?.starshipCard?.favouritesBtn?.setOnClickListener {
            it.setBackgroundResource(R.drawable.ic_baseline_star_fill)
        }

        searchBtn?.progressBtn?.setOnClickListener {

            when {
                editText?.text?.length!! < 2 -> {
                    inputLayout?.isErrorEnabled = true
                    inputLayout?.error = getString(R.string.emptyStr)
                }
                else -> {
                    binding?.startAction()
                    val name = binding?.inputEditText?.text.toString()
                    val type = binding?.spinnerTypes?.selectedItem.toString()
                    vm.fetchStarWarsUnit(name, type)
                }
            }
        }
    }
}