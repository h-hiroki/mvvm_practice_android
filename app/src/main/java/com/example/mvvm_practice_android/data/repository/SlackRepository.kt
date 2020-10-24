package com.example.mvvm_practice_android.data.repository

import android.util.Log
import com.example.mvvm_practice_android.BuildConfig
import com.example.mvvm_practice_android.data.api.SlackService
import com.example.mvvm_practice_android.data.response.ChannelListResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class SlackRepository {

    companion object {
        const val SLACK_ACCESS_TOKEN = BuildConfig.SLACK_ACCESS_TOKEN
        const val BASE_URL = "https://slack.com"
    }

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    private val api = retrofit.create(SlackService::class.java)

    fun getChannelList(): Single<ChannelListResponse> {
        Log.i("slack repository", "in channel list")
        return api.getChannelList(SLACK_ACCESS_TOKEN)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess {
                Log.d("slack repository", "in do on success")
            }
    }
}
