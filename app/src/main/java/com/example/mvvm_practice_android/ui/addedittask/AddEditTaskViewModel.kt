package com.example.mvvm_practice_android.ui.addedittask

import android.util.Log
import androidx.lifecycle.ViewModel

class AddEditTaskViewModel : ViewModel() {
    var title: String = ""

    fun saveTask() {
        // TODO 実際の保存処理はあとで書きます
        Log.i("in AddEditTaskFragment", "saveTaskまで呼べました。内容: ${title}")
    }
}