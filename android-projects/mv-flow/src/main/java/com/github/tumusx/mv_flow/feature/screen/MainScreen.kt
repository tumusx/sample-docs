package com.github.tumusx.mv_flow.feature.screen

import androidx.compose.runtime.Composable
import com.github.tumusx.mv_flow.viewmodel.MvFlowViewModel

@Composable
fun MainScreen(viewModel: MvFlowViewModel) {
    viewModel.goToAnotherScreen()
}