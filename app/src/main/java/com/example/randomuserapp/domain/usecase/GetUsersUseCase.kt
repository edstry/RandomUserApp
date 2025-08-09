package com.example.randomuserapp.domain.usecase


import com.example.randomuserapp.domain.entity.User
import com.example.randomuserapp.domain.repository.UsersRepository
import com.example.randomuserapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: UsersRepository
) {
    operator fun invoke(): Flow<Resource<List<User>>> {
        return repository.getUserList()
    }
}