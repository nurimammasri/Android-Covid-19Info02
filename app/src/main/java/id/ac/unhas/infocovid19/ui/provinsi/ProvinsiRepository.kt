package id.ac.unhas.infocovid19.ui.provinsi

import android.util.Log
import androidx.lifecycle.MutableLiveData
import id.ac.unhas.infocovid19.model.DataProvinsi
import id.ac.unhas.infocovid19.model.DataSource
import id.ac.unhas.infocovid19.model.Provinsi
import id.ac.unhas.infocovid19.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProvinsiRepository() {
    private val mutableLiveData: MutableLiveData<ArrayList<Provinsi>> =
        MutableLiveData<ArrayList<Provinsi>>()

    fun getProvinsiFromJsonString(jsonString: String): ArrayList<Provinsi> {
        val listProvinsi = ArrayList<Provinsi>()
        val dataProvinsi: DataProvinsi = DataSource.createDataSetProvinsi(jsonString)
        dataProvinsi.data?.forEach {
            if (it != null) {
                listProvinsi.add(it)
            }
        }
        return listProvinsi
    }

    fun getProvinsiFromApi(): MutableLiveData<ArrayList<Provinsi>> {

        val api = NetworkConfig().api()

        api.getDataProvinsi().enqueue(object : Callback<DataProvinsi> {
            override fun onFailure(call: Call<DataProvinsi>, t: Throwable) {
                Log.d(this.javaClass.simpleName, "error : ${t.stackTrace}")
            }

            override fun onResponse(call: Call<DataProvinsi>, response: Response<DataProvinsi>) {
                val dataProvinsi = response.body()?.data
                mutableLiveData.value = dataProvinsi as ArrayList<Provinsi>?
            }
        })

        return mutableLiveData
    }
}
