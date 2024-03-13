package com.mardia.weatherapp.models.forecast


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("coord")
    @Expose
    var coord: Coord? = null,

    @SerializedName("country")
    @Expose
    var country: String? = null,

    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("population")
    @Expose
    var population: Int? = null,

    @SerializedName("sunrise")
    @Expose
    var sunrise: Int? = null,

    @SerializedName("sunset")
    @Expose
    var sunset: Int? = null,

    @SerializedName("timezone")
    @Expose
    var timezone: Int? = null
) {
    // Getter methods
    fun getCoord(): Coord? {
        return coord
    }

    fun getCountry(): String? {
        return country
    }

    fun getId(): Int? {
        return id
    }

    fun getName(): String? {
        return name
    }

    fun getPopulation(): Int? {
        return population
    }

    fun getSunrise(): Int? {
        return sunrise
    }

    fun getSunset(): Int? {
        return sunset
    }

    fun getTimezone(): Int? {
        return timezone
    }

    // Setter methods
    fun setCoord(coord: Coord?) {
        this.coord = coord
    }

    fun setCountry(country: String?) {
        this.country = country
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun setPopulation(population: Int?) {
        this.population = population
    }

    fun setSunrise(sunrise: Int?) {
        this.sunrise = sunrise
    }

    fun setSunset(sunset: Int?) {
        this.sunset = sunset
    }

    fun setTimezone(timezone: Int?) {
        this.timezone = timezone
    }

    // toString method
    override fun toString(): String {
        return "City(coord=$coord, country=$country, id=$id, name=$name, population=$population, sunrise=$sunrise, sunset=$sunset, timezone=$timezone)"
    }
}
