package com.example.mvvm_practice_android.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.mvvm_practice_android.data.repository.SlackRepository
import com.example.mvvm_practice_android.data.response.ChannelListResponse
import io.reactivex.Single

class HomeViewModel : ViewModel() {

    private val slackRepository = SlackRepository()

    fun loadData(): Single<ChannelListResponse> {

        Log.i("sss", "in loadData")
        return slackRepository.getChannelList()
            .doOnSuccess{
                Log.i("sss", "success")
            }
            .doOnError {
                Log.e("sss","error!!")
            }
    }
}