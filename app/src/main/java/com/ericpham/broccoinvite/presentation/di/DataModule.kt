package com.ericpham.broccoinvite.presentation.di

import android.content.Context
import android.content.SharedPreferences
import com.ericpham.broccoinvite.data.InviteRepo
import com.ericpham.broccoinvite.data.InviteRepoImpl
import com.ericpham.broccoinvite.data.local.LocalDataSource
import com.ericpham.broccoinvite.data.local.LocalDataSourceImpl
import com.ericpham.broccoinvite.data.local.PersistentManager
import com.ericpham.broccoinvite.data.local.SharedPrefManagerImpl
import com.ericpham.broccoinvite.data.remote.RemoteDataSource
import com.ericpham.broccoinvite.data.remote.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    @Singleton
    abstract fun bindInviteRepo(inviteRepoImpl: InviteRepoImpl): InviteRepo

    @Binds
    @Singleton
    abstract fun bindLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource

    @Binds
    @Singleton
    abstract fun bindRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource
}