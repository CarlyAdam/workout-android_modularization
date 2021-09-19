package com.carlyadam.notifications_data_source.responses

import com.carlyadam.notifications_domain.NotificationData

data class NotificationsResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<NotificationData>
)