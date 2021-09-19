package com.carlyadam.notifications_data.abstraction

import com.carlyadam.notifications_data_source.responses.NotificationsResponse
import retrofit2.Response

interface NotificationDataSource {

    suspend fun getAllNotifications(): Response<NotificationsResponse>
}