package id.ac.unhas.infocovid19.ui.provinsi

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
import id.ac.unhas.infocovid19.model.DataProvinsi
import id.ac.unhas.infocovid19.model.Provinsi
import id.ac.unhas.infocovid19.network.ApiEndPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProvinsiListFragment : Fragment() {

    companion object {
        fun newInstance() = ProvinsiListFragment()
    }

    private lateinit var viewModel: ProvinsiViewModel
    private lateinit var viewModelFactory: ProvinsiViewModelFactory

    private lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.provinsilist_fragment, container, false)
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

        apiEndPoint.getDataProvinsi().enqueue(object : Callback<DataProvinsi> {
            override fun onFailure(call: Call<DataProvinsi>, t: Throwable) {
                Log.e(this::class.java.simpleName, "Error: ${t.printStackTrace()}")
            }

            override fun onResponse(call: Call<DataProvinsi>, response: Response<DataProvinsi>) {
                val dataProvinsi = response.body()?.data

                val adapter = ProvinsiAdapter(toListofData(dataProvinsi))

                recyclerView.adapter = adapter

            }

            private fun toListofData(dataProvinsi: List<Provinsi?>?): ArrayList<Provinsi> {
                val listProvinsi = ArrayList<Provinsi>()
                dataProvinsi?.forEach {
                    if (it != null) {
                        listProvinsi.add(it)
                    }
                }
                return listProvinsi
            }
        })

    }
}
