package com.building.data.repository

import com.building.data.datasource.BuildingRemoteDataSource
import com.building.domain.model.building.BuildingModel

class BuildingRepository {

    private val buildingRemoteDataSource = BuildingRemoteDataSource()

    fun getBuildingList(): List<BuildingModel> {
        return buildingRemoteDataSource.getBuildingList()
    }
}
