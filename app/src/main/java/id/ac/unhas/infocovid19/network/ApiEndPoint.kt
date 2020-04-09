package id.ac.unhas.infocovid19.network

import id.ac.unhas.infocovid19.model.DataHarian
import id.ac.unhas.infocovid19.model.DataPerkasus
import id.ac.unhas.infocovid19.model.DataProvinsi
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndPoint {
    @GET("provinsi")
    fun getDataProvinsi(): Call<DataProvinsi>

    @GET("kasus")
    fun getDataPerkasus(): Call<DataPerkasus>

    @GET("harian")
    fun getDataHarian(): Call<DataHarian>
}