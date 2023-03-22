package com.flexproject.navigationdeeplinks.fragmentB

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkBuilder
import androidx.navigation.fragment.navArgs
import com.flexproject.navigationdeeplinks.R
import com.flexproject.navigationdeeplinks.databinding.FragmentSecondBBinding

class SecondFragmentB : Fragment() {

    private var _binding: FragmentSecondBBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<SecondFragmentBArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBBinding.inflate(inflater, container, false)

        binding.textView.text = args.textArg

        binding.button.setOnClickListener {

            val navDeepLinkBuilder: NavDeepLinkBuilder = NavDeepLinkBuilder(requireContext())
                .setGraph(R.navigation.nav_graph_main)
                .setDestination(R.id.SecondFragmentB)
                .setArguments(
                    SecondFragmentBArgs.Builder(
                        "navigating from the notification to second fragment B"
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
                .setContentText("Deep link to Second fragment B")
                .setSmallIcon(com.google.android.material.R.drawable.material_ic_keyboard_arrow_previous_black_24dp)
                .setContentIntent(deeplink)
                .setAutoCancel(true)
            notificationManager.notify(2, builder.build())
        }

        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}