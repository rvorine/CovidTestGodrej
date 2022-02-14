package com.rvsoft.covidtestgodrej.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rvsoft.covidtestgodrej.data.model.Dashboard
import javax.inject.Inject

@Database(
    version = 1,
    entities = [Dashboard::class]
)
abstract class AppDataBase :RoomDatabase() {
    abstract fun dashboardDao():DbDao
}