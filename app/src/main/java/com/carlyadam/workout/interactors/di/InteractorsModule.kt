package com.carlyadam.workout.interactors.di

import android.content.Context
import com.carlyadam.workout.data.abstraction.NotificationDataSource
import com.carlyadam.workout.data.abstraction.ProfileDataSource
import com.carlyadam.workout.interactors.NotificationsUseCase
import com.carlyadam.workout.interactors.ProfileUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object InteractorsModule {

    @Provides
    @ActivityRetainedScoped
    fun notificationUseCase(
        notificationDataSource: NotificationDataSource,
        @ApplicationContext context: Context
    ): NotificationsUseCase {
        return NotificationsUseCase(notificationDataSource, context)
    }

    @Provides
    fun profileUseCase(
        profileDataSource: ProfileDataSource,
        @ApplicationContext context: Context
    ): ProfileUseCase {
        return ProfileUseCase(profileDataSource, context)
    }


}