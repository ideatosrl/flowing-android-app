package it.flowing.app.ui
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import it.flowing.app.R
import it.flowing.app.databinding.OverviewFragmentBinding
import it.flowing.app.ui.detail.DetailFragmentArgs

class OverviewFragment : Fragment() {

    companion object {
        fun newInstance() = OverviewFragment()
    }

    private val viewModel: OverviewViewModel by lazy {
        ViewModelProvider(this).get(OverviewViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        val binding = OverviewFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.contentsRecycler.adapter = ContentsAdapter {
            val action = OverviewFragmentDirections.actionOverviewFragmentToDetailsFragment(it, it.title)
            findNavController().navigate(action)
        }
        return binding.root
    }
}
