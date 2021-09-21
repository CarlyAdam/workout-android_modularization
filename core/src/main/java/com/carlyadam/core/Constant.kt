package com.carlyadam.core

import java.text.SimpleDateFormat
import java.util.*

object Constant {

    val API_URL = "https://devapi.vivecar.mx/"
    val TOKEN_API = "Token 1f462e401ba91e7f1f27f8f5b0eff446024da59c"

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
