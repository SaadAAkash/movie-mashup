package ninja.saad.moviemashup.util

import java.util.*

fun Date.toReleaseFormat(): String {
    val calender = Calendar.getInstance()
    calender.time = this
    return "${calender.get(Calendar.YEAR)}-${calender.get(Calendar.MONTH)}-${calender.get(Calendar.DAY_OF_MONTH)}"
}
