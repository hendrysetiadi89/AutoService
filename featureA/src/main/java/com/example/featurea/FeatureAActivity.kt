package com.example.featurea

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.featurea.databinding.ActivityFeatureABinding
import com.example.featurebcontract.FeatureBContract
import kotlinx.coroutines.launch
import java.util.*

class FeatureAActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFeatureABinding

    private var hasObserved= false

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

        binding.btnServiceB1.setOnClickListener {
            val intent = Intent("com.service.featureB")
            intent.`package` = this@FeatureAActivity.packageName
            startService(intent)
        }

        binding.btnServiceB2.setOnClickListener {
            featureBContract.launchTaskLalala(this)
        }

        binding.btnFragmentB.setOnClickListener {
            val f = featureBContract.getFragmentB()
//            val cls = FragmentFactory.loadFragmentClass(classLoader,
//                "com.example.featureb.fragment.FeatureBFragment")
//            val f = cls.getConstructor().newInstance()
            supportFragmentManager.beginTransaction()
                .replace(R.id.content, f)
                .commit()
        }

        binding.btnViewmodelB.setOnClickListener {
            startObserving()
        }
    }

    fun startObserving(){
        if (hasObserved) return
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                featureBContract.getViewModel(this@FeatureAActivity).getOutputFlow().collect {
                    binding.txtVmoutpput.text = it.toString()
                }
            }
        }
        hasObserved = true
    }


}