package id.ac.unhas.infocovid19.ui.harian

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.unhas.infocovid19.model.Harian

class HarianViewModel(
    private val repository: HarianRepository
) : ViewModel() {
    fun getHarian(): MutableLiveData<ArrayList<Harian>> {
        return repository.getHarianFromApi()
    }

    override fun onCleared() {
        super.onCleared()
    }
}
