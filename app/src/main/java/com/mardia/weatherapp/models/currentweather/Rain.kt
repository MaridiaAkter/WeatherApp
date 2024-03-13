package com.mardia.weatherapp.models.currentweather


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Rain(
    @SerializedName("1h")
    @Expose
    var h: Double? = null
) {
    // Getter method for 'h' property
    fun getH(): Double? {
        return h
    }

    // Setter method for 'h' property
    fun setH(h: Double?) {
        this.h = h
    }

    // toString method
    override fun toString(): String {
        return "Rain(h=$h)"
    }
}
