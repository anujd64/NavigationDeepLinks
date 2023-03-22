package com.flexproject.navigationdeeplinks.fragmentB

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.flexproject.navigationdeeplinks.R
import com.flexproject.navigationdeeplinks.databinding.FragmentFirstBBinding


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragmentB : Fragment() {

    private var _binding: FragmentFirstBBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}