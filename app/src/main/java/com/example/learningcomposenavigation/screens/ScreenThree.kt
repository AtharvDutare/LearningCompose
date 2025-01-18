package com.example.learningcomposenavigation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun ScreenThree(navController: NavController,paddingValues: PaddingValues,modifier: Modifier=Modifier) {
    Surface(
        modifier=Modifier.fillMaxSize()
            .padding(paddingValues)
        , color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier=Modifier.fillMaxSize()
            , verticalArrangement = Arrangement.Center
            , horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { navController.popBackStack()}) {
                Text(text = "previous screen")
            }
            Text(text = "hello")
            Button(onClick = { navController.popBackStack(destinationId = navController.graph.startDestinationId, inclusive = false) }) {
                Text(text = "first screen")
            }
        }
    }
}