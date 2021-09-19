package com.carlyadam.notifications_data_source

import com.carlyadam.notifications_data_source.responses.NotificationsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {


    @GET("trip-management/notification-user/")
    suspend fun notifications(
        @Header("Authorization") token: String,
        @Query("user") user: Int
    ): Response<NotificationsResponse>


}
