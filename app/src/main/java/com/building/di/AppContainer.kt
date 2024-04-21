package com.building.di

import com.building.data.datasource.BuildingRemoteDataSource
import com.building.data.repository.BuildingRepository
import com.building.data.service.BuildingNetworkService
import com.building.ui.viewmodel.BuildingDetailViewModel

class AppContainer {
    private val buildingNetworkService = BuildingNetworkService()

    private val buildingRemoteDataSource = BuildingRemoteDataSource(buildingNetworkService)

    val buildingRepository = BuildingRepository(buildingRemoteDataSource)

    fun getBuildingDetailViewModel(id: String) = BuildingDetailViewModel(
        id,
        buildingRepository = buildingRepository
    )
}