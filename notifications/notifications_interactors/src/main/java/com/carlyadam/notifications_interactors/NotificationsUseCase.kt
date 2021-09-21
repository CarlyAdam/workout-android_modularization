package com.carlyadam.notifications_interactors

import com.carlyadam.core.Result
import com.carlyadam.notifications_data.abstraction.NotificationDataSource
import com.carlyadam.notifications_domain.NotificationData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import retrofit2.Response

class NotificationsUseCase(
    private val notificationDataSource: NotificationDataSource
) {

    @ExperimentalCoroutinesApi
    suspend fun notifications(
    ) =
        safeApiCall(
            call = {
                getNotifications()
            },
            errorMessage = "No connection"
        )
    @ExperimentalCoroutinesApi
    suspend fun getNotifications(): Flow<Result<List<NotificationData>>> = flow {
        val response = notificationDataSource.getAllNotifications()
        print(response.toString())
        if (response.isSuccessful) {
            emit(Result.Success(response.body()!!.results))
        } else {
            emit(Result.Error(IOException("No connection")))
        }
    }.flowOn(Dispatchers.IO)

}