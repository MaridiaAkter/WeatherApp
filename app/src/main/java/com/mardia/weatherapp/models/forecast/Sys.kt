package com.mardia.weatherapp.models.forecast


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Sys(
    @SerializedName("pod")
    @Expose
    var pod: String? = null
) {
    // Getter method for 'pod' property
    fun getPod(): String? {
        return pod
    }

    // Setter method for 'pod' property
    fun setPod(pod: String?) {
        this.pod = pod
    }

    // toString method
    override fun toString(): String {
        return "Sys(pod=$pod)"
    }
}
