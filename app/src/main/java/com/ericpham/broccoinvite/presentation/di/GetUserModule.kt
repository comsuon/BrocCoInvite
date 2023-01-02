package com.ericpham.broccoinvite.presentation.di

import com.ericpham.broccoinvite.data.InviteRepo
import com.ericpham.broccoinvite.domain.GetUser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object GetUserModule {

    @Provides
    fun provideGetUserUseCase(inviteRepo: InviteRepo): GetUser = GetUser(inviteRepo)
}