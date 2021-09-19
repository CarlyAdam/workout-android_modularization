package com.carlyadam.notifications_data_source.implementation

import com.carlyadam.notifications_data_source.ApiService
import com.carlyadam.notifications_data_source.abstraction.NotificationApiService
import com.carlyadam.notifications_data_source.responses.NotificationsResponse
import retrofit2.Response


class NotiticationApiServiceImpl(
    private val apiService: ApiService
) : NotificationApiService {

    override suspend fun getAllNotifications(): Response<NotificationsResponse> {
        return apiService.notifications(
            com.carlyadam.core.Constant.TOKEN_API,
            806
        )
    }
}