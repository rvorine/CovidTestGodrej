package com.rvsoft.covidtestgodrej.db.repository

import androidx.lifecycle.LiveData
import com.rvsoft.covidtestgodrej.data.model.Dashboard
import com.rvsoft.covidtestgodrej.db.AppDataBase
import javax.inject.Inject

class DBRepository @Inject constructor(
    private val db:AppDataBase
) {

    suspend fun insertOrUpdateDashboard(data:Dashboard) = db.dashboardDao().insertOrUpdateDashboard(data)

    suspend fun insertOrUpdateDashboard(list:List<Dashboard>) {
        list.forEach { dashboard ->
            db.dashboardDao().insertOrUpdateDashboard(dashboard)
        }
    }

    fun getDashboard():LiveData<List<Dashboard>> = db.dashboardDao().getDashboard()
}