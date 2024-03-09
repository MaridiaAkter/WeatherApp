package com.mardia.weatherapp.models.currentweather


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Sys(
    @SerializedName("country")
    @Expose
    val country: String?,
    @SerializedName("id")
    @Expose
    val id: Int?,
    @SerializedName("sunrise")
    @Expose
    val sunrise: Int?,
    @SerializedName("sunset")
    @Expose
    val sunset: Int?,
    @SerializedName("type")
    @Expose
    val type: Int?
)