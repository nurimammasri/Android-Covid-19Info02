package id.ac.unhas.infocovid19.ui.harian

import id.ac.unhas.infocovid19.model.DataHarian
import id.ac.unhas.infocovid19.model.DataSource
import id.ac.unhas.infocovid19.model.Harian

class HarianRepository(
    private val jsonString: String
) {
    fun getDataFromJsonString(): ArrayList<Harian> {
        val listHarian = ArrayList<Harian>()
        val dataHarian: DataHarian = DataSource.createDataSetHarian(jsonString)
        dataHarian.data?.forEach {
            if (it != null) {
                listHarian.add(it)
            }
        }
        return listHarian
    }
}
