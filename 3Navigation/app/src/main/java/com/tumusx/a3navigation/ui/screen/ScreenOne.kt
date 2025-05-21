package com.tumusx.a3navigation.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tumusx.a3navigation.navigation.Actions
import com.tumusx.a3navigation.navigation.Navigator

@Composable
internal fun ScreenOne(navigator: Navigator) {
    Column {
        Text(
            text = "Screen One", modifier = Modifier
                .fillMaxWidth()
                .size(10.dp)
        )

        Button(onClick = {
            navigator.onNavigator(Actions.SecondScreen)
        }) {
            Text("Navigate to second screen")
        }
    }
}