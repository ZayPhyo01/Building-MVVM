package com.building.data.repository

import android.util.Log
import com.building.data.datasource.BuildingRemoteDataSource
import com.building.domain.model.building.BuildingModel

class BuildingRepository(
    private val buildingRemoteDataSource: BuildingRemoteDataSource
) {

    val id : String = ""

    fun getBuildingList(): List<BuildingModel> {
        Log.d("call", "execute")
        return buildingRemoteDataSource.getBuildingList()
    }

    fun getBuildingDetail(id: String): BuildingModel {
        return buildingRemoteDataSource.getBuildingDetail(id)
    }
}

// building list -> rotate -> network 5 sec -> data -> viewModel -> ui
//MainActivity -> click -> id -> viewmodel -> repo
//Detail <- viewmodel <-id - < repo