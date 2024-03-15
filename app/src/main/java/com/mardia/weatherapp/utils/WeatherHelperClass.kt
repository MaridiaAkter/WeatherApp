package com.mardia.weatherapp.utils

import java.text.SimpleDateFormat
import java.util.Date

object WeatherHelperClass {

    fun getDateTimeFormatter(date: Int, format: String): String {
        return SimpleDateFormat(format)
            .format(Date(date * 1000L))
    }

    fun capitalizeWord(sample: String): String {
        val words = sample.split(" ")
        var result = ""
        for (word in words) {
            val firstSub = word.substring(0, 1)
            val secondSub = word.substring(1)
            result += firstSub.toUpperCase() + secondSub + " "
        }
        return result
    }
}



