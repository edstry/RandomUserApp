package com.example.randomuserapp.data.repository

import android.util.Log
import com.example.randomuserapp.data.network.api.ApiService
import com.example.randomuserapp.data.network.dto.toEntity
import com.example.randomuserapp.domain.entity.User
import com.example.randomuserapp.domain.repository.UsersRepository
import com.example.randomuserapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : UsersRepository {


    private val loadUsers: Flow<Resource<List<User>>> = flow {
        try {
            emit(Resource.Loading())
            val users = apiService.getUserList().userDtos.map { it.toEntity() }
            emit(Resource.Success(data = users))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Could`t reach server. Check your internet connection"))
        }
    }

    override fun getUserList() = loadUsers
}