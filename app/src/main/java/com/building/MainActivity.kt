package com.building

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.building.ui.adapter.BuildingAdapter
import com.building.ui.viewmodel.BuildingViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val buildingViewModel = BuildingViewModel()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val adapter = BuildingAdapter()
        val rvBuilding: RecyclerView = findViewById(R.id.rvBuildingList)
        rvBuilding.adapter = adapter

        buildingViewModel.buildingListLiveData.observeForever {
            adapter.updateBuildingList(it)
        }
    }
}