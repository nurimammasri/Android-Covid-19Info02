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
                    "\t\t-\ttanggal : ${itemHarian.tanggal}\n" +
                            "\t\t-\tJumlah Kasus Baru Per Hari : ${itemHarian.jumlahKasusBaruperHari}\n" +
                            "\t\t-\tJumlah Kasus Kumulatif : ${itemHarian.jumlahKasusKumulatif}\n" +
                            "\t\t-\tJumlah Pasien Dalam Perawatan : ${itemHarian.jumlahpasiendalamperawatan}\n" +
                            "\t\t-\tPersentase Pasien Dalam Perawatan : ${itemHarian.persentasePasiendalamPerawatan}\n" +
                            "\t\t-\tJumlah Pasien Sembuh : ${itemHarian.jumlahPasienSembuh}\n" +
                            "\t\t-\tPersentase Pasien Sembuh : ${itemHarian.persentasePasienSembuh}\n" +
                            "\t\t-\tJumlah Pasien Meninggal : ${itemHarian.jumlahPasienMeninggal}\n" +
                            "\t\t-\tPersentase Pasien Meninggal : ${itemHarian.persentasePasienMeninggal}\n" +
                            "\t\t-\tJumlah Kasus Sembuh Per hari : ${itemHarian.jumlahKasusSembuhperHari}\n" +
                            "\t\t-\tJumlah Kasus Meninggal Perhari : ${itemHarian.jumlahKasusMeninggalperHari}\n" +
                            "\t\t-\tJumlah KasusDirawat Per Hari : ${itemHarian.jumlahKasusDirawatperHari}\n"
                val hari = "Hari ke - ${itemHarian.harike}"
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
