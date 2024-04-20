package com.building.data.datasource

import com.building.data.service.BuildingNetworkService
import com.building.domain.model.building.BuildingAddress
import com.building.domain.model.building.BuildingModel

class BuildingRemoteDataSource {
    private val buildingNetworkService = BuildingNetworkService()

    fun getBuildingList(): List<BuildingModel> {
        val buildingResponse = buildingNetworkService.getBuildingList()
        return buildingResponse.map {
            BuildingModel(
                id = it.id,
                address = BuildingAddress(
                    location = it.location.orEmpty(),
                    region = it.region.orEmpty()
                ),
                name = it.name.orEmpty(),
                price = it.price ?: 0f,
                isFavourite = it.isFavourite ?: false
            )
        }
    }
}

data class BurgerResponse(
    val id: String,
    val name: String,
    val image : String
)


data class BurgerModel(
    val id: String,
    val name: String,
    val image: String
)

