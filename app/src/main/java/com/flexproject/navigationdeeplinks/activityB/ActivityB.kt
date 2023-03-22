package com.flexproject.navigationdeeplinks.activityB

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.flexproject.navigationdeeplinks.databinding.ActivityBBinding

class ActivityB : AppCompatActivity() {

    private lateinit var binding: ActivityBBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityBBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}