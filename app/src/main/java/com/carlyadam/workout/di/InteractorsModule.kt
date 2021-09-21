package com.carlyadam.workout.di

import com.carlyadam.notifications_data.abstraction.NotificationDataSource
import com.carlyadam.notifications_interactors.NotificationsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object InteractorsModule {

    @Provides
    @ActivityRetainedScoped
    fun notificationUseCase(
        notificationDataSource: NotificationDataSource
    ): NotificationsUseCase {
        return NotificationsUseCase(notificationDataSource)
    }


}