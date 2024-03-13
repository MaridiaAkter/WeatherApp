package com.mardia.weatherapp.models.currentweather


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("description")
    @Expose
    var description: String? = null,

    @SerializedName("icon")
    @Expose
    var icon: String? = null,

    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("main")
    @Expose
    var main: String? = null
) {
    // Getter methods
    fun getDescription(): String? {
        return description
    }

    fun getIcon(): String? {
        return icon
    }

    fun getId(): Int? {
        return id
    }

    fun getMain(): String? {
        return main
    }

    // Setter methods
    fun setDescription(description: String?) {
        this.description = description
    }

    fun setIcon(icon: String?) {
        this.icon = icon
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun setMain(main: String?) {
        this.main = main
    }

    // toString method
    override fun toString(): String {
        return "Weather(description=$description, icon=$icon, id=$id, main=$main)"
    }
}
