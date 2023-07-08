package com.example.weatherapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView
import com.example.weatherapplication.R
import com.example.weatherapplication.`interface`.Contract
import com.example.weatherapplication.model.Model
import com.example.weatherapplication.presenter.presenter
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener
import java.io.IOException
import kotlin.reflect.typeOf

class MainActivity : AppCompatActivity(),  Contract.View{


    private var button: Button? = null
    var presenter: presenter? = null
    private var location: AutoCompleteTextView? = null
    private var dips: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dips = findViewById<TextView>(R.id.disp)
        location = findViewById<AutoCompleteTextView>(R.id.location)

        //val location = "Cebu"
        //val url = "http://api.weatherapi.com/v1/forecast.json?key=2ebf9aea9a1e493ca2b20050230707&q=Manila&days=1&aqi=no&alerts=no"


        button = findViewById<Button>(R.id.buttonn)
        presenter = presenter(this, Model())


        this.button!!.setOnClickListener(View.OnClickListener {
            //Log.d("this", "im loggin from main ACT")
            presenter!!.onButtonClick()
        })

    }

    override fun constructURL(): String {
        val API_KEY = "2ebf9aea9a1e493ca2b20050230707"
        val call = "forecast"
        //val location = location!!.text.toString()
        val text_location = "Cebu"
        Log.d("This", location!!.text.toString())
        val url = "http://api.weatherapi.com/v1/$call.json?key=${API_KEY}&q=$text_location"

        return url
    }

    override fun display(display:String) {
        //dips!!.text = display
    }

}