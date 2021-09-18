package com.carlyadam.workout.datasource

import com.carlyadam.workout.domain.User
import com.carlyadam.workout.datasource.responses.NotificationsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {


    @GET("user/profile/")
    suspend fun getProfile(
        @Header("Authorization") token: String,
    ): Response<User>

    @GET("trip-management/notification-user/")
    suspend fun notifications(
        @Header("Authorization") token: String,
        @Query("user") user: Int
    ): Response<NotificationsResponse>


}
