package id.ac.unhas.infocovid19.ui.perkasus

import android.util.Log
import androidx.lifecycle.MutableLiveData
import id.ac.unhas.infocovid19.model.DataPerkasus
import id.ac.unhas.infocovid19.model.DataSource
import id.ac.unhas.infocovid19.model.PerKasus
import id.ac.unhas.infocovid19.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PerkasusRepository() {
    private val mutableLiveData: MutableLiveData<ArrayList<PerKasus>> =
        MutableLiveData<ArrayList<PerKasus>>()

    fun getDataFromJsonString(jsonString: String): ArrayList<PerKasus> {
        val listKasus = ArrayList<PerKasus>()
        val dataKasus: DataPerkasus = DataSource.createDataSetPerKasus(jsonString)
        dataKasus.data?.forEach {
            if (it != null) {
                listKasus.add(it)
            }
        }
        return listKasus
    }

    fun getPerkasusFromApi(): MutableLiveData<ArrayList<PerKasus>> {

        val api = NetworkConfig().api()

        api.getDataPerkasus().enqueue(object : Callback<DataPerkasus> {
            override fun onFailure(call: Call<DataPerkasus>, t: Throwable) {
                Log.d(this.javaClass.simpleName, "error : ${t.stackTrace}")
            }

            override fun onResponse(call: Call<DataPerkasus>, response: Response<DataPerkasus>) {
                val dataPerkasus = response.body()?.data
                mutableLiveData.value = dataPerkasus as ArrayList<PerKasus>?
            }
        })

        return mutableLiveData
    }
}
