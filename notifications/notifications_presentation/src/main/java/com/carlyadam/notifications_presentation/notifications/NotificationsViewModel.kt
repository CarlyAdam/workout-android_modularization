package com.carlyadam.notifications_presentation.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carlyadam.core.Result
import com.carlyadam.notifications_domain.NotificationData
import com.carlyadam.notifications_interactors.NotificationsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
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

    @ExperimentalCoroutinesApi
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