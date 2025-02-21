package com.example.expandedlistdemoapp.di

import android.app.Application
import com.example.expandedlistdemoapp.data.datasource.DataManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

class AppModule {

    @Provides
    @Singleton
    fun provideDataSource(
        context: Application
    ): DataManager {
        return DataManager(context)
    }
}