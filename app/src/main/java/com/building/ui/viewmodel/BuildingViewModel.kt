package com.building.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.building.data.repository.BuildingRepository
import com.building.domain.model.building.BuildingModel

class BuildingViewModel(
    private val buildingRepository: BuildingRepository
) {


    private val _buildingListLiveData = MutableLiveData<List<BuildingModel>>()
    val buildingListLiveData: LiveData<List<BuildingModel>> = _buildingListLiveData


    init {
        val buildingList = buildingRepository.getBuildingList()
        _buildingListLiveData.value = buildingList

    }
}