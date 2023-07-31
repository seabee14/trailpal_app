package ie.wit.trailpal.main

import android.app.Application
import ie.wit.trailpal.models.TrailModel
import timber.log.Timber
import timber.log.Timber.i

class MainApp : Application() {

    val trails = ArrayList<TrailModel>()

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        i("Trailpal started")
    }
}