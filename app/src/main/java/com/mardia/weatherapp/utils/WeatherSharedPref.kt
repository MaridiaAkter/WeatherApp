package com.mardia.weatherapp.utils

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class WeatherSharedPref @Inject constructor(@ApplicationContext private val context: Context) {

    private val weatherPref: SharedPreferences = context.getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE)
    private var editor: SharedPreferences.Editor = weatherPref.edit()


    fun setTempUnit(tempUnit: Boolean) {
        editor.putBoolean(Constants.TEMP_UNIT_KEY, tempUnit)
        editor.apply()
    }

    fun getTempUnit(): Boolean {
        return weatherPref.getBoolean(Constants.TEMP_UNIT_KEY, false)
    }

    fun setLastLat(lastLatitude: Double) {
        putDouble(editor, Constants.LAST_LAT_KEY, lastLatitude).apply()
    }

    fun getLastLat(): Double {
        return getDouble(weatherPref, Constants.LAST_LAT_KEY, 0.0)
    }

    fun setLastLon(lastLongitude: Double) {
        putDouble(editor, Constants.LAST_LON_KEY, lastLongitude).apply()
    }

    fun getLastLon(): Double {
        return getDouble(weatherPref, Constants.LAST_LON_KEY, 0.0)
    }

    private fun putDouble(
        edit: SharedPreferences.Editor,
        key: String,
        value: Double
    ): SharedPreferences.Editor {
        return edit.putLong(key, value.toRawBits())
    }

    private fun getDouble(prefs: SharedPreferences, key: String, defaultValue: Double): Double {
        return Double.fromBits(prefs.getLong(key, defaultValue.toRawBits()))
    }


}
