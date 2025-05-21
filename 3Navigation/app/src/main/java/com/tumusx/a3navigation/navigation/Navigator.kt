package com.tumusx.a3navigation.navigation

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull

internal class Navigator : INavigator {
    private val onUpdateNavigator: MutableStateFlow<Actions?> =
        MutableStateFlow(null)
    override val navResult = onUpdateNavigator.filterNotNull()

    override fun onNavigator(route: Actions) {
        onUpdateNavigator.value = route
    }
}

internal interface INavigator {
    val navResult: Flow<Actions>
    fun onNavigator(route: Actions)
}