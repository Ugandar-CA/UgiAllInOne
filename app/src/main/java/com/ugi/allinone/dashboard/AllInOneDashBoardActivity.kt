package com.ugi.allinone.dashboard

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ugi.allinone.R
import com.ugi.allinone.databinding.AllInOneDashboardActivityLayoutBinding
import com.ugi.allinone.main.BaseActivity
import com.ugi.allinone.todolistapp.TodoListActivity
import com.ugi.allinone.weatherapp.WeatherAppActivity

class AllInOneDashBoardActivity : BaseActivity() {

    private lateinit var allInOneDashboardActivityLayoutBinding: AllInOneDashboardActivityLayoutBinding

    private lateinit var appListAdapter: DashBoardAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        allInOneDashboardActivityLayoutBinding =
            AllInOneDashboardActivityLayoutBinding.inflate(layoutInflater)
        setContentView(allInOneDashboardActivityLayoutBinding.root)
        initiateAdapter()
    }

    private fun initiateAdapter() {
        appListAdapter = DashBoardAdapter(getAdapterList(), ::handleClickListerner)
        allInOneDashboardActivityLayoutBinding.appList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        allInOneDashboardActivityLayoutBinding.appList.adapter = appListAdapter
    }

    private fun getAdapterList(): ArrayList<DashBoardModel> {
        val appList = ArrayList<DashBoardModel>()
        appList.add(DashBoardModel(this.getString(R.string.weather_app)))
        appList.add(DashBoardModel(this.getString(R.string.to_do_list_app)))
        return appList
    }

    private fun handleClickListerner(appName: String) {
        when (appName) {
            this.getString(R.string.weather_app) -> {
                val intent = Intent(this, WeatherAppActivity::class.java)
                startActivity(intent)
            }

            this.getString(R.string.to_do_list_app) -> {
                val intent = Intent(this, TodoListActivity::class.java)
                startActivity(intent)
            }
        }

    }
}