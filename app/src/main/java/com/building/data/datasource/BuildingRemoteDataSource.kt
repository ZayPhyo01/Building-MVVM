package com.building.data.datasource

import android.util.Log
import com.building.data.mapper.toModel
import com.building.data.mapper.toModels
import com.building.data.service.BuildingNetworkService
import com.building.domain.model.building.BuildingAddress
import com.building.domain.model.building.BuildingModel

class BuildingRemoteDataSource(
    private val buildingNetworkService: BuildingNetworkService
) {

    fun getBuildingList(): List<BuildingModel> {
        val buildingResponse = buildingNetworkService.getBuildingList()
        return buildingResponse.toModels()
    }

    fun getBuildingDetail(id: String): BuildingModel {
        val buildingResponse = buildingNetworkService.getBuildingDetail(id)
        Log.d("response" , buildingResponse.toString())
        return buildingResponse.toModel()
    }
}