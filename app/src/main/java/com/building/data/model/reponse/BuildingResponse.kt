package com.building.data.model.reponse

//DTO
data class BuildingResponse(
    val id: String,
    val name: String?,
    val price: Float?,
    val isFavourite: Boolean?,
    val location: String?,
    val region : String?
)

//repo -> Domain not DTO
//thirdparty -> lib
