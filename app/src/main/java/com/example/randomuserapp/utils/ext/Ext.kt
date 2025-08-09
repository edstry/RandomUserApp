package com.example.randomuserapp.utils.ext

import java.time.Instant
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import kotlin.time.ExperimentalTime


@OptIn(ExperimentalTime::class)
fun String.toDate(): String {
    val instant = Instant.parse(this)
    val zdUtc = ZonedDateTime.ofInstant(instant, ZoneOffset.UTC)
    val formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy")
    return zdUtc.format(formatter)
}