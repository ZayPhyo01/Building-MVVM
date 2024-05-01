package com.building.di.module

import com.building.data.datasource.BuildingRemoteDataSource
import com.building.data.repository.BuildingRepository
import com.building.data.service.BuildingNetworkService
import com.building.ui.viewmodel.BuildingDetailViewModel
import com.building.ui.viewmodel.BuildingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module

val buildingModule = module {
    viewModel {
        BuildingViewModel(
            get()
        )
    }
    viewModel {
        BuildingDetailViewModel(
            id = it.get(),
            buildingRepository = get()
        )
    }
    single {
        BuildingNetworkService()
    }
    single {
        BuildingRemoteDataSource(
            get()
        )
    }
    single {
        BuildingRepository(
            get()
        )
    }
}


//ui layer -> ui + viewmodel + repo + datasource

//singleton -> network (ktor , retrofit) , room , datastore , repo ,datasource
//ui viewmodel (stateholder) // factory
