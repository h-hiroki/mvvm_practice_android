package com.example.mvvm_practice_android.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.mvvm_practice_android.data.repository.SlackRepository
import com.example.mvvm_practice_android.data.response.ChannelListResponse
import io.reactivex.Single

class HomeViewModel : ViewModel() {

    private val slackRepository = SlackRepository()

    fun loadData(): Single<ChannelListResponse> {

        return slackRepository.getChannelList()
            .doOnSuccess {
                Log.d("view model", "on success")
            }
            .doOnError {
                Log.d("view model", "on error")
            }
            .doFinally {
                Log.d("view model", "on finally")
            }
    }
}