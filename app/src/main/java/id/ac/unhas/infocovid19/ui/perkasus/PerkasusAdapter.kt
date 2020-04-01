package id.ac.unhas.infocovid19.ui.perkasus

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ac.unhas.infocovid19.R
import id.ac.unhas.infocovid19.model.PerKasus
import kotlinx.android.synthetic.main.recyclerview_item_perkasus.view.*

class PerkasusAdapter(private val daftarPerkasus: ArrayList<PerKasus>) :
    RecyclerView.Adapter<PerkasusAdapter.PerkasusHolder>() {
    class PerkasusHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(itemPerkasus: PerKasus) {
            with(itemView) {
                val desc =
                    " Kode Pasien : ${(itemPerkasus.kode_pasien) ?: "-"}\n Jenis Kelamin : ${when ((itemPerkasus.jenis_kelamin)) {
                        "P" -> "Perempuan"
                        "L" -> "Laki - Laki"
                        else -> "-"
                    }}\n " +
                            "Umur : ${(itemPerkasus.umur) ?: "-"}\n Keterangan : ${(itemPerkasus.keterangan) ?: "-"}\n Keterangan Status : ${(itemPerkasus.keterangan_status) ?: "-"}\n " +
                            "Warga Negara : ${(itemPerkasus.detail_wn) ?: "-"}\n Hasil Lab : ${(itemPerkasus.hasil_lab) ?: "-"}"
                val pasien = "Pasien ke - ${(itemPerkasus.id_pasien) ?: "-"}"
                pasienke.text = pasien
                data_pasien.text = desc
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PerkasusAdapter.PerkasusHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.recyclerview_item_perkasus, parent, false
        )
        return PerkasusHolder(view)
    }

    override fun getItemCount() = daftarPerkasus.size

    override fun onBindViewHolder(holder: PerkasusAdapter.PerkasusHolder, position: Int) {
        holder.bind(daftarPerkasus[position])
    }

}
