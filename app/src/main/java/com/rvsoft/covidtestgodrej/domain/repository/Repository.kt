package com.rvsoft.covidtestgodrej.domain.repository

import com.rvsoft.covidtestgodrej.domain.ApiService
import javax.inject.Inject

class Repository @Inject constructor(
    private val api:ApiService
) {

    suspend fun getDashboard() = api.getDashboard()

    suspend fun getDistrictViseData() = api.getDistrictViseData()
}