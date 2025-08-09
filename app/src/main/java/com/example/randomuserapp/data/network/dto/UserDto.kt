package com.example.randomuserapp.data.network.dto

import com.example.randomuserapp.domain.entity.User
import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("id")
    val idDto: IdDto,

    @SerializedName("cell")
    val cell: String,

    @SerializedName("dob")
    val dobDto: DobDto,

    @SerializedName("email")
    val email: String,

    @SerializedName("gender")
    val gender: String,

    @SerializedName("location")
    val locationDto: LocationDto,

    @SerializedName("login")
    val loginDto: LoginDto,

    @SerializedName("name")
    val nameDto: NameDto,

    @SerializedName("nat")
    val nat: String,

    @SerializedName("phone")
    val phone: String,

    @SerializedName("picture")
    val pictureDto: PictureDto,

    @SerializedName("registered")
    val registeredDto: RegisteredDto
)

fun UserDto.toEntity(): User {
    return User(
        id = idDto.value,
        fio = "${nameDto.title} ${nameDto.first} ${nameDto.last}",
        age = dobDto.age,
        date = dobDto.date,
        imageUrl = pictureDto.large,
        address = "${locationDto.country}, ${locationDto.state}, ${locationDto.city} ${locationDto.street.name} ${locationDto.street.number}",
        email = email,
        phone = phone,
        gender = gender,
        username = loginDto.username,
        password = loginDto.password
    )
}



