package com.example.findaplane

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton


class AirplanesNearby : Fragment() {

    private lateinit var viewModel:AirplanesNearbyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_airplanes_nearby, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(AirplanesNearbyViewModel::class.java)

        viewModel.all.observe(viewLifecycleOwner,{ view.findViewById<TextView>(R.id.textViewShowPlanes).text=it.toString()})

        viewModel.postAll(45.8389,5.9962,47.8229,10.5226)



        (view.findViewById<FloatingActionButton>(R.id.backFromAirplanesNearby)).setOnClickListener {

            it.findNavController().navigate(R.id.action_airplanesNearby_to_menuFragment)

        }

    }
}