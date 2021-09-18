package com.carlyadam.workout.interactors

import android.content.Context
import com.carlyadam.workout.R
import com.carlyadam.workout.data.abstraction.ProfileDataSource
import com.carlyadam.workout.domain.User
import com.carlyadam.workout.datasource.Result
import com.carlyadam.workout.datasource.safeApiCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException

class ProfileUseCase(
    private val profileDataSource: ProfileDataSource,
    private val context: Context
) {

    suspend fun profile(
    ) =
        safeApiCall(
            call = {
                getProfile()
            },
            errorMessage = context.getString(R.string.no_connection)
        )

    suspend fun getProfile(): Flow<Result<User>> = flow {
        val response = profileDataSource.getUserProfile()
        if (response.isSuccessful) {
            emit(Result.Success(response.body()!!))
        } else {
            emit(Result.Error(IOException("No connection")))
        }
    }.flowOn(Dispatchers.IO)


}