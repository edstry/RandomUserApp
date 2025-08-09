package com.example.randomuserapp.presentation.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.randomuserapp.domain.entity.User
import com.google.gson.Gson

class NavigationState(
    val navHostController: NavHostController
) {

    fun navigateToUserDetail(user: User) {
        navHostController.navigate(UserDetailRoute(user = user))
    }

    /*
    fun navigateTo(route: String) {
        navHostController.navigate(route) {
            popUpTo(navHostController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
    */
}

@Composable
fun rememberNavigationState(
    navHostController: NavHostController = rememberNavController()
): NavigationState {
    return remember {
        NavigationState(navHostController)
    }
}

fun String.encode(): String {
    return Uri.encode(this)
}