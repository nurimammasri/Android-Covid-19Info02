package id.ac.unhas.infocovid19.ui.harian

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ac.unhas.infocovid19.R
import id.ac.unhas.infocovid19.model.Harian
import kotlinx.android.synthetic.main.recyclerview_item_harian.view.*

class HarianAdapter(private val daftarHarian: ArrayList<Harian>) :
    RecyclerView.Adapter<HarianAdapter.HarianHolder>() {
    class HarianHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(itemHarian: Harian) {
            with(itemView) {
                val desc =
                    "   -  tanggal : ${itemHarian.tanggal}\n   -  Jumlah Kasus Baru Per Hari : ${itemHarian.jumlahKasusBaruperHari}\n   -  Jumlah Kasus Kumulatif : ${itemHarian.jumlahKasusKumulatif}\n   -  " +
                            "Jumlah Pasien Dalam Perawatan : ${itemHarian.jumlahpasiendalamperawatan}\n   -  Persentase Pasien Dalam Perawatan : ${itemHarian.persentasePasiendalamPerawatan}\n   -  Jumlah Pasien Sembuh : ${itemHarian.jumlahPasienSembuh}\n   -  " +
                            "Persentase Pasien Sembuh : ${itemHarian.persentasePasienSembuh}\n   -  Jumlah Pasien Meninggal : ${itemHarian.jumlahPasienMeninggal}\n   -  Persentase Pasien Meninggal : ${itemHarian.persentasePasienMeninggal}\n   -  " +
                            "Jumlah Kasus Sembuh Per hari : ${itemHarian.jumlahKasusSembuhperHari}\n   -  Jumlah Kasus Meninggal Perhari : ${itemHarian.jumlahKasusMeninggalperHari}\n   -  Jumlah KasusDirawat Per Hari : ${itemHarian.jumlahKasusDirawatperHari}\n"
                val hari = "Hari ke -  ${itemHarian.harike}"
                harike.text = hari
                data_harian.text = desc
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HarianAdapter.HarianHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.recyclerview_item_harian, parent, false
        )
        return HarianHolder(view)
    }

    override fun getItemCount() = daftarHarian.size

    override fun onBindViewHolder(holder: HarianAdapter.HarianHolder, position: Int) {
        holder.bind(daftarHarian[position])
    }

}
