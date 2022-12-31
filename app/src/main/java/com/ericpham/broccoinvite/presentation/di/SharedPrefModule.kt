package com.ericpham.broccoinvite.presentation.di

import android.content.Context
import android.content.SharedPreferences
import com.ericpham.broccoinvite.data.local.PersistentManager
import com.ericpham.broccoinvite.data.local.SharedPrefManagerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
@SharedPreferenceQualifier
object SharedPrefModule {
    @Provides
    @Singleton
    fun providePersistentManager(sharedPref: SharedPreferences): PersistentManager =
        SharedPrefManagerImpl(sharedPref)

    @Provides
    @Singleton
    fun provideSharedPref(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences("BrocCoInvite", Context.MODE_PRIVATE)

}