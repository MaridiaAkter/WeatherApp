package com.mardia.weatherapp.models.forecast


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
)
