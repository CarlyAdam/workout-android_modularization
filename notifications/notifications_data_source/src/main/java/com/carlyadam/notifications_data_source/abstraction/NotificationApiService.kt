package com.carlyadam.notifications_data_source.abstraction

import com.carlyadam.notifications_data_source.responses.NotificationsResponse
import retrofit2.Response

interface NotificationApiService {

    suspend fun getAllNotifications() : Response<NotificationsResponse>
}