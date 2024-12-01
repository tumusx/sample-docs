package com.github.tumusx.mv_flow.flow.contract

import kotlinx.coroutines.flow.Flow

interface IFlow {
    val infoNavigation: Flow<InfoNavigation?>
    suspend fun onNavigateToRoute()
}

data class InfoNavigation(
    val action: Actions
)


 enum class Actions {
    GoToUser, GoToProfile;
}