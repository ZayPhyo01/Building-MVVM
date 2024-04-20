package com.building.domain.model.building

data class BuildingModel(
    val id: String,
    val name: String,
    val address: BuildingAddress,
    val price: Float,
    val isFavourite: Boolean
)
