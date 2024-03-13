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
) {
    // Setter methods
    fun setBase(base: String?) {
        this.base = base
    }

    fun setClouds(clouds: Clouds?) {
        this.clouds = clouds
    }

    fun setCod(cod: Int?) {
        this.cod = cod
    }

    fun setCoord(coord: Coord?) {
        this.coord = coord
    }

    fun setDt(dt: Int?) {
        this.dt = dt
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun setMain(main: Main?) {
        this.main = main
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun setRain(rain: Rain?) {
        this.rain = rain
    }

    fun setSys(sys: Sys?) {
        this.sys = sys
    }

    fun setTimezone(timezone: Int?) {
        this.timezone = timezone
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

    // Getter methods
    fun getBase(): String? {
        return base
    }

    fun getClouds(): Clouds? {
        return clouds
    }

    fun getCod(): Int? {
        return cod
    }

    fun getCoord(): Coord? {
        return coord
    }

    fun getDt(): Int? {
        return dt
    }

    fun getId(): Int? {
        return id
    }

    fun getMain(): Main? {
        return main
    }

    fun getName(): String? {
        return name
    }

    fun getRain(): Rain? {
        return rain
    }

    fun getSys(): Sys? {
        return sys
    }

    fun getTimezone(): Int? {
        return timezone
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

    // toString() method
    override fun toString(): String {
        return "CurrentWeatherRootModel(base=$base, clouds=$clouds, cod=$cod, coord=$coord, dt=$dt, id=$id, main=$main, name=$name, rain=$rain, sys=$sys, timezone=$timezone, visibility=$visibility, weather=$weather, wind=$wind)"
    }
}
