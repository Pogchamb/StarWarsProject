package pa.chan.starwarsproject.features.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pa.chan.starwarsproject.features.home.domain.SearchUnitUseCase
import pa.chan.starwarsproject.features.home.domain.model.StarWarsUnitModel
import pa.chan.starwarsproject.features.utils.userExceptions.ConnectionException
import pa.chan.starwarsproject.features.utils.userExceptions.NotFoundException
import pa.chan.starwarsproject.features.utils.userExceptions.UserError
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val searchUnitUseCase: SearchUnitUseCase
) : ViewModel() {
    private val _unitsLiveData: MutableLiveData<StarWarsUnitModel?> = MutableLiveData()
    val unitsLiveData: LiveData<StarWarsUnitModel?>
        get() = _unitsLiveData

    private val _errorLiveData: MutableLiveData<UserError> = MutableLiveData()
    val errorLiveData: LiveData<UserError>
        get() = _errorLiveData

    fun fetchStarWarsUnit(name: String, type: String) {
        viewModelScope.launch {
            try {
                _unitsLiveData.postValue(searchUnitUseCase(name, type))
            } catch (e: NotFoundException) {
                _errorLiveData.postValue(e)
            } catch (e: ConnectionException) {
                _errorLiveData.postValue(e)
            }
        }
    }
}