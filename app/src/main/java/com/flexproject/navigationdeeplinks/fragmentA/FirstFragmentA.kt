package com.flexproject.navigationdeeplinks.fragmentA

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.navigation.fragment.findNavController
import com.flexproject.navigationdeeplinks.R
import com.flexproject.navigationdeeplinks.databinding.FragmentFirstABinding

class FirstFragmentA : Fragment() {

    private var _binding: FragmentFirstABinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstABinding.inflate(inflater, container, false)


        binding.buttonFirst.setOnClickListener {
            val deepLinkUri = "https://navigationDeepLinks.com/home"
            findNavController().navigate(deepLinkUri.toUri())
        }
        binding.buttonFourth.setOnClickListener {
            val deepLinkUri = "https://navigationDeepLinks.com/secondFragA/?textArg=navigating from FirstFragA to second fragment A"
            findNavController().navigate(deepLinkUri.toUri())
        }

        binding.buttonThird.setOnClickListener {
            val deppLinkUri = "https://navigationDeepLinks.com/settings"
            findNavController().navigate(deppLinkUri.toUri())
        }

        binding.buttonSecond.setOnClickListener {
            val deppLinkUri = "https://navigationDeepLinks.com/profile"
            findNavController().navigate(deppLinkUri.toUri())
        }

        binding.buttonFifth.setOnClickListener {
            val deppLinkUri = "https://navigationDeepLinks.com/firstFragB"
            findNavController().navigate(deppLinkUri.toUri())
        }

        binding.buttonSixth.setOnClickListener {
            val deppLinkUri = "https://navigationDeepLinks.com/secondFragB/?textArg=navigating from FirstFragA to second fragment B"
            findNavController().navigate(deppLinkUri.toUri())
        }

        return binding.root

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}