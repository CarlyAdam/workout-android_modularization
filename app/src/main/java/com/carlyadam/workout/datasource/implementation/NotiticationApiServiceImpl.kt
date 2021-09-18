package com.carlyadam.workout.datasource.implementation

import com.carlyadam.workout.datasource.ApiService
import com.carlyadam.workout.datasource.abstraction.NotificationApiService
import com.carlyadam.workout.datasource.utils.Constant
import com.carlyadam.workout.datasource.responses.NotificationsResponse
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class NotiticationApiServiceImpl @Inject constructor(
    private val apiService: ApiService
) : NotificationApiService {

    override suspend fun getAllNotifications(): Response<NotificationsResponse> {
        return apiService.notifications(
            Constant.TOKEN_API,
            806
        )
    }
}