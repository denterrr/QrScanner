package com.example.scanner.presentation.history

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.scanner.R
import com.example.scanner.databinding.FragmentHistoryBinding
import com.example.scanner.di.DaggerScanComponent
import com.example.scanner.domain.models.HistoryModel
import moxy.MvpFragment
import javax.inject.Inject

class HistoryFragment : Fragment() {

    lateinit var binding: FragmentHistoryBinding
    lateinit var rv: RecyclerView
    lateinit var adapter: HistoryAdapter

    @Inject
    lateinit var viewModel: HistoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val comp = DaggerScanComponent.builder()
            .context(requireContext())
            .build()
        comp.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentHistoryBinding.inflate(layoutInflater,container,false)
        rv = binding.rv
        adapter = HistoryAdapter()
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getHistory().observe(viewLifecycleOwner, Observer {
            if(it.isNotEmpty()){
                binding.tvNet.visibility = View.GONE
                adapter.setList(it.asReversed())
            }
        })
    }


}