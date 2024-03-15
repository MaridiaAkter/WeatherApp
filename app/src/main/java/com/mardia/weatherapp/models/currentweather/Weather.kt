package com.mardia.weatherapp.models.currentweather


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("description")
    @Expose
    var description: String? = null,

    @SerializedName("icon")
    @Expose
    var icon: String? = null,

    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("main")
    @Expose
    var main: String? = null
)
