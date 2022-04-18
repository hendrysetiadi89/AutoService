package com.example.featureb.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.featureb.R
import com.example.featureb.databinding.ActivityFeatureBBinding
import com.example.featureb.fragment.FeatureBFragment

class FeatureBActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFeatureBBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeatureBBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.content, FeatureBFragment())
                .commit()
        }
    }
}