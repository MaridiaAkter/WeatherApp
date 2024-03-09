package com.mardia.weatherapp.models.currentweather


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Rain(
    @SerializedName("1h")
    @Expose
    val h: Double?
)