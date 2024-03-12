package com.mardia.weatherapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mardia.weatherapp.databinding.ForecastSampleRowBinding

class ForecastAdapter : RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder>() {

    private var items: List<List> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val forecastBinding = ForecastSampleRowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ForecastViewHolder(forecastBinding)
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(items: List<List>) {
        this.items = items
        notifyDataSetChanged()
    }

    inner class ForecastViewHolder(private val forecastBinding: ForecastSampleRowBinding) :
        RecyclerView.ViewHolder(forecastBinding.root) {
        fun bind(item: List) {
            forecastBinding.forecastList = item
        }
    }
}
