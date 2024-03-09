package com.mardia.weatherapp.utils

object Constants {
    val OPEN_WEATHER_API_KEY = "d98aea393d44d7912075d86400b9c419"

    // Icon Url sample is https://openweathermap.org/img/wn/10d@2x.png
    val ICON_URL_PREFIX = "https://openweathermap.org/img/wn/"
    val ICON_URL_SUFFIX = "@2x.png"
    val ICON_URL_SUFFIX_4X = "@4x.png"

    // Change the value of temp based on switch from MainFragment
    var TEMP_STATUS = false

    // SharedPreference Constants
    val PREFERENCE_NAME = "WeatherSharedPreferences"
    val LAST_LAT_KEY = "last_lat"
    val LAST_LON_KEY = "last_lon"
    val TEMP_UNIT_KEY = "temp_unit"


    object TempUnit {
        const val CELSIUS = "metric"
        const val FAHRENHEIT = "imperial"
    }


    object MetricUnit {
        const val TEMPERATURE = "\u00B0" + " C"
        const val WIND_SPEED = " m/s"
    }


    object ImperialUnit {
        const val TEMPERATURE = "\u00B0" + " F"
        const val WIND_SPEED = " m/h"
    }
}