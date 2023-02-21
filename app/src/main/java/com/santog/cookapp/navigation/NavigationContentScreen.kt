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
                text = "VIEW DETAILS"
            )
        }
    }
}

@Composable
fun RecipeListScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .wrapContentSize(Alignment.Center)
    ) {
        Column(
            modifier = Modifier
                .border(border = BorderStroke(1.dp, Color.Black))
                .padding(16.dp)
        ) {
            Text(
                "Title: Recipe List Screen",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
            )
            Image(
                painterResource(com.santog.cookapp.R.drawable.salad),
                "",
                modifier = Modifier.height(300.dp).align(alignment = Alignment.CenterHorizontally),
                contentScale = ContentScale.Crop
            )
            Text("Details ", style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.SemiBold))
            Text(
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                        "when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, " +
                        "but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with " +
                        "the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Text("Ingredient list ", style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.SemiBold))
            Text("Ingredient 1 ")
            Text("Ingredient 2 ")
            Spacer(modifier = Modifier.padding(10.dp))
            Text("Preparation", style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.SemiBold))
            CircularProgressIndicator()
            Spacer(modifier = Modifier.padding(10.dp))
        }
    }
}

