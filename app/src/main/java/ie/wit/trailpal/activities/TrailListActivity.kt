package ie.wit.trailpal.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ie.wit.trailpal.R
import ie.wit.trailpal.databinding.ActivityTrailListBinding
import ie.wit.trailpal.databinding.CardTrailpalBinding
import ie.wit.trailpal.main.MainApp
import ie.wit.trailpal.models.TrailModel

class TrailListActivity : AppCompatActivity() {

    lateinit var app: MainApp
    private lateinit var binding: ActivityTrailListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrailListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.title = title
        setSupportActionBar(binding.toolbar)

        app = application as MainApp

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = TrailpalAdapter(app.trails)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_add -> {
                val launcherIntent = Intent(this, TrailpalActivity::class.java)
                startActivityForResult(launcherIntent,0)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

class TrailpalAdapter constructor(private var trails: List<TrailModel>) :
    RecyclerView.Adapter<TrailpalAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = CardTrailpalBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val trail = trails[holder.adapterPosition]
        holder.bind(trail)
    }

    override fun getItemCount(): Int = trails.size

    class MainHolder(private val binding : CardTrailpalBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(trail: TrailModel) {
            binding.trailTitle.text = trail.title
            binding.description.text = trail.description
        }
    }
}
