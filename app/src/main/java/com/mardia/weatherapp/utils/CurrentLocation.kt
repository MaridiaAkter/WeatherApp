package com.mardia.weatherapp.utils

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.CancellationTokenSource
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class CurrentLocation @Inject constructor(@ApplicationContext private val context: Context){

    var weatherSharedPref: WeatherSharedPref? = null
        @Inject set

    private var fusedLocationClient: FusedLocationProviderClient? = null
    private var lat: Double = 0.0
    private var lon: Double = 0.0

    fun getLat(): Double {
        return lat
    }

    fun getLon(): Double {
        return lon
    }

    fun getLocation() {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }

        fusedLocationClient?.getCurrentLocation(
            Priority.PRIORITY_BALANCED_POWER_ACCURACY,
            CancellationTokenSource().token
        )?.addOnSuccessListener { location: Location? ->
                // Got last known location. In some rare situations this can be null.
                location?.let {
                    lat = it.latitude
                    lon = it.longitude
                    // save in shared pref
                    weatherSharedPref?.setLastLat(it.latitude)
                    weatherSharedPref?.setLastLon(it.longitude)

                    //Toast.makeText(context, "Lat: " + lat + "\nLon: " + lon, Toast.LENGTH_SHORT).show();
                }
            }
    }
}



