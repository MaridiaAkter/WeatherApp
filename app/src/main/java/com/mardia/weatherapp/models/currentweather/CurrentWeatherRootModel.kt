package com.mardia.weatherapp.models.currentweather


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CurrentWeatherRootModel(
    @SerializedName("base")
    @Expose
    var base: String? = null,
    @SerializedName("clouds")
    @Expose
    var clouds: Clouds? = null,
    @SerializedName("cod")
    @Expose
    var cod: Int? = null,
    @SerializedName("coord")
    @Expose
    var coord: Coord? = null,
    @SerializedName("dt")
    @Expose
    var dt: Int? = null,
    @SerializedName("id")
    @Expose
    var id: Int? = null,
    @SerializedName("main")
    @Expose
    var main: Main? = null,
    @SerializedName("name")
    @Expose
    var name: String? = null,
    @SerializedName("rain")
    @Expose
    var rain: Rain? = null,
    @SerializedName("sys")
    @Expose
    var sys: Sys? = null,
    @SerializedName("timezone")
    @Expose
    var timezone: Int? = null,
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