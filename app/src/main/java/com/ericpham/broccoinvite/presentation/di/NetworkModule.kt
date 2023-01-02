package com.ericpham.broccoinvite.presentation.di

import com.ericpham.broccoinvite.data.remote.NetworkService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideNetworkService(): NetworkService {
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder()
            .baseUrl("https://us-central1-blinkapp-684c1.cloudfunctions.net")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(NetworkService::class.java)
    }
}