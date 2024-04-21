package com.building

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.building.data.datasource.BuildingRemoteDataSource
import com.building.data.repository.BuildingRepository
import com.building.data.service.BuildingNetworkService
import com.building.di.AppContainer
import com.building.ui.adapter.BuildingAdapter
import com.building.ui.screen.BuildingDetailActivity
import com.building.ui.viewmodel.BuildingViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val buildingRepository = AppContainer().buildingRepository
        val buildingViewModel = BuildingViewModel(
            buildingRepository
        )

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val adapter = BuildingAdapter {
            val intent = BuildingDetailActivity.newIntent(this, it)
            startActivity(intent)
        }
        val rvBuilding: RecyclerView = findViewById(R.id.rvBuildingList)
        rvBuilding.adapter = adapter

        buildingViewModel.buildingListLiveData.observeForever {
            adapter.updateBuildingList(it)
        }
    }
}