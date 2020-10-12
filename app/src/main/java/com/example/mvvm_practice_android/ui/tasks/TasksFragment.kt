package com.example.mvvm_practice_android.ui.tasks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.mvvm_practice_android.R
import com.example.mvvm_practice_android.databinding.TasksFragmentBinding

class TasksFragment : Fragment() {

    companion object {
        fun newInstance() = TasksFragment()
    }

    private lateinit var viewModel: TasksViewModel
    private lateinit var binding: TasksFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = TasksViewModel()
        binding = DataBindingUtil.inflate(inflater, R.layout.tasks_fragment, container, false)
        binding.vm = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.testText = "この文字はデータバインディング対象になったviewModelにプログラム側からセットした文字ですよ。"
    }
}