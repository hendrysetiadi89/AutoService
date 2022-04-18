package com.example.featureb.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.featurebcontract.FeatureBViewModelContract
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class FeatureBViewModel: ViewModel(), FeatureBViewModelContract {
    private val outputFlow = MutableSharedFlow<Int>(1)
    override fun getOutputFlow(): Flow<Int> = outputFlow

    init {
        outputFlow.tryEmit(0)
        viewModelScope.launch {
            while(true) {
                delay(1000)
                outputFlow.emit(outputFlow.replayCache.last() + 1)
            }
        }
    }
}