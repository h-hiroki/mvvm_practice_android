package com.example.mvvm_practice_android.ui.addedittask

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.mvvm_practice_android.R
import com.example.mvvm_practice_android.databinding.AddEditTaskFragmentBinding

class AddEditTaskFragment : Fragment() {

    companion object {
        fun newInstance() = AddEditTaskFragment()
    }

    private lateinit var binding: AddEditTaskFragmentBinding
    private lateinit var viewModel: AddEditTaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = AddEditTaskViewModel()
        binding = DataBindingUtil.inflate(inflater, R.layout.add_edit_task_fragment, container, false)
        binding.viewModel = viewModel

        setAddTaskButton()
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.title = "初期にセット"
    }

    private fun setAddTaskButton() {
        binding.addTaskButton.setOnClickListener {
            viewModel.saveTask()
            Toast.makeText(context, "【${viewModel.title}】を保存しました", Toast.LENGTH_SHORT).show()
            activity?.finish()
        }
    }
}