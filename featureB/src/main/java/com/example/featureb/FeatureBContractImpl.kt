package com.example.featureb

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.featurebcontract.FeatureBContract
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
}