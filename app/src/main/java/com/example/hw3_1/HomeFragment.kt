package com.example.hw3_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw3_1.databinding.FragmentHomeBinding
import com.example.hw3_1.databinding.ItemHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private var animalList: ArrayList<Animal> = arrayListOf<Animal>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        initialize()
    }


    private fun loadData() {
        animalList.add(
            Animal(
                name = "",
                image = "",
                opis = ""
            )
        )
    }

    private fun initialize() {
        val animalAdapter = AnimalAdapter(animalList) { position: Int ->
            val bundle = Bundle()
            bundle.putSerializable("animal", animalList[position])
            val detailFragment = DetailFragment()
            detailFragment.arguments = bundle
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, detailFragment).addToBackStack(null).commit()

        }
        binding.rvHome.adapter = animalAdapter
    }


}