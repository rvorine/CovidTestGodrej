package com.rvsoft.covidtestgodrej.domain

import com.rvsoft.covidtestgodrej.data.model.Dashboard
import com.rvsoft.covidtestgodrej.data.model.DashboardWrapper
import com.rvsoft.covidtestgodrej.data.model.StateWrapper
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/data.json")
    suspend fun getDashboard():Response<DashboardWrapper>

    @GET("/state_district_wise.json")
    suspend fun getDistrictViseData():Response<StateWrapper>
}