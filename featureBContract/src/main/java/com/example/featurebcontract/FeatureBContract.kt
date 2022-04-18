package com.example.featurebcontract

import android.app.Activity
import androidx.fragment.app.Fragment

interface FeatureBContract {
    fun goToFeatureB(activity: Activity)
    fun launchTaskLalala(activity: Activity)
    fun getFragmentB(): Fragment
}