package com.mardia.weatherapp.models.forecast


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Main(
    @SerializedName("feels_like")
    @Expose
    var feelsLike: Double? = null,

    @SerializedName("grnd_level")
    @Expose
    var grndLevel: Int? = null,

    @SerializedName("humidity")
    @Expose
    var humidity: Int? = null,

    @SerializedName("pressure")
    @Expose
    var pressure: Int? = null,

    @SerializedName("sea_level")
    @Expose
    var seaLevel: Int? = null,

    @SerializedName("temp")
    @Expose
    var temp: Double? = null,

    @SerializedName("temp_kf")
    @Expose
    var tempKf: Double? = null,

    @SerializedName("temp_max")
    @Expose
    var tempMax: Double? = null,

    @SerializedName("temp_min")
    @Expose
    var tempMin: Double? = null
)
