package com.example.mvvm_practice_android.data.api

import com.example.mvvm_practice_android.data.response.ChannelListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface SlackService {

    @GET("api/conversations.list")
    fun getChannelList(
        @Query("token") accessToken: String
    ): Single<ChannelListResponse>
}