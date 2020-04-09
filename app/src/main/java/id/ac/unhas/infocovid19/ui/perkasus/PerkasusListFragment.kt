package id.ac.unhas.infocovid19.ui.perkasus

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.unhas.infocovid19.BuildConfig
import id.ac.unhas.infocovid19.R
import id.ac.unhas.infocovid19.model.DataPerkasus
import id.ac.unhas.infocovid19.model.PerKasus
import id.ac.unhas.infocovid19.network.ApiEndPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PerkasusListFragment : Fragment() {

    companion object {
        fun newInstance() = PerkasusListFragment()
    }

    private lateinit var viewModel: PerkasusViewModel
    private lateinit var viewModelFactory: PerkasusViewModelFactory

    private lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.perkasuslist_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        Log.d("MainFragment", "createView")

        linearLayoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerview)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.setHasFixedSize(true)

        val builder = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
        val retrofit = builder.build()

        var apiEndPoint = retrofit.create(ApiEndPoint::class.java)

        apiEndPoint.getDataPerkasus().enqueue(object : Callback<DataPerkasus> {
            override fun onFailure(call: Call<DataPerkasus>, t: Throwable) {
                Log.e(this::class.java.simpleName, "Error: ${t.printStackTrace()}")
            }

            override fun onResponse(call: Call<DataPerkasus>, response: Response<DataPerkasus>) {
                val dataPerkasus = response.body()?.data

                val adapter = PerkasusAdapter(toListofData(dataPerkasus))

                recyclerView.adapter = adapter

            }

            private fun toListofData(dataPerkasus: List<PerKasus?>?): ArrayList<PerKasus> {
                val listPerkasus = ArrayList<PerKasus>()
                dataPerkasus?.forEach {
                    if (it != null) {
                        listPerkasus.add(it)
                    }
                }
                return listPerkasus
            }
        })

    }
}
