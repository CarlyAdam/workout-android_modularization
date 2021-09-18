package com.carlyadam.workout.presentation.notifications

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carlyadam.workout.domain.NotificationData
import com.carlyadam.workout.datasource.Result
import com.carlyadam.workout.interactors.NotificationsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotificationsViewModel @Inject constructor(
    private val notificationsUseCase: NotificationsUseCase
) :
    ViewModel() {

    private val _responseNotificationsLiveData = MutableLiveData<List<NotificationData>>()
    val responseNotificationsLiveData: LiveData<List<NotificationData>> get() = _responseNotificationsLiveData

    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> get() = _errorLiveData

    fun notifications() {
        viewModelScope.launch {
            notificationsUseCase.notifications().collect { result ->
                when (result) {
                    is Result.Success -> _responseNotificationsLiveData.postValue(result.data)
                    is Result.Error -> _errorLiveData.postValue(result.exception.message)
                }
            }
        }
    }


}