package com.mardia.weatherapp.models.forecast


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class ForecastRootModel(
    @SerializedName("city")
    @Expose
    val city: City?,
    @SerializedName("cnt")
    @Expose
    val cnt: Int?,
    @SerializedName("cod")
    @Expose
    val cod: String?,
    @SerializedName("list")
    @Expose
    val list: List<DataList?>?,
    @SerializedName("message")
    @Expose
    val message: Int?
)