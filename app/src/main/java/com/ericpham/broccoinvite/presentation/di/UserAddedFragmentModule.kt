package com.ericpham.broccoinvite.presentation.di

import android.content.Context
import android.content.SharedPreferences
import com.ericpham.broccoinvite.data.InviteRepo
import com.ericpham.broccoinvite.data.local.PersistentManager
import com.ericpham.broccoinvite.data.local.SharedPrefManagerImpl
import com.ericpham.broccoinvite.domain.InviteUserToList
import com.ericpham.broccoinvite.domain.RemoveUserFromList
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Qualifier

@Module
@InstallIn(FragmentComponent::class)
object UserAddedFragmentModule {

    @Provides
    fun provideRemoveUserFromListUseCase(inviteRepo: InviteRepo): RemoveUserFromList =
        RemoveUserFromList(repo = inviteRepo)
}