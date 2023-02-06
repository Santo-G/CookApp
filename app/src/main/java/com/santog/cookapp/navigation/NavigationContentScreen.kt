package com.santog.cookapp.navigation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .wrapContentSize(Alignment.Center)
    ) {
        Column(
            modifier = Modifier
                .border(border = BorderStroke(1.dp, Color.Black))
                .padding(16.dp)
        ) {
            Text("Home Screen")
            Spacer(modifier = Modifier.padding(10.dp))
            CircularProgressIndicator()
            Spacer(modifier = Modifier.padding(10.dp))
        }
    }
}

@Composable
fun RecipeListScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .wrapContentSize(Alignment.Center)
    ) {
        Column(
            modifier = Modifier
                .border(border = BorderStroke(1.dp, Color.Black))
                .padding(16.dp)
        ) {
            Text("Recipe List Screen")
            Spacer(modifier = Modifier.padding(10.dp))
            CircularProgressIndicator()
            Spacer(modifier = Modifier.padding(10.dp))
        }
    }
}

