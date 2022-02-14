package com.rvsoft.covidtestgodrej.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.rvsoft.covidtestgodrej.R
import com.rvsoft.covidtestgodrej.data.model.Dist
import com.rvsoft.covidtestgodrej.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    lateinit var binding:ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_details)

        val details = intent.extras?.get("details") as Dist
        details?.let {
            supportActionBar?.title = details.name
            binding.dist = details
            binding.executePendingBindings()
        }
    }
}