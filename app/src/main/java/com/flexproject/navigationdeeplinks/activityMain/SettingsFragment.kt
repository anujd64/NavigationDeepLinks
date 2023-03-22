package com.flexproject.navigationdeeplinks.activityMain

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.navigation.fragment.findNavController
import com.flexproject.navigationdeeplinks.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            val deepLinkUri = "https://navigationDeepLinks.com/firstFragA"
            findNavController().navigate(deepLinkUri.toUri())
        }
        binding.buttonSecond.setOnClickListener {
            val deepLinkUri = "https://navigationDeepLinks.com/secondFragA/?textArg=navigating from settings to second fragment A"
            findNavController().navigate(deepLinkUri.toUri())
        }

        binding.buttonThird.setOnClickListener {
            val deppLinkUri = "https://navigationDeepLinks.com/firstFragB"
            findNavController().navigate(deppLinkUri.toUri())
        }

        binding.buttonFourth.setOnClickListener {
            val deppLinkUri = "https://navigationDeepLinks.com/secondFragB/?textArg=navigating from settings to second fragment B"
            findNavController().navigate(deppLinkUri.toUri())
        }

        binding.buttonFifth.setOnClickListener {
            val deppLinkUri = "https://navigationDeepLinks.com/profile"
            findNavController().navigate(deppLinkUri.toUri())
        }

        binding.buttonSixth.setOnClickListener {
            val deppLinkUri = "https://navigationDeepLinks.com/home"
            findNavController().navigate(deppLinkUri.toUri())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}