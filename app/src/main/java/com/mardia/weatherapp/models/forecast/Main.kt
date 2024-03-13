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
) {
    // Getter methods
    fun getFeelsLike(): Double? {
        return feelsLike
    }

    fun getGrndLevel(): Int? {
        return grndLevel
    }

    fun getHumidity(): Int? {
        return humidity
    }

    fun getPressure(): Int? {
        return pressure
    }

    fun getSeaLevel(): Int? {
        return seaLevel
    }

    fun getTemp(): Double? {
        return temp
    }

    fun getTempKf(): Double? {
        return tempKf
    }

    fun getTempMax(): Double? {
        return tempMax
    }

    fun getTempMin(): Double? {
        return tempMin
    }

    // Setter methods
    fun setFeelsLike(feelsLike: Double?) {
        this.feelsLike = feelsLike
    }

    fun setGrndLevel(grndLevel: Int?) {
        this.grndLevel = grndLevel
    }

    fun setHumidity(humidity: Int?) {
        this.humidity = humidity
    }

    fun setPressure(pressure: Int?) {
        this.pressure = pressure
    }

    fun setSeaLevel(seaLevel: Int?) {
        this.seaLevel = seaLevel
    }

    fun setTemp(temp: Double?) {
        this.temp = temp
    }

    fun setTempKf(tempKf: Double?) {
        this.tempKf = tempKf
    }

    fun setTempMax(tempMax: Double?) {
        this.tempMax = tempMax
    }

    fun setTempMin(tempMin: Double?) {
        this.tempMin = tempMin
    }

    // toString method
    override fun toString(): String {
        return "Main(feelsLike=$feelsLike, grndLevel=$grndLevel, humidity=$humidity, pressure=$pressure, seaLevel=$seaLevel, temp=$temp, tempKf=$tempKf, tempMax=$tempMax, tempMin=$tempMin)"
    }
}
