package com.example.randomuserapp.presentation.content.user_detail

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.randomuserapp.R
import com.example.randomuserapp.domain.entity.User
import com.example.randomuserapp.presentation.ui.theme.BgUsersColor
import com.example.randomuserapp.presentation.ui.theme.LabelColor
import com.example.randomuserapp.utils.ext.toDate
import java.nio.file.WatchEvent
import androidx.core.net.toUri

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun UserDetailContent(user: User) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(BgUsersColor),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(10.dp),
    ) {
        item {
            GlideImage(
                contentScale = ContentScale.Crop,
                model = user.imageUrl,
                contentDescription = null,
            )
        }
        item {
            Column {
                Text(
                    text = stringResource(R.string.label_name),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = LabelColor
                )
                Text(
                    text = user.fio,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
        }
        item {
            val dialerLauncher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.StartActivityForResult()
            ) {
                Log.d("resultphone", it.resultCode.toString())
            }
            Column(
                modifier = Modifier.clickable {
                    val intent = Intent(Intent.ACTION_DIAL).apply {
                        data = "tel:${user.phone}".toUri()
                    }
                    dialerLauncher.launch(intent)
                }
            ) {
                Text(
                    text = stringResource(R.string.label_phone),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = LabelColor
                )
                Text(
                    text = user.phone,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
        }
        item {
            Column {
                Text(
                    text = stringResource(R.string.label_age),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = LabelColor
                )
                Text(
                    text = user.age,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
        }
        item {
            val addressLauncher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.StartActivityForResult()
            ) { }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                    val intent = Intent(Intent.ACTION_VIEW).apply {
                        data = "geo:0,0?q=${user.address}".toUri()
                    }
                    addressLauncher.launch(intent)
                }
            ) {
                Text(
                    text = stringResource(R.string.label_address),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = LabelColor
                )
                Text(
                    text = user.address,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
        }
        item {
            val mailLauncher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.StartActivityForResult()
            ) { }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        val intent = Intent(Intent.ACTION_SENDTO).apply {
                            data = "mailto:${user.email}".toUri()
                        }
                        mailLauncher.launch(intent)
                    }
            ) {
                Text(
                    text = stringResource(R.string.label_email),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = LabelColor
                )
                Text(
                    text = user.email,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
        }
        item {
            Column {
                Text(
                    text = stringResource(R.string.label_date),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = LabelColor
                )
                Text(
                    text = user.date.toDate(),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
        }
        item {
            Column {
                Text(
                    text = stringResource(R.string.label_gender),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = LabelColor
                )
                Text(
                    text = user.gender,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
        }
        item {
            Column {
                Text(
                    text = stringResource(R.string.label_username),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = LabelColor
                )
                Text(
                    text = user.username,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
        }
        item {
            Column {
                Text(
                    text = stringResource(R.string.label_password),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = LabelColor
                )
                Text(
                    text = user.password,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
        }
    }
}