package com.ericpham.broccoinvite.presentation.di

import com.ericpham.broccoinvite.data.InviteRepo
import com.ericpham.broccoinvite.domain.InviteUserToList
import com.ericpham.broccoinvite.domain.RemoteFakeAuthUser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object InviteUserFragmentModule {

    @Provides
    fun provideInviteUserToListUseCase(inviteRepo: InviteRepo): InviteUserToList =
        InviteUserToList(repo = inviteRepo)

    @Provides
    fun provideRemoteFakeAuthUser(inviteRepo: InviteRepo) = RemoteFakeAuthUser(repo = inviteRepo)
}