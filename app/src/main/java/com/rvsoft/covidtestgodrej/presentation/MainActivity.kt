package com.rvsoft.covidtestgodrej.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.rvsoft.covidtestgodrej.R
import com.rvsoft.covidtestgodrej.data.model.Dist
import com.rvsoft.covidtestgodrej.databinding.ActivityMainBinding
import com.rvsoft.covidtestgodrej.presentation.adapter.DashboardAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val vm:DashboardViewModel by viewModels()
    lateinit var binding:ActivityMainBinding

    private val adapter:DashboardAdapter by lazy { DashboardAdapter(this, ArrayList()) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        initRecyclerview()
        initStateSpinner()
        vm.fetchDashboardData()
        vm.fetchDistrictViseData()

        binding.btnDetails.setOnClickListener {
            val dist = vm.state.value?.get(binding.stateSpinner.selectedItemPosition)
            Intent(this,DetailsActivity::class.java).apply {
                putExtra("details",dist)
            }.also { startActivity(it) }
        }
    }

    private fun initStateSpinner() {
        vm.state.observe(this){ list->
            val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,list.map { it.name })
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.stateSpinner.adapter = arrayAdapter
            binding.stateSpinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Log.d("initStateSpinner",list[position].name)
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

            }
        }
    }

    private fun initRecyclerview() {
        binding.dashboardList.adapter = adapter

        // this from API
        vm.result.observe(this){
            val listData = it.takeLast(5)
            adapter.setList(listData)
        }

        // fetched and retrived from db
        /*vm.getFromDatabase().observe(this){
            adapter.setList(it.takeLast(5))
        }*/
    }
}