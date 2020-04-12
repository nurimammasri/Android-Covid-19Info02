package id.ac.unhas.infocovid19.ui.provinsi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.unhas.infocovid19.model.Provinsi

class ProvinsiViewModel(
    private val repository: ProvinsiRepository
) : ViewModel() {
    fun getProvinsi(): MutableLiveData<ArrayList<Provinsi>> {
        return repository.getProvinsiFromApi()
    }

    override fun onCleared() {
        super.onCleared()
    }
}
