package com.ugi.allinone.weatherapp

import android.os.Bundle
import com.ugi.allinone.R
import com.ugi.allinone.main.BaseActivity

class WeatherAppActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_app)
    }
}