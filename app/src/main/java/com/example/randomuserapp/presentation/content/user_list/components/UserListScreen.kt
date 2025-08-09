package com.example.randomuserapp.presentation.content.user_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.randomuserapp.domain.entity.User
import com.example.randomuserapp.presentation.content.user_list.UsersViewModel
import com.example.randomuserapp.presentation.ui.theme.BgUsersColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserListScreen(
    users: List<User>,
    onItemClickListener: (User) -> Unit,
    viewModel: UsersViewModel
) {
    val isRefreshing = remember {
        mutableStateOf(false)
    }
    PullToRefreshBox(
        isRefreshing = isRefreshing.value,
        onRefresh = {
            viewModel.getUsers()
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            items(users) {
                UserCard(
                    user = it,
                    onItemClickListener = onItemClickListener
                )
            }
        }
    }
}


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun UserCard(
    user: User,
    onItemClickListener: (User) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable { onItemClickListener(user) },
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(containerColor = BgUsersColor)
    ) {
        Row(
            verticalAlignment = Alignment.Top
        ) {
            GlideImage(
                modifier = Modifier.size(140.dp),
                model = user.imageUrl,
                contentDescription = null,
                loading = placeholder {
                    Box(modifier = Modifier.fillMaxSize()) {
                        CircularProgressIndicator(
                            modifier = Modifier.align(Alignment.Center),
                            color = Color.White
                        )
                    }
                }
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier.padding(end = 10.dp, top = 10.dp)
            ) {
                Text(
                    text = user.fio,
                    fontSize = 13.sp,
                    color = Color.White
                )
                Text(
                    text = user.phone,
                    fontSize = 13.sp,
                    color = Color.White
                )
                Text(
                    text = user.address,
                    fontSize = 13.sp,
                    color = Color.White
                )
            }

        }
    }
}
