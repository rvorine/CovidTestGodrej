package com.rvsoft.covidtestgodrej.di

import com.google.gson.Gson
import com.rvsoft.covidtestgodrej.domain.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    fun providesBaseUrl():String = "https://data.covid19india.org"

    @Provides
    @Singleton
    fun providesRetrofit(baseUrl:String):Retrofit = Retrofit.Builder().apply {
        baseUrl(baseUrl)
        addConverterFactory(GsonConverterFactory.create())
    }.build()

    @Provides
    @Singleton
    fun providesService(retrofit: Retrofit):ApiService = retrofit.create(ApiService::class.java)
}