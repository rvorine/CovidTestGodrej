package com.rvsoft.covidtestgodrej.data.model

import com.google.gson.annotations.SerializedName

data class StateWrapper(
    @SerializedName("Maharashtra")
    val maharashtra:DistrictWrapper
)
