package com.example.randomuserapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.randomuserapp.domain.entity.User
import kotlin.reflect.typeOf


@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    userListContent: @Composable () -> Unit,
    userDetailContent: @Composable (User) -> Unit
) {
    NavHost(
        navController = navHostController,
        startDestination = UserListRoute
    ) {
        composable<UserListRoute> {
            userListContent()
        }

        composable<UserDetailRoute>(
            typeMap = mapOf(
                typeOf<User>() to User.UserType
            )
        ) {
            val arguments = it.toRoute<UserDetailRoute>()
            userDetailContent(arguments.user)
        }
    }
}