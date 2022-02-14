package com.rvsoft.covidtestgodrej.util

import androidx.recyclerview.widget.DiffUtil
import com.rvsoft.covidtestgodrej.data.model.Dashboard

class DashboardDiffUtil(
    private val old:List<Dashboard>,
    private val new:List<Dashboard>
):DiffUtil.Callback() {
    override fun getOldListSize(): Int = old.size

    override fun getNewListSize(): Int = new.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition].dateymd == new[newItemPosition].dateymd
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition] == new[newItemPosition]
    }
}