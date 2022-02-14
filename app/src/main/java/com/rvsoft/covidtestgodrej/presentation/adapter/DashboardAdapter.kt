package com.rvsoft.covidtestgodrej.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.rvsoft.covidtestgodrej.R
import com.rvsoft.covidtestgodrej.data.model.Dashboard
import com.rvsoft.covidtestgodrej.databinding.DashboardListItemBinding
import com.rvsoft.covidtestgodrej.util.DashboardDiffUtil

class DashboardAdapter(
    private val context: Context,
    private val mList:ArrayList<Dashboard>
):RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {
    class ViewHolder(val binding:DashboardListItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<DashboardListItemBinding>(
            LayoutInflater.from(context),
            R.layout.dashboard_list_item,
            parent,
            false
        )
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(h: ViewHolder, position: Int) {
        h.binding.data = mList[position]
    }

    override fun getItemCount(): Int = mList.size


    fun setList(list: List<Dashboard>){
        val old = mList
        val callback = DashboardDiffUtil(old,list)
        val result = DiffUtil.calculateDiff(callback)
        mList.clear()
        mList.addAll(list)
        result.dispatchUpdatesTo(this)
    }
}