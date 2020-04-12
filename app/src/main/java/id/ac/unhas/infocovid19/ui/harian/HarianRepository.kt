package id.ac.unhas.infocovid19.ui.harian

import android.util.Log
import androidx.lifecycle.MutableLiveData
import id.ac.unhas.infocovid19.model.DataHarian
import id.ac.unhas.infocovid19.model.DataSource
import id.ac.unhas.infocovid19.model.Harian
import id.ac.unhas.infocovid19.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HarianRepository() {
    private val mutableLiveData: MutableLiveData<ArrayList<Harian>> =
        MutableLiveData<ArrayList<Harian>>()

    fun getDataFromJsonString(jsonString: String): ArrayList<Harian> {
        val listHarian = ArrayList<Harian>()
        val dataHarian: DataHarian = DataSource.createDataSetHarian(jsonString)
        dataHarian.data?.forEach {
            if (it != null) {
                listHarian.add(it)
            }
        }
        return listHarian
    }

    fun getHarianFromApi(): MutableLiveData<ArrayList<Harian>> {

        val api = NetworkConfig().api()

        api.getDataHarian().enqueue(object : Callback<DataHarian> {
            override fun onFailure(call: Call<DataHarian>, t: Throwable) {
                Log.d(this.javaClass.simpleName, "error : ${t.stackTrace}")
            }

            override fun onResponse(call: Call<DataHarian>, response: Response<DataHarian>) {
                val dataHarian = response.body()?.data
                mutableLiveData.value = dataHarian as ArrayList<Harian>?
            }
        })

        return mutableLiveData
    }
}
