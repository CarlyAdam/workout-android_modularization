package com.carlyadam.workout.data.abstraction

import com.carlyadam.workout.domain.User
import retrofit2.Response

interface ProfileDataSource {

    suspend fun getUserProfile() : Response<User>
}