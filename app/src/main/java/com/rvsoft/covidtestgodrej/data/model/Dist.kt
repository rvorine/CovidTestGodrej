package com.rvsoft.covidtestgodrej.data.model

import java.io.Serializable

class Dist(var name:String="", override var active: Long, override var confirmed: Long, override var recovered: Long) : District,Serializable{
    val activeCase:String
    get() = active.toString()

    val recoveredCase:String
    get() = recovered.toString()
}