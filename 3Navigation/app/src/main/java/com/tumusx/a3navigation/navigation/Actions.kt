package com.tumusx.a3navigation.navigation

internal sealed interface Actions {
    data object SecondScreen : Actions
    data object BackStack : Actions
}