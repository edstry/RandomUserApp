package com.example.randomuserapp.presentation.content.user_list

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.randomuserapp.domain.entity.User
import com.example.randomuserapp.presentation.content.user_list.components.ErrorScreen
import com.example.randomuserapp.presentation.content.user_list.components.LoadingScreen
import com.example.randomuserapp.presentation.content.user_list.components.UserListScreen

@Composable
fun UsersScreenContent(
    viewModel: UsersViewModel = hiltViewModel(),
    onItemClickListener: (User) -> Unit
) {
    val state = viewModel.state.collectAsState()
    when(val currentState = state.value) {
        is UserListState.ErrorLoading -> {
            ErrorScreen(
                error = currentState.message,
                viewModel = viewModel
            )
        }
        UserListState.Loading -> {
            LoadingScreen()
        }
        is UserListState.SuccessLoaded -> {
            UserListScreen(
                users = currentState.users,
                onItemClickListener = onItemClickListener,
                viewModel
            )
        }
        UserListState.Initial -> {}
    }
}