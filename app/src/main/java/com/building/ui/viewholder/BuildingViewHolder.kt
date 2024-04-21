package com.building.ui.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.building.R
import com.building.domain.model.building.BuildingModel

class BuildingViewHolder(private val onClickDetail: (String) -> Unit, view: View) :
    ViewHolder(view) {
    val buildingName = view.findViewById<TextView>(R.id.tvBuildingName)

    fun bindUi(buildingModel: BuildingModel) {
        buildingName.text = buildingModel.name
        itemView.setOnClickListener { onClickDetail(buildingModel.id) }
    }
}