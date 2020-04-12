package id.ac.unhas.infocovid19.ui.perkasus

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
import id.ac.unhas.infocovid19.model.PerKasus


class PerkasusListFragment : Fragment() {
    private lateinit var viewModel: PerkasusViewModel
    private lateinit var viewModelFactory: PerkasusViewModelFactory
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var recyclerView: RecyclerView

    companion object {
        fun newInstance() = PerkasusListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModelFactory = PerkasusViewModelFactory(PerkasusRepository())
        viewModel = ViewModelProvider(this, viewModelFactory).get(PerkasusViewModel::class.java)
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

        viewModel.getPerkasus()
            .observe(viewLifecycleOwner, Observer<ArrayList<PerKasus>> { dataPerkasus ->
                recyclerView.adapter = PerkasusAdapter(toListofData(dataPerkasus))

            })
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


}




