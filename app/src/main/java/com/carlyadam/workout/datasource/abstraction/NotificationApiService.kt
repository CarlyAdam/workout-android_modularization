package com.carlyadam.workout.datasource.abstraction

import com.carlyadam.workout.datasource.responses.NotificationsResponse
import retrofit2.Response

interface NotificationApiService {

    suspend fun getAllNotifications() : Response<NotificationsResponse>
}