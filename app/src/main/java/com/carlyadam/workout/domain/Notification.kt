package com.carlyadam.workout.domain

data class Notification(
    val action: String,
    val body: String,
    val created_by: Any,
    val created_date: String,
    val id: Int,
    val is_active: Boolean,
    val is_read: Boolean,
    val last_modified_by: Any,
    val last_modified_date: String,
    val notification_type: String,
    val title: String
)