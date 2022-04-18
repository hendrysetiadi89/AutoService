package com.example.featureb

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.featureb.activity.FeatureBActivity
import com.example.featureb.fragment.FeatureBFragment
import com.example.featureb.viewmodel.FeatureBViewModel
import com.example.featurebcontract.FeatureBContract
import com.example.featurebcontract.FeatureBViewModelContract
import com.google.auto.service.AutoService

@AutoService(FeatureBContract::class)
class FeatureBContractImpl: FeatureBContract {
    override fun goToFeatureB(activity: Activity) {
        activity.startActivity(Intent(activity, FeatureBActivity::class.java))
    }

    override fun launchTaskLalala(activity: Activity) {
        // Stub launch service Lalala
        Toast.makeText(activity, "Launching Task Lalala", Toast.LENGTH_LONG).show();
    }

    override fun getFragmentB(): Fragment {
        return FeatureBFragment()
    }

    override fun getViewModel(activity: AppCompatActivity): FeatureBViewModelContract {
        return ViewModelProvider(activity)[FeatureBViewModel::class.java]
    }
}