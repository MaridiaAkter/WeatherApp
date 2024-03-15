package com.mardia.weatherapp.models.forecast


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ForecastRootModel(
    @SerializedName("city")
    @Expose
    var city: City? = null,

    @SerializedName("cnt")
    @Expose
    var cnt: Int? = null,

    @SerializedName("cod")
    @Expose
    var cod: String? = null,

    @SerializedName("list")
    @Expose
    var list: List<DataList>? = null,

    @SerializedName("message")
    @Expose
    var message: Int? = null
)
