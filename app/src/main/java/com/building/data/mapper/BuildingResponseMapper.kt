package com.building.data.mapper

import com.building.data.model.reponse.BuildingResponse
import com.building.domain.model.building.BuildingAddress
import com.building.domain.model.building.BuildingModel

fun List<BuildingResponse>.toModels() = map {
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

fun BuildingResponse.toModel() = BuildingModel(
    id = this.id,
    address = BuildingAddress(
        location = this.location.orEmpty(),
        region = this.region.orEmpty()
    ),
    name = this.name.orEmpty(),
    price = this.price ?: 0f,
    isFavourite = this.isFavourite ?: false
)