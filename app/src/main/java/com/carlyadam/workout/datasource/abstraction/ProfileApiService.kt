package com.carlyadam.workout.datasource.abstraction

import com.carlyadam.workout.domain.User
import retrofit2.Response

interface ProfileApiService {

    suspend fun getUserProfile() : Response<User>
}