package com.mardia.weatherapp.utils

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.provider.Settings
import androidx.core.app.ActivityCompat
import javax.inject.Inject


class LocationPermissions @Inject constructor(var activity: Activity) {
    @Inject
    var deviceLocation: DeviceLocation? = null

    init {
        locationPermission
    }

    private val locationPermission: Unit
        private get() {
            if (ActivityCompat.checkSelfPermission(
                    activity,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(
                    activity,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                //if the permission for location access is given
                return
            } else {
                //if permission is given yet
                ActivityCompat.requestPermissions(
                    activity, arrayOf(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    ), 6
                ) //request the permission
            }
        }

    fun locationEnable() {
        if (!deviceLocation!!.isEnabled) {
            val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
            activity.startActivity(intent)
        }
    }
}
