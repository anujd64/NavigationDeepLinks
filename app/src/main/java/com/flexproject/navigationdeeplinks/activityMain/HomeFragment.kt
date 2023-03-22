package com.flexproject.navigationdeeplinks.activityMain

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.navigation.fragment.findNavController
import com.flexproject.navigationdeeplinks.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            val deepLinkUri = "https://navigationDeepLinks.com/firstFragA"
            findNavController().navigate(deepLinkUri.toUri())
        }
        binding.buttonSecond.setOnClickListener {
            val deepLinkUri = "https://navigationDeepLinks.com/secondFragA/?textArg=navigating from home to second fragment A"
            findNavController().navigate(deepLinkUri.toUri())
        }

        binding.buttonThird.setOnClickListener {
            val deppLinkUri = "https://navigationDeepLinks.com/firstFragB"
            findNavController().navigate(deppLinkUri.toUri())
        }

        binding.buttonFourth.setOnClickListener {
            val deppLinkUri = "https://navigationDeepLinks.com/secondFragB/?textArg=navigating from home to second fragment B"
            findNavController().navigate(deppLinkUri.toUri())
        }

        binding.buttonFifth.setOnClickListener {
            val deppLinkUri = "https://navigationDeepLinks.com/profile"
            findNavController().navigate(deppLinkUri.toUri())
        }

        binding.buttonSixth.setOnClickListener {
            val deppLinkUri = "https://navigationDeepLinks.com/settings"
            findNavController().navigate(deppLinkUri.toUri())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}