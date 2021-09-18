package com.carlyadam.workout.data.implementation

import com.carlyadam.workout.data.abstraction.ProfileDataSource
import com.carlyadam.workout.domain.User
import com.carlyadam.workout.datasource.abstraction.ProfileApiService
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProfileDataSourceImpl @Inject constructor(private val profileApiService: ProfileApiService) :
    ProfileDataSource {

    override suspend fun getUserProfile(): Response<User> {
       return  profileApiService.getUserProfile()
    }
}