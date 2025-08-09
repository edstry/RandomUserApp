package com.example.randomuserapp.presentation.navigation

import com.example.randomuserapp.domain.entity.User
import kotlinx.serialization.Serializable

@Serializable
data object UserListRoute

@Serializable
data class UserDetailRoute(val user: User)

