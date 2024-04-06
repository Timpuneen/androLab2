package kz.ayala.lab2animals

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kz.ayala.lab2animals.databinding.ItemAnimalBinding

class Adapter : ListAdapter<Animal, Adapter.AnimalViewHolder>(AnimalsDiffUtils()) {


    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val dogBreed = getItem(position)
        holder.bind(dogBreed)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemAnimalBinding.inflate(layoutInflater, parent, false)
        return AnimalViewHolder(binding)
    }



    class AnimalViewHolder(private val binding: ItemAnimalBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(animalInfo: Animal) {
            with(binding) {
                scientificNameTextView.text = animalInfo.taxonomy?.scientific_name ?: "Scientific name not available"

                locationTextView.text = animalInfo.locations?.joinToString(", ") ?: "Locations not available"
                val characteristics = animalInfo.characteristics
                populationTextView.text = "Population: ${characteristics.estimated_population_size}"
                threatTextView.text = "Threat: ${characteristics.biggest_threat}"
                speedTextView.text = "Speed: ${characteristics.top_speed}"
                lifespanTextView.text = "Lifespan: ${characteristics.lifespan}"

            }
        }
    }

    class AnimalsDiffUtils : DiffUtil.ItemCallback<Animal>() {
        override fun areItemsTheSame(oldItem: Animal, newItem: Animal): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Animal, newItem: Animal): Boolean {
            return oldItem == newItem
        }
    }
}