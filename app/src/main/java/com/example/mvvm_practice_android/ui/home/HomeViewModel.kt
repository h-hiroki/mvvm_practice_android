package com.example.mvvm_practice_android.ui.home

import androidx.lifecycle.ViewModel
import com.example.mvvm_practice_android.data.repository.SlackRepository
import com.example.mvvm_practice_android.data.response.ChannelListResponse
import io.reactivex.Single

class HomeViewModel : ViewModel() {

    private val slackRepository = SlackRepository()
    var presidentTextView = "init text"

    fun loadData(): Single<ChannelListResponse> {
        // TODO 必要であればここでデータ加工を行う
        return slackRepository.getChannelList()
    }
}