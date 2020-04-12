package id.ac.unhas.infocovid19.ui.harian

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
import id.ac.unhas.infocovid19.model.Harian


class HarianListFragment : Fragment() {

    private lateinit var viewModel: HarianViewModel
    private lateinit var viewModelFactory: HarianViewModelFactory
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var recyclerView: RecyclerView

    companion object {
        fun newInstance() = HarianListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModelFactory = HarianViewModelFactory(HarianRepository())
        viewModel = ViewModelProvider(this, viewModelFactory).get(HarianViewModel::class.java)
        return inflater.inflate(R.layout.harianlist_fragment, container, false)
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

        viewModel.getHarian()
            .observe(viewLifecycleOwner, Observer<ArrayList<Harian>> { dataHarian ->
                recyclerView.adapter = HarianAdapter(toListofData(dataHarian))

            })

    }

    private fun toListofData(dataHarian: List<Harian?>?): ArrayList<Harian> {
        val listHarian = ArrayList<Harian>()
        dataHarian?.forEach {
            if (it != null) {
                listHarian.add(it)
            }
        }
        return listHarian
    }
}
