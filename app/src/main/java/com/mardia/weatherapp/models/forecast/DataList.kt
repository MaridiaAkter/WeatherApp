package com.mardia.weatherapp.models.forecast


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataList(
    @SerializedName("clouds")
    @Expose
    var clouds: Clouds? = null,

    @SerializedName("dt")
    @Expose
    var dt: Int? = null,

    @SerializedName("dt_txt")
    @Expose
    var dtTxt: String? = null,

    @SerializedName("main")
    @Expose
    var main: Main? = null,

    @SerializedName("pop")
    @Expose
    var pop: Double? = null,

    @SerializedName("rain")
    @Expose
    var rain: Rain? = null,

    @SerializedName("sys")
    @Expose
    var sys: Sys? = null,

    @SerializedName("visibility")
    @Expose
    var visibility: Int? = null,

    @SerializedName("weather")
    @Expose
    var weather: List<Weather?>? = null,

    @SerializedName("wind")
    @Expose
    var wind: Wind? = null
)