package com.example.featurebcontract

import kotlinx.coroutines.flow.Flow

interface FeatureBViewModelContract {
    fun getOutputFlow(): Flow<Int>
}