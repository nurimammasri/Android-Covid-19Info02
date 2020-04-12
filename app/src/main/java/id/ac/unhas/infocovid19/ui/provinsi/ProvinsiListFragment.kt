package id.ac.unhas.infocovid19.ui.provinsi

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.unhas.infocovid19.R
import id.ac.unhas.infocovid19.model.Provinsi

class ProvinsiListFragment : Fragment() {
    private lateinit var viewModel: ProvinsiViewModel
    private lateinit var viewModelFactory: ProvinsiViewModelFactory
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var recyclerView: RecyclerView

    companion object {
        fun newInstance() = ProvinsiListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModelFactory = ProvinsiViewModelFactory(ProvinsiRepository())
        viewModel = ViewModelProvider(this, viewModelFactory).get(ProvinsiViewModel::class.java)
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

        viewModel.getProvinsi()
            .observe(viewLifecycleOwner, Observer<ArrayList<Provinsi>> { dataProvinsi ->
                val adapter = ProvinsiAdapter(toListofData(dataProvinsi))
                recyclerView.adapter = adapter
                adapter.notifyDataSetChanged()
            })

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
}
