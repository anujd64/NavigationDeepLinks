package com.flexproject.navigationdeeplinks.activityA

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.flexproject.navigationdeeplinks.databinding.ActivityABinding

class ActivityA : AppCompatActivity() {

    private lateinit var binding: ActivityABinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityABinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}