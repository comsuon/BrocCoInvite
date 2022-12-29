package com.ericpham.broccoinvite.presentation.di

import com.ericpham.broccoinvite.data.remote.NetworkService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideNetworkService(): NetworkService {
        return Retrofit.Builder()
            .baseUrl("https://us-central1-blinkapp-684c1.cloudfunctions.net")
            .build()
            .create(NetworkService::class.java)
    }
}