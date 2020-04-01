package id.ac.unhas.infocovid19.ui.harian

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.unhas.infocovid19.R
import id.ac.unhas.infocovid19.model.DataSource
import kotlinx.android.synthetic.main.perkasuslist_fragment.*


class HarianListFragment : Fragment() {

    companion object {
        fun newInstance() = HarianListFragment()
    }

    private lateinit var viewModel: HarianViewModel
    private lateinit var viewModelFactory: HarianViewModelFactory

    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.harianlist_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val jsonList: String =
            activity?.applicationContext?.let {
                DataSource.getJsonDataFromAsset(it, "harian.json")
            }.toString()

        val harianRepository = HarianRepository(jsonList)

        viewModelFactory = HarianViewModelFactory(harianRepository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(HarianViewModel::class.java)

        viewModel.getDataFromRepo()

        Log.d("MainFragment", "createView")

        linearLayoutManager = LinearLayoutManager(context)
        recyclerview.layoutManager = linearLayoutManager

        val adapter = HarianAdapter(viewModel.dataharian)

        recyclerview.adapter = adapter

    }

}
