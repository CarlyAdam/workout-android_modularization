package com.carlyadam.notifications_presentation.di

import com.carlyadam.notifications_data.abstraction.NotificationDataSource
import com.carlyadam.notifications_data.implementation.NotificationDataSourceImpl
import com.carlyadam.notifications_data_source.abstraction.NotificationApiService
import com.carlyadam.notifications_data_source.implementation.NotiticationApiServiceImpl
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

}