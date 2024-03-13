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
    var list: List<DataList?>? = null,

    @SerializedName("message")
    @Expose
    var message: Int? = null
) {
    // Getter methods
    fun getCity(): City? {
        return city
    }

    fun getCnt(): Int? {
        return cnt
    }

    fun getCod(): String? {
        return cod
    }

    fun getList(): List<DataList?>? {
        return list
    }

    fun getMessage(): Int? {
        return message
    }

    // Setter methods
    fun setCity(city: City?) {
        this.city = city
    }

    fun setCnt(cnt: Int?) {
        this.cnt = cnt
    }

    fun setCod(cod: String?) {
        this.cod = cod
    }

    fun setList(list: List<DataList?>?) {
        this.list = list
    }

    fun setMessage(message: Int?) {
        this.message = message
    }

    // toString method
    override fun toString(): String {
        return "ForecastRootModel(city=$city, cnt=$cnt, cod=$cod, list=$list, message=$message)"
    }
}
