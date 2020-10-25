package com.example.mvvm_practice_android.data.repository

import com.example.mvvm_practice_android.BuildConfig
import com.example.mvvm_practice_android.data.api.SlackService
import com.example.mvvm_practice_android.data.response.ChannelListResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class SlackRepository {

    companion object {
        const val SLACK_ACCESS_TOKEN = BuildConfig.SLACK_ACCESS_TOKEN
        const val BASE_URL = "https://slack.com"
    }

    val client = builderHttpClient()
    private fun builderHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            client.addInterceptor(logging)
        }

        return client.build()
    }

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(client)
        .build()

    private val api = retrofit.create(SlackService::class.java)

    fun getChannelList(): Single<ChannelListResponse> {
        return api.getChannelList(SLACK_ACCESS_TOKEN)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
