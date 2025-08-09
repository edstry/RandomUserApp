package com.example.randomuserapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.randomuserapp.presentation.navigation.AppNavGraph
import com.example.randomuserapp.presentation.navigation.rememberNavigationState
import com.example.randomuserapp.presentation.ui.theme.RandomUserAppTheme
import com.example.randomuserapp.presentation.content.user_detail.UserDetailContent
import com.example.randomuserapp.presentation.content.user_list.UsersScreenContent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            RandomUserAppTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navigationState = rememberNavigationState()
    AppNavGraph(
        navHostController = navigationState.navHostController,
        userListContent = {
            UsersScreenContent(
                onItemClickListener = { navigationState.navigateToUserDetail(it) }
            )
        },
        userDetailContent = { user ->
            UserDetailContent(user = user)
        }
    )
}