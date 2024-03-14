package com.mardia.weatherapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mardia.weatherapp.adapter.ForecastAdapter
import com.mardia.weatherapp.databinding.FragmentMainBinding
import com.mardia.weatherapp.models.currentweather.CurrentWeatherRootModel
import com.mardia.weatherapp.models.forecast.ForecastRootModel
import com.mardia.weatherapp.utils.Constants
import com.mardia.weatherapp.utils.DeviceLocation
import com.mardia.weatherapp.utils.LocationPermissions
import com.mardia.weatherapp.utils.WeatherHelperClass
import com.mardia.weatherapp.utils.WeatherSharedPref
import com.mardia.weatherapp.viewmodels.MainFragmentViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainFragment : Fragment() {
    // Initialize variable
    private var binding: FragmentMainBinding? = null
    private var view: View? = null
    private var mainFragmentViewModel: MainFragmentViewModel? = null

    @Inject
    var locationPermissions: LocationPermissions? = null

    @Inject
    var deviceLocation: DeviceLocation? = null

    @Inject
    var weatherSharedPref: WeatherSharedPref? = null

    @Inject
    var currentWeatherRootModel: CurrentWeatherRootModel? =null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Assign variable
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        view = binding?.root
        if (view == null) {
            return null
        }
        mainFragmentViewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)

        // menu setting only in this fragment
        setHasOptionsMenu(true)

        // initialize values
        mainFragmentViewModel!!.loadData()
        weatherSharedPref?.let { setUnits(it.getTempUnit()) }
        weatherSharedPref?.let { setConstTemp(it.getTempUnit()) }

        // 2nd call of loadData after 1 second
        doItLater()

        // RecyclerView setup
        val adapter = ForecastAdapter()
        val llm = LinearLayoutManager(activity)
        llm.orientation = RecyclerView.VERTICAL
        binding?.forecastRV?.layoutManager = llm
        binding?.forecastRV?.adapter = adapter

        // load previously checked or unchecked configuration on switch
        binding?.tempUnitSwitch?.isChecked = weatherSharedPref?.getTempUnit() ?: false

        // set the changed tempUnit and load the data again
        binding?.tempUnitSwitch?.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            weatherSharedPref?.setTempUnit(isChecked)
            setUnits(isChecked)
            setConstTemp(isChecked)
            mainFragmentViewModel?.loadData()
        })
        mainFragmentViewModel?.getCurrentLiveData()?.observe(viewLifecycleOwner,
            Observer<Any?> { currentWeatherRootModel -> setData(currentWeatherRootModel as CurrentWeatherRootModel) })

        // set forecast data into RecyclerView
        mainFragmentViewModel?.getForecastLiveData()?.observe(viewLifecycleOwner,
            Observer<Any?> { forecastRootModel -> adapter.submitList(forecastRootModel as List<ForecastRootModel>) })
        mainFragmentViewModel?.errMsgLiveData
            ?.observe(viewLifecycleOwner, object : Observer<String?> {
                override fun onChanged(msg: String?) {
                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
                }
            })

        // Return view
        return view
    }


    @SuppressLint("SetTextI18n", "DefaultLocale")
    private fun setData(currentWeatherRootModel: CurrentWeatherRootModel) {
        setText()
        setText()
        setText()
        setText()
        binding?.currentWeatherDescriptionTV?.setText(
            currentWeatherRootModel.getWeather()?.get(0)?.getDescription()?.let {
                WeatherHelperClass.capitalizeWord(
                    it
                )
            }
        )
        val iconUrl: String = Constants.ICON_URL_PREFIX +
                currentWeatherRootModel.getWeather()?.get(0)?.getIcon() +
                Constants.ICON_URL_SUFFIX_4X
        Picasso.get().load(iconUrl).into(binding?.currentIconIV)
        setText()
        binding?.currentMaxMinTempTV?.setText(
            java.lang.String.format(
                "%.0f\u00B0 / %.0f%s", currentWeatherRootModel.getMain()?.getTempMax(),
                currentWeatherRootModel.getMain()?.getTempMin(), tempUnit
            )
        )
        binding?.currentHumidityTV?.text = currentWeatherRootModel.getMain()?.getHumidity()?.toString() + "%"
        binding?.currentWindTV?.text = (currentWeatherRootModel.getWind()?.getSpeed()?.toString() ?: "") + " " + windSpeed
        binding?.currentPressureTV?.text = (currentWeatherRootModel.getMain()?.getPressure()?.toString() ?: "") + " hPa"


        // when rain class is not found or null
        binding?.currentRainTV?.text = (currentWeatherRootModel.getRain()?.getH()?.toString() ?: "0") + " mm"

    }

    // set the units based on switch
    private fun setUnits(fahrenheit: Boolean) {
        if (fahrenheit) {
            tempUnit = Constants.ImperialUnit.TEMPERATURE
            windSpeed = Constants.ImperialUnit.WIND_SPEED
        } else {
            tempUnit = Constants.MetricUnit.TEMPERATURE
            windSpeed = Constants.MetricUnit.WIND_SPEED
        }
    }

    // change the value of Constant Class for use in Binding Adapter Class
    private fun setConstTemp(status: Boolean) {
        Constants.TEMP_STATUS = status
    }

    // 2nd time loadData call
    private fun doItLater() {
        // When location is on, in first time weather repositories lat and lon returning 0.0
        // So, there is the 2nd iteration of of loadData for update UI
        if (deviceLocation?.isEnabled == true) {
            val handler = Handler(Looper.getMainLooper())
            handler.postDelayed({ //Do something after 1000ms (1 second)
                mainFragmentViewModel?.loadData()
            }, 1000)
        }
    }

    // menu set-up
    // SearchView on Menu Toolbar
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.search_menu, menu)
        val searchViewItem = menu.findItem(R.id.search_city)
        val searchView = searchViewItem.actionView as SearchView?
        if (searchView != null) {
            searchView.queryHint = "Find your city"
        }
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                searchView.clearFocus()

                // set the searched city in weather repository through mainFragmentViewModel
                mainFragmentViewModel?.setCity(query)
                mainFragmentViewModel?.loadData()
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                // arrayAdapter.getFilter().filter(newText);
                return false
            }
        })
    }

    // menu listener
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.search_city) {
            // when clicked on search menu
        } else if (item.itemId == R.id.my_location) {
            locationPermissions?.locationEnable()
            if (deviceLocation?.isEnabled == true) {
                mainFragmentViewModel?.setCity(null)
                mainFragmentViewModel?.loadData()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        private var tempUnit: String = Constants.MetricUnit.TEMPERATURE
        private var windSpeed: String = Constants.MetricUnit.WIND_SPEED
    }
}

private fun setText() {

}
