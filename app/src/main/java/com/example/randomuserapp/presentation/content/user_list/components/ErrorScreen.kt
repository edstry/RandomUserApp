package com.example.randomuserapp.presentation.content.user_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.randomuserapp.presentation.content.user_list.UsersViewModel
import com.example.randomuserapp.presentation.ui.theme.BgUsersColor
import com.example.randomuserapp.presentation.ui.theme.PurpleGrey40
import java.nio.file.WatchEvent

@Composable
fun ErrorScreen(
    error: String,
    viewModel: UsersViewModel
) {
    Box(
        modifier = Modifier
            .background(BgUsersColor)
            .fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = error,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(15.dp))
            Button(
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = PurpleGrey40),
                onClick = { viewModel.getUsers() }
            ) {
                Text(text = "update", color = Color.White)
            }
        }
    }
}