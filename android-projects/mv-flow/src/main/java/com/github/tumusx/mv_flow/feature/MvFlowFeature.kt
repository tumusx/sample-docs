package com.github.tumusx.mv_flow.feature

import androidx.compose.runtime.Composable
import com.github.tumusx.mv_flow.feature.screen.MainScreen
import com.github.tumusx.mv_flow.flow.impl.ProfileFlowImpl
import com.github.tumusx.mv_flow.flow.impl.UserFlowImpl
import com.github.tumusx.mv_flow.viewmodel.MvFlowViewModel

enum class Flow {
    USER, PROFILE;
}

@Composable
fun MvFlowFeature(flow: Flow) {

    val iFlow = if (flow == Flow.USER) UserFlowImpl() else ProfileFlowImpl()

    val viewModel = MvFlowViewModel(iFlow)

    MainScreen(viewModel)

}
