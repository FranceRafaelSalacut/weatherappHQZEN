package com.example.weatherapplication.`interface`
// Retrofit interface

import com.example.weatherapplication.model.ForecastData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesApi {
    @GET("http://api.weatherapi.com/v1/forecast.json?key=2ebf9aea9a1e493ca2b20050230707&q=Cebu&days=3&aqi=no&alerts=no")
    suspend fun getQuotes() : Response<ForecastData>
}
