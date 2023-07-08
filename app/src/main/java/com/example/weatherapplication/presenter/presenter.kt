package com.example.weatherapplication.presenter

import android.util.Log
import com.example.weatherapplication.`interface`.Contract
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener
import java.io.IOException

class presenter ( private var mainView: Contract.View, private var model: Contract.Model) : Contract.Presenter {

    /*override  fun onButtonClick() {
        Log.d("this", "You clicked me? ")
        val URL = mainView.constructURL()
        if(model.__init__data(URL)){
            mainView.display("API CALL SUCESS")
        }else{
            mainView.display("API CALL BAD")
        }

    }*/

    override fun onButtonClick() {
        Log.d("this", "Temporary")
        val URL = mainView.constructURL()
        model.__init__data(URL)
    }
}
