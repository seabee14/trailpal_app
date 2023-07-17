package ie.wit.trailpal.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import ie.wit.trailpal.databinding.ActivityTrailpalBinding
import ie.wit.trailpal.models.TrailModel
import timber.log.Timber
import timber.log.Timber.i

class TrailpalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTrailpalBinding
    var trail = TrailModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTrailpalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Timber.plant(Timber.DebugTree())

        i("Trailpal Activity started..")

        binding.btnAdd.setOnClickListener() {
            trail.title = binding.trailTitle.text.toString()
            if (trail.title.isNotEmpty()) {
                i("add Button Pressed: $trail.title")
            }
            else {
                Snackbar
                    .make(it,"Please Enter a title", Snackbar.LENGTH_LONG)
                    .show()
            }
        }
    }
}