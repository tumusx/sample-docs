package com.tumusx.a3navigation.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tumusx.a3navigation.navigation.Actions
import com.tumusx.a3navigation.navigation.Navigator

@Composable
internal fun ScreenTwo(navigator: Navigator) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "Second Screen", modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        )

        Button(onClick = { navigator.onNavigator(Actions.BackStack) }) {
            Text("Back stack to Screen one")
        }
    }
}