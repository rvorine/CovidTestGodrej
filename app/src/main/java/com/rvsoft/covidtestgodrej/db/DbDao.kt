package com.rvsoft.covidtestgodrej.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rvsoft.covidtestgodrej.data.model.Dashboard
import com.rvsoft.covidtestgodrej.data.model.DashboardWrapper

@Dao
interface DbDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateDashboard(dashboard:Dashboard)

    @Query("SELECT * FROM Dashboard")
    fun getDashboard():LiveData<List<Dashboard>>
}