package com.building.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.building.data.repository.BuildingRepository
import com.building.domain.model.building.BuildingModel
import com.building.ui.model.BuildingDetailUiModel

class BuildingDetailViewModel(
    private val id: String,
    private val buildingRepository: BuildingRepository
) : ViewModel() {

    private val _buildingDetailLiveData = MutableLiveData<BuildingDetailUiModel>()
    val buildingDetailLiveData: LiveData<BuildingDetailUiModel> = _buildingDetailLiveData

    init {
        val buildingModel = buildingRepository.getBuildingDetail(id)
        _buildingDetailLiveData.value = BuildingDetailUiModel(
            id = buildingModel.id,
            locationAddress = buildingModel.address.location + "/" + buildingModel.address.region,
            name = buildingModel.name
        )
    }
}