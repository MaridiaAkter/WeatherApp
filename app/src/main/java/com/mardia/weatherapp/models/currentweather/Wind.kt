package com.mardia.weatherapp.models.currentweather


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Wind(
    @SerializedName("deg")
    @Expose
    var deg: Int? = null,

    @SerializedName("gust")
    @Expose
    var gust: Double? = null,

    @SerializedName("speed")
    @Expose
    var speed: Double? = null
) {
    // Getter methods
    fun getDeg(): Int? {
        return deg
    }

    fun getGust(): Double? {
        return gust
    }

    fun getSpeed(): Double? {
        return speed
    }

    // Setter methods
    fun setDeg(deg: Int?) {
        this.deg = deg
    }

    fun setGust(gust: Double?) {
        this.gust = gust
    }

    fun setSpeed(speed: Double?) {
        this.speed = speed
    }

    // toString method
    override fun toString(): String {
        return "Wind(deg=$deg, gust=$gust, speed=$speed)"
    }
}
