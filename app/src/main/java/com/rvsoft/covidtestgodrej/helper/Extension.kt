package com.rvsoft.covidtestgodrej.helper

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

fun String.toDate():Date?{
    val sdf = SimpleDateFormat("yyyy-mm-dd")
    return sdf.parse(this)
}