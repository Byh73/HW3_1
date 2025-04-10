package com.example.hw3_1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hw3_1.databinding.ItemHomeBinding
import java.security.PrivateKey

class PlantAdapter(
    private val plantList: ArrayList<Plant>,
    private val onItemClick: (position: Int) -> Unit
) : RecyclerView.Adapter<PlantAdapter.ViewHolder>() {
    class ViewHolder(private val binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(plant: Plant) {
            binding.txtPlant.text = plant.name
            Glide.with(binding.ivPlant).load(plant.image).into(binding.ivPlant)
            binding.txtOpis.text = plant.opis

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemHomeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun getItemCount(): Int = plantList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(plantList[position])
        holder.itemView.setOnClickListener{
            onItemClick(position)
        }
    }
}