package com.example.randomuserapp.data.network.dto

import com.google.gson.annotations.SerializedName

data class RequestResultContainer(
    @SerializedName("info")
    val info: Info,

    @SerializedName("results")
    val userDtos: List<UserDto>
)