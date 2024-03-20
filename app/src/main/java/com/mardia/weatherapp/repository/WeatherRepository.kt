package com.mardia.weatherapp.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mardia.weatherapp.models.currentweather.CurrentWeatherRootModel
import com.mardia.weatherapp.models.forecast.ForecastRootModel
import com.mardia.weatherapp.network.WeatherRetrofitInstance
import com.mardia.weatherapp.utils.Constants
import com.mardia.weatherapp.utils.CurrentLocation
import com.mardia.weatherapp.utils.DeviceLocation
import com.mardia.weatherapp.utils.WeatherSharedPref
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class WeatherRepository @Inject constructor(@ApplicationContext private val context: Context) {
    private var latitude: Double = 0.0
    private var longitude: Double = 0.0
    private val TAG: String? = WeatherRepository::class.simpleName

    private var city: String? = null
    val repoCurrentLiveData: MutableLiveData<CurrentWeatherRootModel> = MutableLiveData()
    val repoForecastLiveData: MutableLiveData<ForecastRootModel> = MutableLiveData()
    val repoErrMsgLiveData: MutableLiveData<String> = MutableLiveData()

    @Inject
    lateinit var weatherSharedPref: WeatherSharedPref

    @Inject
    lateinit var location: CurrentLocation

    @Inject
    lateinit var deviceLocation: DeviceLocation

    fun setCity(city: String) {
        this.city = city
    }

    fun getUnit(): String {
        val switchStatus = weatherSharedPref.getTempUnit()
        return if (switchStatus) Constants.TempUnit.FAHRENHEIT else Constants.TempUnit.CELSIUS
    }

    private fun getLatLon() {
        if (city == null) {
            if (deviceLocation.isEnabled) {
                location.getLocation()
                latitude = location.getLat()
                longitude = location.getLon()
            } else {
                latitude = weatherSharedPref.getLastLat()
                longitude = weatherSharedPref.getLastLon()
            }
        }
    }

    fun loadCurrentData() {
        getLatLon()

        if ((latitude != 0.0 && longitude != 0.0) || city != null) {
            val endUrl = if (city == null) {
                String.format(
                    "weather?lat=%.2f&lon=%.2f&units=%s&appid=%s",
                    latitude, longitude,
                    getUnit(), Constants.OPEN_WEATHER_API_KEY
                )
            } else {
                String.format(
                    "weather?q=%s&units=%s&appid=%s",
                    city, getUnit(), Constants.OPEN_WEATHER_API_KEY
                )
            }
            WeatherRetrofitInstance.getWeatherRetrofit()?.getCurrentWeather(endUrl)
                ?.enqueue(object : Callback<CurrentWeatherRootModel> {
                    override fun onResponse(
                        call: Call<CurrentWeatherRootModel>,
                        response: Response<CurrentWeatherRootModel>
                    ) {
                        if (response.code() == 200) {
                            repoCurrentLiveData.postValue(response.body())
                        } else if (response.code() == 404) {
                            repoErrMsgLiveData.postValue(response.message())
                        }
                    }

                    override fun onFailure(call: Call<CurrentWeatherRootModel>, t: Throwable) {
                        Log.e(TAG, "onFailure: " + t.localizedMessage)
                    }
                })
        }
    }

    fun loadForecastData() {
        if ((latitude != 0.0 && longitude != 0.0) || city != null) {
            val endUrl = if (city == null) {
                String.format(
                    "forecast?lat=%.2f&lon=%.2f&units=%s&appid=%s",
                    latitude, longitude,
                    getUnit(), Constants.OPEN_WEATHER_API_KEY
                )
            } else {
                String.format(
                    "forecast?q=%s&units=%s&appid=%s",
                    city, getUnit(), Constants.OPEN_WEATHER_API_KEY
                )
            }
            WeatherRetrofitInstance.getWeatherRetrofit()?.getForecast(endUrl)
                ?.enqueue(object : Callback<ForecastRootModel> {
                    override fun onResponse(
                        call: Call<ForecastRootModel>,
                        response: Response<ForecastRootModel>
                    ) {
                        if (response.code() == 200) {
                            repoForecastLiveData.postValue(response.body())
                        }
                    }

                    override fun onFailure(call: Call<ForecastRootModel>, t: Throwable) {
                        Log.e(TAG, "onFailure: " + t.localizedMessage)
                    }
                })
        }
    }
}

