package com.carlyadam.workout.datasource.di

import com.carlyadam.workout.data.implementation.NotificationDataSourceImpl
import com.carlyadam.workout.data.implementation.ProfileDataSourceImpl
import com.carlyadam.workout.datasource.abstraction.NotificationApiService
import com.carlyadam.workout.datasource.abstraction.ProfileApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun notificationDataSource(
        notificationApiService: NotificationApiService
    ): NotificationDataSourceImpl {
        return NotificationDataSourceImpl(notificationApiService)
    }

    @Provides
    fun profileDataSource(
        profileApiService: ProfileApiService
    ): ProfileDataSourceImpl {
        return ProfileDataSourceImpl(profileApiService)
    }


}