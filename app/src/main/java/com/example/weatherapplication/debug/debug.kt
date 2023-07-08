package com.example.weatherapplication.debug

import android.util.Log
import com.example.weatherapplication.model.ForecastData
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener
import java.io.IOException

//***********************************************************************//
//
//This is a dump kotlin file. used for testing and dunmping of unusable
//reusable pieces of data. This is just a dump of code that could be useful
//
//***********************************************************************//
class debug {
    fun apiCall(url: String){
        Log.d("This", "You are in debug bruh")
        val client = OkHttpClient()

        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                //Log.d("This", response.body()?.string() ?: "NULL")
                val responseData = response.body()?.string()?:"NULL"

                val jsonTokener = JSONTokener(responseData)
                val data = jsonTokener.nextValue()

                if(data is JSONObject){
                    jsonObjectHandler(data)
                }else if (data is JSONArray){
                    jsonArrayHandler(data)
                }

            }

            override fun onFailure(call: Call, e: IOException) {
                Log.d("This", e.toString())
            }

        })
    }

    private fun jsonObjectHandler(jsonObject : JSONObject){
        for(key in jsonObject.keys()) {
            Log.d("This",  key)
            val temp = jsonObject.get(key)
            if(comparator(temp)){
                Log.d("This", "->${jsonObject.get(key).toString()}")
            }
        }
        /*for(key in jsonObject.keys()){
            Log.d("This", key)
            val temp = jsonObject.get(key)
            if(temp is JSONObject){
                jsonObjectHandler(temp)
            }else if (temp is JSONArray){
                jsonArrayHandler(temp)
            }else if (temp is String){
                printString(jsonObject)
            }
        }*/
        /*for(key in jsonObject.keys()){
            Log.d("This", "----------------------------")
            Log.d("This", key)
            Log.d("This", "----------------------------")
            val jsonArray = jsonObject.getJSONObject(key)
                for(keyed in jsonArray.keys()){
                    Log.d("This", keyed)
                }
        }*/
    }
    private fun jsonArrayHandler(jsonArray : JSONArray){
        for(i in 0 until jsonArray.length()){
            val temp = jsonArray.get(i)
            if(comparator(temp)){
                //do nothing
            }
        }
    }

    private fun printString(jsonObject : JSONObject){
        for(keys in jsonObject.keys()){
            Log.d("This", "$keys + ${jsonObject.getString(keys)}")
        }
        Log.d("This", "---------------------")
    }

    private fun jsonArrayHandlerOLD(jsonArray : JSONArray){
        for(i in 0 until jsonArray.length()){
            val id = jsonArray.getJSONObject(i)
            Log.d("This", id.keys().toString())
            for(keys in id.keys()){
                Log.d("This", "$keys + ${id.getString(keys)}")
            }
            Log.d("This", "---------------------")

        }
    }

    private fun comparator(temp: Any): Boolean{
        if(temp is JSONObject){
            jsonObjectHandler(temp)
        }else if (temp is JSONArray){
            jsonArrayHandler(temp)
        }else{
            return true
        }
        return false
    }

    /*private fun apiCall(url: String){
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                //Log.d("This", response.body()?.string() ?: "NULL")
                val responseData = response.body()?.string()?:"NULL"

                val jsonTokener = JSONTokener(responseData)
                val jsonObject = jsonTokener.nextValue() as JSONArray

                for(i in 0 until jsonObject.length()){
                    val id = jsonObject.getJSONObject(i)
                    Log.d("This", id.keys().toString())
                    for(keys in id.keys()){
                        Log.d("This", "$keys + ${id.getString(keys)}")
                    }
                    Log.d("This", "---------------------")

                }
            }

            override fun onFailure(call: Call, e: IOException) {
                Log.d("This", e.toString())
            }

        })
    }*/

    /*val location: ForecastData.location = __init__location(data.getJSONObject("location"))
                Log.d("this", location.toString())
                val current: ForecastData.current = __init__current(data.getJSONObject("current"))
                Log.d("this", current.toString())*/

    /*private fun __init__location(data: JSONObject): ForecastData.location {
        return ForecastData.location(
            name = data.getString("name"),
            region = data.getString("region"),
            country = "nothing",
            lat = data.getDouble("lat"),
            lon = data.getDouble("lon"),
            tz_id = data.getString("tz_id"),
            localtime_epoch = data.getInt("localtime_epoch"),
            localtime = data.getString("localtime")
        )
    }

    private fun __init__current(data: JSONObject) : ForecastData.current{
        return ForecastData.current(
            last_updated_epoch = data.getInt("last_updated_epoch"),
            last_updated = data.getString("last_updated"),
            temp_c = data.getDouble("temp_c"),
            temp_f = data.getDouble("temp_f"),
            is_day = data.getInt("is_day"),
            condition = __init__condition(data.getJSONObject("condition")),
            wind_mph = data.getDouble("wind_mph"),
            wind_kph = data.getDouble("wind_kph"),
            wind_degree = data.getInt("wind_degree"),
            wind_dir = data.getString("wind_dir"),
            pressure_mb = data.getDouble("pressure_mb"),
            pressure_in = data.getDouble("pressure_in"),
            precip_mm = data.getDouble("precip_mm"),
            precip_in = data.getDouble("precip_in"),
            humidity = data.getInt("humidity"),
            cloud = data.getInt("cloud"),
            feelslike_c = data.getDouble("feelslike_c"),
            feelslike_f = data.getDouble("feelslike_f"),
            vis_km = data.getDouble("vis_km"),
            vis_miles = data.getDouble("vis_miles"),
            uv = data.getDouble("uv"),
            gust_mph = data.getDouble("gust_mph"),
            gust_kph = data.getDouble("gust_kph")
        )
    }

    private fun __init__forecast(data: JSONObject) *//*: ForecastData.forecast*//*{
        *//*return forecast*//*
    }

    private fun __init__condition(data: JSONObject): ForecastData.condition{
        return ForecastData.condition(
            text = data.getString("text"),
            icon = data.getString("icon"),
            code = data.getInt("code")
        )
    }

*/

}