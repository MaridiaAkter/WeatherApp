package com.mardia.weatherapp.adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.mardia.weatherapp.utils.Constants
import com.mardia.weatherapp.utils.WeatherHelperClass
import com.mardia.weatherapp.utils.WeatherSharedPref
import com.squareup.picasso.Picasso
import javax.inject.Inject

class CustomBindingAdapter {

    var weatherSharedPref: WeatherSharedPref? = null
        @Inject set

    companion object {
        var tempUnit: String = Constants.MetricUnit.TEMPERATURE
        fun setTempUnit(): String {
            if (Constants.TEMP_STATUS) tempUnit = Constants.ImperialUnit.TEMPERATURE else tempUnit =
                Constants.MetricUnit.TEMPERATURE
            return tempUnit
        }
    }
}

@BindingAdapter(value = ["app:setDateTime"])
fun setDateTime(textView: TextView, dt: Int) {
    val dateTime: String = WeatherHelperClass.getDateTimeFormatter(dt, "EEE hh:mm aaa")
    textView.text = dateTime
}

@BindingAdapter(value = ["app:setIcon"])
fun setIcon(imageView: ImageView?, icon: String) {
    val iconUrl: String = Constants.ICON_URL_PREFIX +
            icon + Constants.ICON_URL_SUFFIX
    Picasso.get().load(iconUrl).into(imageView)
}

@BindingAdapter(value = ["app:tempMax", "app:tempMin"])
fun setMaxMinTemp(textView: TextView, max: Double, min: Double) {
    textView.text = String.format("%.0f\u00B0 / %.0f%s", max, min,
        CustomBindingAdapter.setTempUnit()
    )
}