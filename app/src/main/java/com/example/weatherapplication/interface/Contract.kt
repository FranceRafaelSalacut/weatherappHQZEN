package com.example.weatherapplication.`interface`

interface Contract {

    interface View{
        fun constructURL(): String
        fun display(display:String)
    }

    interface Model{
        fun __init__data(URL:String)
        /*fun __init__data(URL:String): Boolean*/
    }

    interface Presenter{
        fun onButtonClick()
    }

}