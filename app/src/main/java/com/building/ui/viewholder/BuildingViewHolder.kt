package com.building.ui.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.building.R
import com.building.domain.model.building.BuildingModel

class BuildingViewHolder(view: View) : ViewHolder(view) {
    val buildingName = view.findViewById<TextView>(R.id.tvBuildingName)

    fun bindUi(buildingModel: BuildingModel) {
        buildingName.text = buildingModel.name
    }
}