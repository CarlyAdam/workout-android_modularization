package com.carlyadam.workout.datasource.implementation

import com.carlyadam.workout.domain.User
import com.carlyadam.workout.datasource.ApiService
import com.carlyadam.workout.datasource.abstraction.ProfileApiService
import com.carlyadam.workout.datasource.utils.Constant
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProfileApiServiceImpl @Inject constructor(
    private val apiService: ApiService
) : ProfileApiService {

    override suspend fun getUserProfile(): Response<User> {
        return apiService.getProfile(Constant.TOKEN_API)
    }
}