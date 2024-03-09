package com.mardia.weatherapp.models.forecast


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Rain(
    @SerializedName("3h")
    @Expose
    val h: Double?
)