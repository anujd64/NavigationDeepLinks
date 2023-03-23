package com.flexproject.navigationdeeplinks.activityMain

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.navigation.fragment.findNavController
import com.flexproject.navigationdeeplinks.CONSTANTS
import com.flexproject.navigationdeeplinks.databinding.FragmentProfileBinding
class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            val deepLinkUri = "${CONSTANTS.BASE_URI}/firstFragA"
            findNavController().navigate(deepLinkUri.toUri())
        }
        binding.buttonSecond.setOnClickListener {
            val deepLinkUri = "${CONSTANTS.BASE_URI}/secondFragA/?textArg=navigating from profile to second fragment A"
            findNavController().navigate(deepLinkUri.toUri())
        }

        binding.buttonThird.setOnClickListener {
            val deppLinkUri = "${CONSTANTS.BASE_URI}/firstFragB"
            findNavController().navigate(deppLinkUri.toUri())
        }

        binding.buttonFourth.setOnClickListener {
            val deppLinkUri = "${CONSTANTS.BASE_URI}/secondFragB/?textArg=navigating from profile to second fragment B"
            findNavController().navigate(deppLinkUri.toUri())
        }

        binding.buttonFifth.setOnClickListener {
            val deppLinkUri = "${CONSTANTS.BASE_URI}/home"
            findNavController().navigate(deppLinkUri.toUri())
        }
        binding.buttonSixth.setOnClickListener {
            val deppLinkUri = "${CONSTANTS.BASE_URI}/settings"
            findNavController().navigate(deppLinkUri.toUri())
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}