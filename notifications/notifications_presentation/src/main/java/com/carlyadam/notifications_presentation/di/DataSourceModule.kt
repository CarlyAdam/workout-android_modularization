package com.carlyadam.notifications_presentation.di

import com.carlyadam.notifications_data.implementation.NotificationDataSourceImpl
import com.carlyadam.notifications_data_source.ApiService
import com.carlyadam.notifications_data_source.abstraction.NotificationApiService
import com.carlyadam.notifications_data_source.implementation.NotiticationApiServiceImpl
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
    fun notificationDataSourceImpl(
        notificationApiService: NotificationApiService
    ): NotificationDataSourceImpl {
        return NotificationDataSourceImpl(
            notificationApiService
        )
    }

    @Provides
    fun notificationApiServiceImpl(
        apiService: ApiService
    ): NotiticationApiServiceImpl {
        return NotiticationApiServiceImpl(apiService)
    }


}