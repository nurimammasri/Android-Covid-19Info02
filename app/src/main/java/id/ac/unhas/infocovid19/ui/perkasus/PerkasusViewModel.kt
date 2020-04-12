package id.ac.unhas.infocovid19.ui.perkasus

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.unhas.infocovid19.model.PerKasus

class PerkasusViewModel(
    private val repository: PerkasusRepository
) : ViewModel() {
    fun getPerkasus(): MutableLiveData<ArrayList<PerKasus>> {
        return repository.getPerkasusFromApi()
    }

    override fun onCleared() {
        super.onCleared()
    }
}
