package com.example.weatherapplication.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import kotlinx.serialization.decodeFromString
import android.util.Log
import com.example.weatherapplication.debug.debug
import com.example.weatherapplication.`interface`.Contract
import kotlinx.serialization.json.decodeToSequence
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener
import java.io.IOException

class Model :  Contract.Model{

    var forecastData: ForecastData.forecastData?= null

    override fun __init__data(URL:String)/*:Boolean*/{
        Log.d("this", URL)
        //debug().apicall(URL)
        /*return apiCall(URL)*/
        apiCall(URL)
    }

    fun apiCall(url: String)/*: Boolean*/{
        Log.d("This", "you are in the real world now")
       /* var success: Boolean = false*/
        val client = OkHttpClient()

        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                //Log.d("This", response.body()?.string() ?: "NULL")
               /* success = true*/
                val responseData = response.body()?.string()?:"NULL"

                val jsonTokener = JSONTokener(responseData)
                val data = jsonTokener.nextValue() as JSONObject

                forecastData = Json.decodeFromString<ForecastData.forecastData>(data.toString())
                Log.d("this", forecastData.toString())
                Log.d("this", forecastData!!.location.name)



                /*val location = Json.decodeFromString<ForecastData.location>(data.getJSONObject("location").toString())
                Log.d("this", location.toString())
                val current = Json.decodeFromString<ForecastData.current>(data.getJSONObject("current").toString())
                Log.d("this", current.toString())
                val forecast = Json.decodeFromString<ForecastData.forecast>(data.getJSONObject("forecast").toString())
                //Log.d("this", data.getJSONObject("forecast").getJSONArray("forecastday").toString())
                Log.d("this", forecast.toString())*/

            }

            override fun onFailure(call: Call, e: IOException) {
                Log.d("This", e.toString())
            }

        })

        /*return success*/
    }
}