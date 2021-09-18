package com.carlyadam.workout.domain

data class NotificationData(
    val id: Int,
    val is_read: Boolean,
    val notification: Notification,
    val user: User
)