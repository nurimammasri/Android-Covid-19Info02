package id.ac.unhas.infocovid19.model

data class DataPerkasus(
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

    val id_pasien: Int?,
    val hasil_lab: String?,
    val kode_pasien: Int?,
    val provinsi: Int?,
    val long: Double?,
    val lat: Double?,
    val jenis_kelamin: String?,
    val umur: Int?,
    val cluster: Int?,
    val keterangan: String?,
    val status_pasien: Int?,
    val keterangan_status: String?,
    val wn: Int?,
    val detail_wn: String?,
    val jenis_kasus: Int?,
    val tampilkan: Int?,
    val added_date: String?,
    val garis_penularan: String?
) {
    override fun toString(): String {
        return "Pasien ke -${this.id_pasien}[#hasil lab: ${this.hasil_lab}, #kode pasien: ${this.kode_pasien}, " +
                "#provinsi: ${this.provinsi}, #long:${this.long}, #lat: ${this.lat}, #jeniskelamin:${this.jenis_kelamin},  " +
                "#umur: ${this.umur}, #cluster:${this.cluster}, #keterangan: ${this.keterangan}, #status pasien:${this.status_pasien}" +
                "#keterangan status: ${this.keterangan_status}, #wn:${this.wn}, #detail wn: ${this.detail_wn}, #jenis kasus:${this.jenis_kasus}" +
                "#tampilkan: ${this.tampilkan}, #added date:${this.added_date}, #garis penularan: ${this.garis_penularan}]"
    }
}