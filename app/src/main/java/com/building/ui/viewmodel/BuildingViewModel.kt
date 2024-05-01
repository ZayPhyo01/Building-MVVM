package com.building.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.building.data.repository.BuildingRepository
import com.building.domain.model.building.BuildingModel

class BuildingViewModel(
    private val buildingRepository: BuildingRepository
) : ViewModel() {


    private val _buildingListLiveData = MutableLiveData<List<BuildingModel>>()
    val buildingListLiveData: LiveData<List<BuildingModel>> = _buildingListLiveData

    init {
        Log.d("call", "buildingViewModel")
        val buildingList = buildingRepository.getBuildingList()
        _buildingListLiveData.value = buildingList
    }

}
// viewmodel -> obj , state -> operation
// app open -> building list api 10 sec 9 8 7 6 5
// rotate building list api 10 9 8 7 6 5

