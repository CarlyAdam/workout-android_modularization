package com.carlyadam.workout.data.abstraction

import com.carlyadam.workout.datasource.responses.NotificationsResponse
import retrofit2.Response

interface NotificationDataSource {

    suspend fun getAllNotifications() : Response<NotificationsResponse>
}