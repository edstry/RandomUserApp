package com.example.randomuserapp.domain.entity

import android.net.Uri
import androidx.navigation.NavType
import androidx.savedstate.SavedState
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class User(
    val id: String?,
    val fio: String,
    val age: String,
    val date: String,
    val imageUrl: String,
    val address: String,
    val email: String,
    val phone: String,
    val gender: String,
    val username: String,
    val password: String,
) {
    companion object {
        val UserType = object : NavType<User>(false) {
            override fun put(
                bundle: SavedState,
                key: String,
                value: User
            ) {
                bundle.putString(key, Json.encodeToString(value))
            }

            override fun get(
                bundle: SavedState,
                key: String
            ): User? {
                return Json.decodeFromString(bundle.getString(key) ?: return null)
            }

            override fun parseValue(value: String): User {
                return Json.decodeFromString(Uri.decode(value))
            }

            override fun serializeAsValue(value: User): String {
                return Uri.encode(Json.encodeToString(value))
            }
        }
    }
}
