package com.mardia.weatherapp.models.currentweather


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Coord(
    @SerializedName("lat")
    @Expose
    var lat: Double? = null,

    @SerializedName("lon")
    @Expose
    var lon: Double? = null
) {
    // Getter methods
    fun getLat(): Double? {
        return lat
    }

    fun getLon(): Double? {
        return lon
    }

    // Setter methods
    fun setLat(lat: Double?) {
        this.lat = lat
    }

    fun setLon(lon: Double?) {
        this.lon = lon
    }

    // toString method
    override fun toString(): String {
        return "Coord(lat=$lat, lon=$lon)"
    }
}
