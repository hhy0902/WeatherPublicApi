package com.example.weatherpublicapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherpublicapi.data.Item
import org.w3c.dom.Text

class WeatherAdapter(val itemList : Array<ModelWeather>,
val layoutInflater: LayoutInflater) : RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val category : TextView
        val rain : TextView
        val sky : TextView
        val time : TextView
        val humidity : TextView

        init {
            category = itemView.findViewById(R.id.category)
            rain = itemView.findViewById(R.id.rain)
            sky = itemView.findViewById(R.id.sky)
            time = itemView.findViewById(R.id.time)
            humidity = itemView.findViewById(R.id.humidity)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherAdapter.ViewHolder {
        val view = layoutInflater.inflate(R.layout.recyclerview_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherAdapter.ViewHolder, position: Int) {
        holder.category.text = "기온 : ${itemList.get(position).temp}°"
        when(itemList.get(position).sky) {
            "1" -> holder.sky.text = "하늘상태 : 맑음"
            "3" -> holder.sky.text = "하늘상태 : 구름많음"
            "4" -> holder.sky.text = "하늘상태 : 흐림"
            else -> holder.sky.text = "하늘상태 : 몰?루"
        }
        //holder.sky.text = itemList.get(position).sky
        when(itemList.get(position).rainType) {
            "1" -> holder.rain.text = "강수형태 : 비"
            else -> holder.rain.text = "강수형태 : 없음"
        }
        holder.humidity.text = "습도 : ${itemList.get(position).humidity}%"
        holder.time.text = itemList.get(position).fcstTime
        //holder.rain.text = itemList.get(position).rainType


    }

    override fun getItemCount(): Int {
        return itemList.size
    }


}