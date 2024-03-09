package com.mardia.weatherapp.models.currentweather


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class CurrentWeatherRootModel(
    @SerializedName("base")
    @Expose
    val base: String?,
    @SerializedName("clouds")
    @Expose
    val clouds: Clouds?,
    @SerializedName("cod")
    @Expose
    val cod: Int?,
    @SerializedName("coord")
    @Expose
    val coord: Coord?,
    @SerializedName("dt")
    @Expose
    val dt: Int?,
    @SerializedName("id")
    @Expose
    val id: Int?,
    @SerializedName("main")
    @Expose
    val main: Main?,
    @SerializedName("name")
    @Expose
    val name: String?,
    @SerializedName("rain")
    @Expose
    val rain: Rain?,
    @SerializedName("sys")
    @Expose
    val sys: Sys?,
    @SerializedName("timezone")
    @Expose
    val timezone: Int?,
    @SerializedName("visibility")
    @Expose
    val visibility: Int?,
    @SerializedName("weather")
    @Expose
    val weather: List<Weather?>?,
    @SerializedName("wind")
    @Expose
    val wind: Wind?
)