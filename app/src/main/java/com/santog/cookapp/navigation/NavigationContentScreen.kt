package com.santog.cookapp.navigation

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun HomeScreen(name: String, navController: NavHostController) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .border(border = BorderStroke(width = 1.dp, color = Color.Black), shape = RoundedCornerShape(5.dp))
    ) {
        Image(
            painterResource(com.santog.cookapp.R.drawable.salad),
            "",
            modifier = Modifier.height(300.dp).align(alignment = Alignment.CenterHorizontally),
            contentScale = ContentScale.Crop
        )
        Row(modifier = Modifier.padding(10.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = name,
                style = TextStyle(fontSize = 26.sp, fontWeight = FontWeight.SemiBold),
                textAlign = TextAlign.Start
            )
            Text(
                text = "€5,90",
                style = TextStyle(fontSize = 17.sp),
                color = Color(0xFF85bb65),
                textAlign = TextAlign.End,
                modifier = Modifier.align(alignment = Alignment.CenterVertically)
            )
        }
        Spacer(modifier = Modifier.padding(top = 5.dp))
        Row(modifier = Modifier.padding(10.dp)) {
            Text(
                text = "150 calories",
                style = TextStyle(fontSize = 17.sp)
            )
        }
        Spacer(modifier = Modifier.padding(top = 5.dp))
        Button(
            onClick = { navController.navigate(NavigationItem.RecipeListScreen.screen_route) },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "ORDER NOW"
            )
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

