package com.daniel.common.extension

import java.text.SimpleDateFormat
import java.util.*

fun Date.format(pattern: String): String {
    val format = SimpleDateFormat(pattern, Locale.getDefault())
    return format.format(this)
}
