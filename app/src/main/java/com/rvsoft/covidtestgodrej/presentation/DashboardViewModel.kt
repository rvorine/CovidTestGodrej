package com.rvsoft.covidtestgodrej.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rvsoft.covidtestgodrej.data.model.Dashboard
import com.rvsoft.covidtestgodrej.data.model.Dist
import com.rvsoft.covidtestgodrej.db.repository.DBRepository
import com.rvsoft.covidtestgodrej.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repository: Repository,
    private val db:DBRepository
):ViewModel() {

    private val _result = MutableLiveData<List<Dashboard>>()
    val result:MutableLiveData<List<Dashboard>>
    get() = _result

    private val _sates = MutableLiveData<List<Dist>>()
    val state:MutableLiveData<List<Dist>>
    get() = _sates

    fun fetchDashboardData() = viewModelScope.launch(Dispatchers.IO) {
        repository.getDashboard().let {
            if (it.isSuccessful){
                viewModelScope.launch(Dispatchers.Main) {
                    _result.value = it.body()?.cases_time_series
                    db.insertOrUpdateDashboard(it.body()!!.cases_time_series)
                }
            }else{
                Log.d("DashboardViewModel",it.message())
            }
        }
    }

    fun getFromDatabase():LiveData<List<Dashboard>> = db.getDashboard()

    fun fetchDistrictViseData() = viewModelScope.launch(Dispatchers.IO){
        repository.getDistrictViseData().let {
            if (it.isSuccessful){
                Log.d("fetchDistrictViseData",it.body().toString())
                it.body()?.let { state->
                    val array = ArrayList<Dist>()
                    array.add(state.maharashtra.districtData.Ahmednagar.apply { name="Ahmednagar" })
                    array.add(state.maharashtra.districtData.Akola.apply { name="Akola" })
                    array.add(state.maharashtra.districtData.Amravati.apply { name="Amravati" })
                    array.add(state.maharashtra.districtData.Mumbai.apply { name="Mumbai" })
                    array.add(state.maharashtra.districtData.Nagpur.apply { name="Nagpur" })
                    viewModelScope.launch(Dispatchers.Main){
                        _sates.value = array
                    }
                }
            }else{
                Log.d("fetchDistrictViseData",it.message())
            }
        }
    }
}