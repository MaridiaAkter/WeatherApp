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
) {
    // Getter methods
    fun getClouds(): Clouds? {
        return clouds
    }

    fun getDt(): Int? {
        return dt
    }

    fun getDtTxt(): String? {
        return dtTxt
    }

    fun getMain(): Main? {
        return main
    }

    fun getPop(): Double? {
        return pop
    }

    fun getRain(): Rain? {
        return rain
    }

    fun getSys(): Sys? {
        return sys
    }

    fun getVisibility(): Int? {
        return visibility
    }

    fun getWeather(): List<Weather?>? {
        return weather
    }

    fun getWind(): Wind? {
        return wind
    }

    // Setter methods
    fun setClouds(clouds: Clouds?) {
        this.clouds = clouds
    }

    fun setDt(dt: Int?) {
        this.dt = dt
    }

    fun setDtTxt(dtTxt: String?) {
        this.dtTxt = dtTxt
    }

    fun setMain(main: Main?) {
        this.main = main
    }

    fun setPop(pop: Double?) {
        this.pop = pop
    }

    fun setRain(rain: Rain?) {
        this.rain = rain
    }

    fun setSys(sys: Sys?) {
        this.sys = sys
    }

    fun setVisibility(visibility: Int?) {
        this.visibility = visibility
    }

    fun setWeather(weather: List<Weather?>?) {
        this.weather = weather
    }

    fun setWind(wind: Wind?) {
        this.wind = wind
    }

    // toString method
    override fun toString(): String {
        return "DataList(clouds=$clouds, dt=$dt, dtTxt=$dtTxt, main=$main, pop=$pop, rain=$rain, sys=$sys, visibility=$visibility, weather=$weather, wind=$wind)"
    }
}
