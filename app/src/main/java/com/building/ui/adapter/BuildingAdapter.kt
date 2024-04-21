package com.building.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.building.R
import com.building.domain.model.building.BuildingModel
import com.building.ui.viewholder.BuildingViewHolder

class BuildingAdapter(
    private val onClickDetail: (String) -> Unit
) : RecyclerView.Adapter<BuildingViewHolder>() {

    private var buildingList = emptyList<BuildingModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuildingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view_building, parent, false)
        return BuildingViewHolder(onClickDetail = onClickDetail, view = view)
    }

    override fun getItemCount(): Int {
        return buildingList.size
    }

    override fun onBindViewHolder(holder: BuildingViewHolder, position: Int) {
        holder.bindUi(
            buildingList[position]
        )
    }

    fun updateBuildingList(list: List<BuildingModel>) {
        buildingList = list
        notifyDataSetChanged()
    }
}