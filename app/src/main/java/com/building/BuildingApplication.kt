package com.building

import android.app.Application
import com.building.di.module.buildingModule
import org.koin.core.context.startKoin

class BuildingApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                buildingModule
            )
        }
    }
}