package com.github.tumusx.mv_flow.flow.impl

import com.github.tumusx.mv_flow.flow.contract.Actions
import com.github.tumusx.mv_flow.flow.contract.IFlow
import com.github.tumusx.mv_flow.flow.contract.InfoNavigation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class UserFlowImpl : IFlow {

    private val _infoNavigation: MutableStateFlow<InfoNavigation?> = MutableStateFlow(null)

    override val infoNavigation: Flow<InfoNavigation?>
        get() = _infoNavigation.asStateFlow()

    override suspend fun onNavigateToRoute() {
        _infoNavigation.value = InfoNavigation(Actions.GoToUser)
    }
}