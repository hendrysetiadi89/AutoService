package com.example.featurea

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.featurea.databinding.ActivityFeatureABinding
import com.example.featurebcontract.FeatureBContract
import java.util.*

class FeatureAActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFeatureABinding

    private val featureBContract:FeatureBContract by lazy {
        val loader: ServiceLoader<FeatureBContract> =
            ServiceLoader.load(FeatureBContract::class.java)
        loader.toList()[0]!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeatureABinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnGoToFeatureB1.setOnClickListener {
            startActivity(Intent("com.example.internal.VIEW").apply {
                data = Uri.parse("example://featureb/home")
            })
        }

        binding.btnGoToFeatureB2.setOnClickListener {
            featureBContract.goToFeatureB(this)
        }

        binding.btnServiceB.setOnClickListener {
            featureBContract.launchTaskLalala(this)
        }

        binding.btnFragmentB.setOnClickListener {
            val f = featureBContract.getFragmentB()
            supportFragmentManager.beginTransaction()
                .replace(R.id.content, f)
                .commit()
        }
    }


}