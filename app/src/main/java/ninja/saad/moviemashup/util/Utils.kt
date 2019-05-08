package com.anythingintellect.themoviedb.util

import java.util.*

/**
 * Created by ishan.dhingra on 09/11/17.
 */
fun Date.toReleaseFormat(): String {
    val calender = Calendar.getInstance()
    calender.time = this
    return "${calender.get(Calendar.YEAR)}-${calender.get(Calendar.MONTH)}-${calender.get(Calendar.DAY_OF_MONTH)}"
}