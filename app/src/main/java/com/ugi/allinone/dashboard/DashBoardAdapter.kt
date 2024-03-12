package com.ugi.allinone.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ugi.allinone.R
import com.ugi.allinone.databinding.DashboardAppListViewholderBinding

class DashBoardAdapter(private val dashBoardModel: ArrayList<DashBoardModel>, val onListClick: (appName: String) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding: DashboardAppListViewholderBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.dashboard_app_list_viewholder,
            parent,
            false
        )
        return AppListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dashBoardModel.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is AppListViewHolder){
            holder.bind(dashBoardModel[position])
        }
    }

    inner class AppListViewHolder(private val binding: DashboardAppListViewholderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(dashBoardModel: DashBoardModel) {
            binding.dashBoardModel = dashBoardModel
            binding.executePendingBindings()

            binding.appListBtn.setOnClickListener{
                onListClick(dashBoardModel.appFeatureName)
            }
        }

    }
}