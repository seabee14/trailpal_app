package ie.wit.trailpal.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import ie.wit.trailpal.R
import ie.wit.trailpal.databinding.ActivityTrailpalBinding
import ie.wit.trailpal.main.MainApp
import ie.wit.trailpal.models.TrailModel
import timber.log.Timber.i

class TrailpalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTrailpalBinding
    var trail = TrailModel()
    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrailpalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarAdd.title = title
        setSupportActionBar(binding.toolbarAdd)

        app = application as MainApp
        i("Trailpal Activity started...")

        binding.btnAdd.setOnClickListener() {
            trail.title = binding.trailTitle.text.toString()
            trail.description = binding.description.text.toString()
            if (trail.title.isNotEmpty()) {
                app.trails.add(trail.copy())
                i("add Button Pressed: ${trail}")
                for (i in app.trails.indices)
                { i("Trail[$i]:${this.app.trails[i]}") }
                setResult(RESULT_OK)
                finish()
            }
            else {
                Snackbar.make(it,"Please Enter a title", Snackbar.LENGTH_LONG)
                    .show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_trailpal, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_cancel -> { finish() }
        }
        return super.onOptionsItemSelected(item)
    }
}