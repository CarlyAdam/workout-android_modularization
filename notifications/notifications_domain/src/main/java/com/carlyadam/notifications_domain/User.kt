package com.carlyadam.notifications_domain

data class User(
    val email: String? = null,
    val id: Int,
    val last_name: String,
    val name: String,
    val phone_prefix: String? = null,
    val phone_number: String? = null,
    val birth_date: String? = null,
    val avatar: String? = null,
    val in_service: Boolean? = null,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val preferred_language: String? = null,
    val rating: Double? = null,
    val is_verified: Boolean? = null,
    val is_client_trustworthy: Boolean? = null,
    val is_client_pending: Boolean? = null,
    val is_client_partial_rejected: Boolean? = null,
    val is_client_rejected: Boolean? = null
)