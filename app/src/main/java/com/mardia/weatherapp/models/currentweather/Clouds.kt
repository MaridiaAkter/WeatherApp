package com.mardia.weatherapp.models.currentweather


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Clouds(
    @SerializedName("all")
    @Expose
    var all: Int? = null
) {
    // Getter method for 'all' property
    fun getAll(): Int? {
        return all
    }

    // Setter method for 'all' property
    fun setAll(all: Int?) {
        this.all = all
    }

    // toString method
    override fun toString(): String {
        return "Clouds(all=$all)"
    }
}
