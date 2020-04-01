package id.ac.unhas.infocovid19.ui.perkasus

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


class PerkasusListFragment : Fragment() {

    companion object {
        fun newInstance() = PerkasusListFragment()
    }

    private lateinit var viewModel: PerkasusViewModel
    private lateinit var viewModelFactory: PerkasusViewModelFactory

    private lateinit var linearLayoutManager: LinearLayoutManager

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
        val jsonList: String =
            activity?.applicationContext?.let {
                DataSource.getJsonDataFromAsset(it, "perkasus.json")
            }.toString()

        val perkasusRepository = PerkasusRepository(jsonList)

        viewModelFactory = PerkasusViewModelFactory(perkasusRepository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(PerkasusViewModel::class.java)

        viewModel.getDataFromRepo()

        Log.d("MainFragment", "createView")

        linearLayoutManager = LinearLayoutManager(context)
        recyclerview.layoutManager = linearLayoutManager

        val adapter = PerkasusAdapter(viewModel.kasus)

        recyclerview.adapter = adapter

    }

}
