package com.carlyadam.workout.datasource.utils

import java.text.SimpleDateFormat
import java.util.*

object Constant {

    val API_URL = "https://devapi.vivecar.mx/"
    val TOKEN_API = "Token 7e29058c09bc4b6d88681993a2ff552fb0c8bdf9"

    fun formatDate(
        fecha: String,
        formatInt: String,
        formatOut: String
    ): String {
        val date = SimpleDateFormat(formatInt).parse(fecha)
        val sdf = SimpleDateFormat(formatOut, Locale("es"))
        return sdf.format(date)
    }

}
