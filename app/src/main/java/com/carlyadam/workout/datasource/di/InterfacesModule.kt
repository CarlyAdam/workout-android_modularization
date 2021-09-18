package com.carlyadam.workout.datasource.di

import com.carlyadam.workout.data.abstraction.NotificationDataSource
import com.carlyadam.workout.data.abstraction.ProfileDataSource
import com.carlyadam.workout.data.implementation.NotificationDataSourceImpl
import com.carlyadam.workout.data.implementation.ProfileDataSourceImpl
import com.carlyadam.workout.datasource.abstraction.NotificationApiService
import com.carlyadam.workout.datasource.abstraction.ProfileApiService
import com.carlyadam.workout.datasource.implementation.NotiticationApiServiceImpl
import com.carlyadam.workout.datasource.implementation.ProfileApiServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class InterfacesModule {

    @Binds
    abstract fun notificationDataSource(impl: NotificationDataSourceImpl): NotificationDataSource

    @Binds
    abstract fun notificationApiService(impl: NotiticationApiServiceImpl): NotificationApiService

    @Binds
    abstract fun profileDataSource(impl: ProfileDataSourceImpl): ProfileDataSource

    @Binds
    abstract fun profileApiService(impl: ProfileApiServiceImpl): ProfileApiService
}