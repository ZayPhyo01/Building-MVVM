package com.building.ui.screen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.building.R
import com.building.data.datasource.BuildingRemoteDataSource
import com.building.data.repository.BuildingRepository
import com.building.data.service.BuildingNetworkService
import com.building.di.AppContainer
import com.building.ui.viewmodel.BuildingDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class BuildingDetailActivity : AppCompatActivity() {

    companion object {
        private val ID = "id"

        fun newIntent(context: Context, id: String): Intent {
            val intent = Intent(context, BuildingDetailActivity::class.java)
            intent.putExtra(ID, id)
            return intent
        }
    }


    val buildingDetailViewmodel: BuildingDetailViewModel by viewModel {
        parametersOf(intent.extras?.getString("id"))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            R.layout.activity_building_detail
        )


        //val buildingDetailViewmodel = AppContainer().getBuildingDetailViewModel(detailId)

        buildingDetailViewmodel.buildingDetailLiveData.observeForever {
            val buildingName: TextView = findViewById(R.id.tvBuildingName)
            val buildingLocationAddress: TextView = findViewById(R.id.tvLocation)
            buildingName.text = it.name
            buildingLocationAddress.text = it.locationAddress
        }

    }
}