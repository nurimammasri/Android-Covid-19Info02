package id.ac.unhas.infocovid19.model

data class DataHarian(
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

    val harike: String?,
    val tanggal: Long?,
    val jumlahKasusBaruperHari: Int?,
    val jumlahKasusKumulatif: Int?,
    val jumlahpasiendalamperawatan: Int?,
    val persentasePasiendalamPerawatan: Double?,
    val jumlahPasienSembuh: Int?,
    val persentasePasienSembuh: Double?,
    val jumlahPasienMeninggal: Int?,
    val persentasePasienMeninggal: Double?,
    val jumlahKasusSembuhperHari: Int?,
    val jumlahKasusMeninggalperHari: Int?,
    val jumlahKasusDirawatperHari: Int?,
    val fid: Int?
) {
    override fun toString(): String {
        return "Hari ke - ${this.harike}[tanggal: ${this.tanggal}, #Jumlah Kasus Baru Per Hari : ${this.jumlahKasusBaruperHari}, " +
                "#Jumlah Kasus Kumulatif: ${this.jumlahKasusKumulatif}, " +
                "#Jumlah Pasien Dalam Perawatan:${this.jumlahpasiendalamperawatan}, #Persentase Pasien Dalam Perawatan: ${this.persentasePasiendalamPerawatan}, " +
                "#jumlah Pasien Sembuh:${this.jumlahPasienSembuh}, #Persentase Pasien Sembuh: ${this.persentasePasienSembuh}, " +
                "#Jumlah Pasien Meninggal:${this.jumlahPasienMeninggal}, #Persentase Pasien Meninggal: ${this.persentasePasienMeninggal}, " +
                "#Jumlah Kasus Sembuh Per hari:${this.jumlahKasusSembuhperHari}, #Jumlah Kasus Meninggal Perhari: ${this.jumlahKasusMeninggalperHari}, #Jumlah Kasus Dirawat Per Hari:${this.jumlahKasusDirawatperHari}, " +
                "#fid: ${this.fid}]"
    }
}