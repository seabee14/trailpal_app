package ie.wit.trailpal.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ie.wit.trailpal.databinding.CardTrailpalBinding
import ie.wit.trailpal.models.TrailModel

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