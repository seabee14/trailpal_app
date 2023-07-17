package ie.wit.trailpal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import timber.log.Timber
import timber.log.Timber.i

class TrailpalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trailpal)

        Timber.plant(Timber.DebugTree())

        i("Trailpal Activity started..")
    }
}