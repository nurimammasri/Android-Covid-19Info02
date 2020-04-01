package id.ac.unhas.infocovid19.ui.harian

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class HarianViewModelFactory(
    private val repository: HarianRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(HarianRepository::class.java).newInstance(repository)
    }
}