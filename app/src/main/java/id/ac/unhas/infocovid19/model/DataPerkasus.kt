package id.ac.unhas.infocovid19.model

import com.google.gson.annotations.SerializedName

data class DataPerkasus(
    @SerializedName("data")
    val data: List<PerKasus?>?
) {
    override fun toString(): String {
        var stringOutput = ""
        data?.forEach {
            stringOutput += it.toString()
        }
        return stringOutput
    }
}

data class PerKasus(

    @SerializedName("id_pasien")
    val id_pasien: Int?,

    @SerializedName("id_lab")
    val id_lab: Int?,

    @SerializedName("kode_pasien")
    val kode_pasien: Int?,

    @SerializedName("long")
    val long: Any?,

    @SerializedName("lat")
    val lat: Any?,

    @SerializedName("jenis_kelamin")
    val jenis_kelamin: Int?,

    @SerializedName("umur")
    val umur: Int?,

    @SerializedName("id_cluster")
    val id_cluster: Any?,

    @SerializedName("keterangan")
    val keterangan: String?,

    @SerializedName("id_status")
    val id_status: Int?,

    @SerializedName("keterangan_status")
    val keterangan_status: String?,

    @SerializedName("wn")
    val wn: Int?,

    @SerializedName("detail_wn")
    val detail_wn: String?,

    @SerializedName("id_kasus")
    val id_kasus: Any?,

    @SerializedName("tampilkan")
    val tampilkan: Int?,

    @SerializedName("added_date")
    val added_date: String?,

    @SerializedName("garis_penularan")
    val garis_penularan: Int?,

    @SerializedName("provinsi")
    val provinsi: Int?
) {
    override fun toString(): String {
        return "Pasien ke -${this.id_pasien}[" +
                "#hasil lab: ${when (this.id_lab) {
                    1 -> "positif"
                    else -> "-"
                }}, " +
                "#kode pasien: ${this.kode_pasien ?: "-"}, " +
                "#provinsi: ${this.provinsi ?: "-"}, " +
                "#jeniskelamin:${when (this.jenis_kelamin) {
                    0 -> "Perempuan"
                    1 -> "Laki - Laki"
                    else -> "-"
                }},  " +
                "#umur: ${this.umur ?: "-"}, " +
                "#keterangan: ${this.keterangan ?: "-"}, " +
                "#status pasien:${when (this.id_status) {
                    0 -> "meninggal"
                    1 -> "sembuh"
                    2 -> "masih dirawat"
                    else -> "-"
                }
                }" +
                "#keterangan status: ${this.keterangan_status ?: "-"}, " +
                "#wn:${this.wn ?: "-"}, " +
                "#detail wn: ${this.detail_wn ?: "-"}, " +
                "#tampilkan: ${this.tampilkan ?: "-"}, " +
                "#added date:${this.added_date ?: "-" ?: "-"}, " +
                "#garis penularan: ${this.garis_penularan ?: "-"}]"
    }
}