package com.building.data.service

import com.building.data.model.reponse.BuildingResponse
import com.building.domain.model.building.BuildingModel

class BuildingNetworkService {
    fun getBuildingList(): List<BuildingResponse> {
        return listOf(
            BuildingResponse(
                id = "123",
                name = "Hotel",
                location = "Yangon",
                price = 10f,
                isFavourite = false,
                region = ""
            ),
            BuildingResponse(
                id = "345",
                name = "A1",
                location = "Mandaly",
                price = 10f,
                isFavourite = false,
                region = null
            ),
            BuildingResponse(
                id = "456",
                name = "B1",
                location = "Yangon",
                price = 10f,
                isFavourite = false,
                region = null
            ),
            BuildingResponse(
                id = "789",
                name = "C1",
                location = "Bago",
                price = 10f,
                isFavourite = false,
                region = null
            ),
            BuildingResponse(
                id = "987",
                name = "D1",
                location = "Shan State",
                price = 10f,
                isFavourite = false,
                region = null
            ),
        )
    }

    fun getBuildingDetail(id: String): BuildingResponse {
        return getBuildingList().find { it.id == id }!!
    }
}