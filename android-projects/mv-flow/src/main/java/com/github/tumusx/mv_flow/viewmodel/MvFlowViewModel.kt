package com.github.tumusx.mv_flow.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.tumusx.mv_flow.flow.contract.IFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class MvFlowViewModel(private val iFlow: IFlow) : ViewModel() {

    fun goToAnotherScreen() {
        viewModelScope.launch {
            iFlow.onNavigateToRoute()
            val action = iFlow.infoNavigation.first()
            println("Action navigation: " + action?.action?.name!!)
        }
    }
}