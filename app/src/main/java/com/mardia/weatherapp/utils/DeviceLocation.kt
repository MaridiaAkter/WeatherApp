package com.mardia.weatherapp.utils

import android.content.Context
import android.location.LocationManager
import android.os.Build
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class DeviceLocation @Inject constructor(@ApplicationContext private val context: Context) {

    val isEnabled: Boolean
        // check device location on/off
        get() {
            var checkEnable = true
            val locationManager =
                context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                if (!locationManager.isLocationEnabled) {
                    checkEnable = false
                }
            }
            return checkEnable
        }
}
