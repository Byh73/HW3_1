package com.example.hw3_1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hw3_1.databinding.ItemHomeBinding
import java.security.PrivateKey

class AnimalAdapter(
    private val animalList: ArrayList<Animal>,
    private val onItemClick: (position: Int) -> Unit
) : RecyclerView.Adapter<AnimalAdapter.ViewHolder>() {
    class ViewHolder(private val binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(animal: Animal) {
            binding.txtAnimal.text = animal.name
            Glide.with(binding.ivAnimal).load(animal.image).into(binding.ivAnimal)
            binding.txtOpis.text = animal.opis

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

    override fun getItemCount(): Int = animalList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(animalList[position])
        holder.itemView.setOnClickListener{
            onItemClick(position)
        }
    }
}