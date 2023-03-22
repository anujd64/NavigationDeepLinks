package com.flexproject.navigationdeeplinks.fragmentA

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import androidx.navigation.NavDeepLinkBuilder
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.flexproject.navigationdeeplinks.R
import com.flexproject.navigationdeeplinks.databinding.FragmentSecondABinding
import com.flexproject.navigationdeeplinks.fragmentB.SecondFragmentBArgs

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragmentA : Fragment() {

    private var _binding: FragmentSecondABinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val args: SecondFragmentAArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondABinding.inflate(inflater, container, false)

        binding.textView.text = args.textArg

        binding.button.setOnClickListener {

            val navDeepLinkBuilder: NavDeepLinkBuilder = NavDeepLinkBuilder(requireContext())
                .setGraph(R.navigation.nav_graph_main)
                .setDestination(R.id.SecondFragmentA)
                .setArguments(
                    SecondFragmentBArgs.Builder(
                        "navigating from the notification to second fragment A"
                    ).build().toBundle()
                )
            val deeplink = navDeepLinkBuilder.createPendingIntent()

//            val deeplink = findNavController().createDeepLink()
//                .setDestination(R.id.SecondFragmentB)
//                .createPendingIntent()

            val notificationManager =
                requireContext().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationManager.createNotificationChannel(
                    NotificationChannel(
                        "deeplink", "Deep Links", NotificationManager.IMPORTANCE_HIGH
                    )
                )
            }

            val builder = NotificationCompat.Builder(
                requireContext(), "deeplink"
            )
                .setContentTitle("Navigation")
                .setContentText("Deep link to Second fragment A")
                .setSmallIcon(com.google.android.material.R.drawable.material_ic_keyboard_arrow_previous_black_24dp)
                .setContentIntent(deeplink)
                .setAutoCancel(true)
            notificationManager.notify(1, builder.build())
        }


        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}