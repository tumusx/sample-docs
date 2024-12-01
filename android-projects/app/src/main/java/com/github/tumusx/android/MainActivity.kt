package com.github.tumusx.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.github.tumusx.mv_flow.feature.Flow
import com.github.tumusx.mv_flow.feature.MvFlowFeature

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            var showRandom by remember { mutableStateOf(Flow.USER) }

            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Text(
                    text = "Change",
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxWidth()
                        .clickable {
                            showRandom = Flow.entries.random()
                        })
            }

            key(showRandom) {
                MvFlowFeature(showRandom)
            }
        }
    }
}
