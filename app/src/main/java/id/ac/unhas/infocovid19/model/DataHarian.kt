package id.ac.unhas.infocovid19.model

import com.google.gson.annotations.SerializedName

data class DataHarian(
    @SerializedName("data")
    val data: List<Harian?>?
) {
    override fun toString(): String {
        var stringOutput = ""
        data?.forEach {
            stringOutput += it.toString()
        }
        return stringOutput
    }
}

data class Harian(

    @SerializedName("harike")
    val harike: Int?,

    @SerializedName("jumlahKasusBaruperHari")
    val jumlahKasusBaruperHari: Int?,

    @SerializedName("jumlahKasusDirawatperHari")
    val jumlahKasusDirawatperHari: Int?,

    @SerializedName("jumlahKasusKumulatif")
    val jumlahKasusKumulatif: Int?,

    @SerializedName("jumlahKasusMeninggalperHari")
    val jumlahKasusMeninggalperHari: Int?,

    @SerializedName("jumlahKasusSembuhperHari")
    val jumlahKasusSembuhperHari: Int?,

    @SerializedName("jumlahPasienMeninggal")
    val jumlahPasienMeninggal: Int?,

    @SerializedName("jumlahPasienSembuh")
    val jumlahPasienSembuh: Int?,

    @SerializedName("jumlahpasiendalamperawatan")
    val jumlahpasiendalamperawatan: Int?,

    @SerializedName("persentasePasienMeninggal")
    val persentasePasienMeninggal: Double?,

    @SerializedName("persentasePasienSembuh")
    val persentasePasienSembuh: Double?,

    @SerializedName("persentasePasiendalamPerawatan")
    val persentasePasiendalamPerawatan: Double?,

    @SerializedName("tanggal")
    val tanggal: Long?,

    @SerializedName("fid")
    val fid: Int?
) {
    override fun toString(): String {
        return "Hari ke - ${this.harike}[tanggal: ${this.tanggal}, " +
                "#Jumlah Kasus Baru Per Hari : ${this.jumlahKasusBaruperHari}, " +
                "#Jumlah Kasus Kumulatif: ${this.jumlahKasusKumulatif}, " +
                "#Jumlah Pasien Dalam Perawatan:${this.jumlahpasiendalamperawatan}, " +
                "#Persentase Pasien Dalam Perawatan: ${this.persentasePasiendalamPerawatan}, " +
                "#jumlah Pasien Sembuh:${this.jumlahPasienSembuh}, " +
                "#Persentase Pasien Sembuh: ${this.persentasePasienSembuh}, " +
                "#Jumlah Pasien Meninggal:${this.jumlahPasienMeninggal}, " +
                "#Persentase Pasien Meninggal: ${this.persentasePasienMeninggal}, " +
                "#Jumlah Kasus Sembuh Per hari:${this.jumlahKasusSembuhperHari}, " +
                "#Jumlah Kasus Meninggal Perhari: ${this.jumlahKasusMeninggalperHari}, " +
                "#Jumlah Kasus Dirawat Per Hari:${this.jumlahKasusDirawatperHari}, "
    }
}