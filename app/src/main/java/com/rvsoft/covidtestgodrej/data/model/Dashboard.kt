package com.rvsoft.covidtestgodrej.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Dashboard")
data class Dashboard(
    @PrimaryKey(autoGenerate = true) var id:Int = 0,
    val dailyconfirmed: String,
    val dailydeceased: String,
    val dailyrecovered: String,
    val date: String,
    val dateymd: String,
    val totalconfirmed: String,
    val totaldeceased: String,
    val totalrecovered: String
)