package com.example.randomuserapp.domain.repository

import com.example.randomuserapp.data.network.dto.RequestResultContainer
import com.example.randomuserapp.domain.entity.User
import com.example.randomuserapp.utils.Resource
import kotlinx.coroutines.flow.Flow

interface UsersRepository {
    fun getUserList(): Flow<Resource<List<User>>>
}