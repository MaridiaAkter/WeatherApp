package com.mardia.weatherapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WeatherRetrofitInstance {
    private var retrofit: Retrofit? = null
    private const val baseUrl = "https://api.openweathermap.org/data/2.5/"

    fun getWeatherRetrofit(): WeatherApiInterface? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit?.create(WeatherApiInterface::class.java)
    }
}