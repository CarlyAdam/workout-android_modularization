package com.carlyadam.notifications_data.implementation

import com.carlyadam.notifications_data.abstraction.NotificationDataSource
import com.carlyadam.notifications_data_source.abstraction.NotificationApiService
import com.carlyadam.notifications_data_source.responses.NotificationsResponse
import retrofit2.Response

class NotificationDataSourceImpl(private val notificationApiService: NotificationApiService) :
    NotificationDataSource {

    override suspend fun getAllNotifications(): Response<NotificationsResponse> {
        return notificationApiService.getAllNotifications()
    }
}