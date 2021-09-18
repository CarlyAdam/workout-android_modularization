package com.carlyadam.workout.datasource.responses

import com.carlyadam.workout.domain.NotificationData

data class NotificationsResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<NotificationData>
)