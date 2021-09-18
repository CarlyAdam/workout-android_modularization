package com.carlyadam.workout.interactors

import android.content.Context
import android.util.Log
import com.carlyadam.workout.R
import com.carlyadam.workout.data.abstraction.NotificationDataSource
import com.carlyadam.workout.domain.NotificationData
import com.carlyadam.workout.datasource.Result
import com.carlyadam.workout.datasource.safeApiCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException

class NotificationsUseCase(
    private val notificationDataSource: NotificationDataSource,
    private val context: Context
) {

    suspend fun notifications(
    ) =
        safeApiCall(
            call = {
                getNotifications()
            },
            errorMessage = context.getString(R.string.no_connection)
        )

    suspend fun getNotifications(): Flow<Result<List<NotificationData>>> = flow {
        val response = notificationDataSource.getAllNotifications()
        if (response.isSuccessful) {
            emit(Result.Success(response.body()!!.results))
        } else {
            emit(Result.Error(IOException("No connection")))
        }
    }.flowOn(Dispatchers.IO)

}