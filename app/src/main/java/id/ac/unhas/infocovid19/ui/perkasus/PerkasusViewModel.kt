package id.ac.unhas.infocovid19.ui.perkasus

import androidx.lifecycle.ViewModel
import id.ac.unhas.infocovid19.model.PerKasus

class PerkasusViewModel(
    private val repository: PerkasusRepository
) : ViewModel() {
    private var _kasus = ArrayList<PerKasus>()
    val kasus: ArrayList<PerKasus>
        get() = _kasus

    fun getDataFromRepo() {
        //_movies.clear()
        _kasus.apply {
            if (isEmpty()) {
                addAll(repository.getDataFromJsonString())
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        _kasus.clear()
    }
}
