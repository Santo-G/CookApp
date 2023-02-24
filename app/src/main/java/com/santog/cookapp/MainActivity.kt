package com.santog.cookapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.santog.cookapp.navigation.HomeScreen
import com.santog.cookapp.navigation.NavigationItem
import com.santog.cookapp.navigation.RecipeListScreen
import com.santog.cookapp.presentation.theme.CookAppTheme
import com.santog.cookapp.presentation.ui.RecipeViewModel
import com.santog.cookapp.util.TAG
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: RecipeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        access viewModel parameters
//        viewModel.getRepository()
//        viewModel.getToken()
        setContent {
            CookAppTheme {
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFF2F2F2)) {
                    LandingPage("Salad", navController, viewModel)
                }
            }
        }
    }

}

@Composable
fun LandingPage(name: String, navController: NavHostController, viewModel: RecipeViewModel) {

    val recipes = viewModel.recipes.value
    Log.d(TAG, "CookApp Landing page recipes list size: ${recipes.size}")

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            NavigationGraph(navController)
        }
    }
}

// Handle navigation graph
// Specified the composable destinations that you should be able to navigate between
@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.screen_route) {
        composable(NavigationItem.Home.screen_route) {
            HomeScreen("Salad", navController)
        }
        composable(NavigationItem.RecipeListScreen.screen_route) {
            RecipeListScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val navController = rememberNavController()
    CookAppTheme {
        // LandingPage("Android", navController, viewModel)
    }
}
