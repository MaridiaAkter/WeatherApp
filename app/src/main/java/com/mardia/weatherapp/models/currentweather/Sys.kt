package com.mardia.weatherapp.models.currentweather


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Sys(
    @SerializedName("country")
    @Expose
    var country: String? = null,

    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("sunrise")
    @Expose
    var sunrise: Int? = null,

    @SerializedName("sunset")
    @Expose
    var sunset: Int? = null,

    @SerializedName("type")
    @Expose
    var type: Int? = null
) {
    // Getter methods
    fun getCountry(): String? {
        return country
    }

    fun getId(): Int? {
        return id
    }

    fun getSunrise(): Int? {
        return sunrise
    }

    fun getSunset(): Int? {
        return sunset
    }

    fun getType(): Int? {
        return type
    }

    // Setter methods
    fun setCountry(country: String?) {
        this.country = country
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun setSunrise(sunrise: Int?) {
        this.sunrise = sunrise
    }

    fun setSunset(sunset: Int?) {
        this.sunset = sunset
    }

    fun setType(type: Int?) {
        this.type = type
    }

    // toString method
    override fun toString(): String {
        return "Sys(country=$country, id=$id, sunrise=$sunrise, sunset=$sunset, type=$type)"
    }
}
