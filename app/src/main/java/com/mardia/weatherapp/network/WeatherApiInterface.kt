package com.mardia.weatherapp.network

import com.mardia.weatherapp.models.currentweather.CurrentWeatherRootModel
import com.mardia.weatherapp.models.forecast.ForecastRootModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface WeatherApiInterface {
    @GET
    fun getCurrentWeather(@Url currWeatherUrl: String?): Call<CurrentWeatherRootModel>

    @GET
    fun getForecast(@Url forecastUrl: String?): Call<ForecastRootModel>

}

