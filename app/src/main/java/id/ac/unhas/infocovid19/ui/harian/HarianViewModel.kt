package id.ac.unhas.infocovid19.ui.harian

import androidx.lifecycle.ViewModel
import id.ac.unhas.infocovid19.model.Harian

class HarianViewModel(
    private val repository: HarianRepository
) : ViewModel() {
    private var _dataharian = ArrayList<Harian>()
    val dataharian: ArrayList<Harian>
        get() = _dataharian

    fun getDataFromRepo() {
        //_movies.clear()
        _dataharian.apply {
            if (isEmpty()) {
                addAll(repository.getDataFromJsonString())
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        _dataharian.clear()
    }
}
