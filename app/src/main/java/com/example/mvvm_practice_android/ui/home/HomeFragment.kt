package com.example.mvvm_practice_android.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.mvvm_practice_android.R
import com.example.mvvm_practice_android.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var binding: HomeFragmentBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        viewModel = HomeViewModel()
        binding.viewModel = viewModel

        // TODO disposeしなくても良いのかな？確認しておくこと
        viewModel.loadData()
            .subscribe(
                {
                    Log.i("fragment", "on success")
                    binding.viewModel?.presidentTextView?.set(it.channels[1].name.toString())
                    Log.i("fragment", "on success end.")
                },
                { throw it }
            )

        return binding.root
    }

    override fun onResume() {
        super.onResume()
    }
}