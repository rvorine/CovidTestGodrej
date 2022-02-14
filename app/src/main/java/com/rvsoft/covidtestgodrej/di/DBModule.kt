package com.rvsoft.covidtestgodrej.di

import android.content.Context
import androidx.room.Room
import com.rvsoft.covidtestgodrej.db.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context:Context):AppDataBase{
        return Room.databaseBuilder(context,AppDataBase::class.java,"database.db").build()
    }
}