package com.mardia.weatherapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mardia.weatherapp.models.currentweather.CurrentWeatherRootModel
import com.mardia.weatherapp.models.forecast.ForecastRootModel
import com.mardia.weatherapp.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainFragmentViewModel @Inject constructor() : ViewModel() {
    @Inject
    var weatherRepository: WeatherRepository? = null
    private var currentLiveData: MutableLiveData<CurrentWeatherRootModel>? = null
    private var forecastLiveData: MutableLiveData<ForecastRootModel>? = null
    var errMsgLiveData: MutableLiveData<String>? = null
        private set

    fun getCurrentLiveData(): MutableLiveData<CurrentWeatherRootModel>? {
        return currentLiveData
    }

    fun getForecastLiveData(): MutableLiveData<ForecastRootModel>? {
        return forecastLiveData
    }

    fun setCity(city: String?) {
        if (city != null) {
            weatherRepository?.setCity(city)
        }
    }

    fun loadData() {
        weatherRepository?.loadCurrentData()
        weatherRepository?.loadForecastData()
        setAllLiveData()
    }

    private fun setAllLiveData() {
        currentLiveData = weatherRepository?.getRepoCurrentLiveData()
        forecastLiveData = weatherRepository?.getRepoForecastLiveData()
        errMsgLiveData = weatherRepository?.getRepoErrMsgLiveData()
    }
}
