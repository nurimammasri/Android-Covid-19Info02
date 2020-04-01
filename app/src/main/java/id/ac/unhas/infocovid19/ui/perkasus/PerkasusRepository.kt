package id.ac.unhas.infocovid19.ui.perkasus

import id.ac.unhas.infocovid19.model.DataPerkasus
import id.ac.unhas.infocovid19.model.DataSource
import id.ac.unhas.infocovid19.model.PerKasus

class PerkasusRepository(
    private val jsonString: String
) {
    fun getDataFromJsonString(): ArrayList<PerKasus> {
        val listKasus = ArrayList<PerKasus>()
        val dataKasus: DataPerkasus = DataSource.createDataSetPerKasus(jsonString)
        dataKasus.data?.forEach {
            if (it != null) {
                listKasus.add(it)
            }
        }
        return listKasus
    }
}
