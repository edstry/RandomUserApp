package com.example.randomuserapp.presentation.content.user_list

import com.example.randomuserapp.domain.entity.User

sealed interface UserListState {
    data class SuccessLoaded(
        val users: List<User>
    ) : UserListState

    data class ErrorLoading(
        val message: String
    ) : UserListState

    data object Loading : UserListState
    data object Initial : UserListState
}