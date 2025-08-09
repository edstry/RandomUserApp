package com.example.randomuserapp.data.network.api

import androidx.room.Query
import com.example.randomuserapp.data.network.dto.RequestResultContainer
import retrofit2.http.GET

interface ApiService {

    @GET("api/?results=10")
    suspend fun getUserList(): RequestResultContainer
}