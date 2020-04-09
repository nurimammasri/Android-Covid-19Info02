package id.ac.unhas.infocovid19.model

import com.google.gson.annotations.SerializedName

data class DataProvinsi(
    @SerializedName("data")
    val data: List<Provinsi?>?
) {
    override fun toString(): String {
        var stringOutput = ""
        data?.forEach {
            stringOutput += it.toString()
        }
        return stringOutput
    }
}

data class Provinsi(
    @SerializedName("fid")
    val fid: Int?,

    val kasusMeni: Int?,

    @SerializedName("kasusPosi")
    val kasusPosi: Int?,

    @SerializedName("kasusSemb")
    val kasusSemb: Int?,

    @SerializedName("kodeProvi")
    val kodeProvi: Int?,

    @SerializedName("provinsi")
    val provinsi: String?
) {
    override fun toString(): String {
        return "Provinsi ${this.provinsi}[kode: ${this.kodeProvi}, #positif: ${this.kasusPosi}, #meninggal: ${this.kasusMeni}, #sembuh:${this.kasusSemb}]"
    }
}