package com.example.mvvm_practice_android.data.response

import com.example.mvvm_practice_android.data.model.Channel
import com.squareup.moshi.Json

data class ChannelListResponse(
    val ok: Boolean,
    val channels: List<Channel>,
    @Json(name = "response_metadata") val responseMetadata: String?
)