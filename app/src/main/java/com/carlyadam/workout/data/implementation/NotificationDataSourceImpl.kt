package com.carlyadam.workout.data.implementation

import com.carlyadam.workout.data.abstraction.NotificationDataSource
import com.carlyadam.workout.datasource.abstraction.NotificationApiService
import com.carlyadam.workout.datasource.responses.NotificationsResponse
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NotificationDataSourceImpl @Inject constructor(private val notificationApiService: NotificationApiService) :
    NotificationDataSource {

    override suspend fun getAllNotifications(): Response<NotificationsResponse> {
        return notificationApiService.getAllNotifications()
    }
}