package com.mardia.weatherapp.adapter


import android.widget.ImageView
import android.widget.TextView
import com.mardia.weatherapp.utils.Constants
import com.mardia.weatherapp.utils.WeatherHelperClass
import com.mardia.weatherapp.utils.WeatherSharedPref
import com.squareup.picasso.Picasso
import javax.inject.Inject


annotation class BindingAdapter(val value: Array<String>)

class CustomBindingAdapter {

    @Inject
    var weatherSharedPref: WeatherSharedPref? = null

    var tempUnit: String = Constants.MetricUnit.TEMPERATURE

    fun setTempUnit(): String? {
        tempUnit =
            if (Constants.TEMP_STATUS) Constants.ImperialUnit.TEMPERATURE else Constants.MetricUnit.TEMPERATURE
        return tempUnit
    }

    @BindingAdapter(value = arrayOf("app:setDateTime"))
    fun setDateTime(textView: TextView, dt: Long) {
        val dateTime: String = WeatherHelperClass.getDateTimeFormatter(dt, "EEE hh:mm aaa")
        textView.text = dateTime
    }

    @BindingAdapter(value = arrayOf("app:setIcon"))
    fun setIcon(imageView: ImageView?, icon: String) {
        val iconUrl: String = Constants.ICON_URL_PREFIX +
                icon + Constants.ICON_URL_SUFFIX
        Picasso.get().load(iconUrl).into(imageView)
    }

    @BindingAdapter(value = ["app:tempMax", "app:tempMin"])
    fun setMaxMinTemp(textView: TextView, max: Double, min: Double) {
        textView.text = String.format("%.0f\u00B0 / %.0f%s", max, min, setTempUnit())
    }
}