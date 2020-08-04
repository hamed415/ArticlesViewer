package com.hamed.core.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


fun getFormattedDate(date: LocalDateTime): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    return date.format(formatter)
}