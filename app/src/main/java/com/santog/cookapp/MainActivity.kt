package com.santog.cookapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.santog.cookapp.navigation.HomeScreen
import com.santog.cookapp.navigation.NavigationItem
import com.santog.cookapp.navigation.RecipeListScreen
import com.santog.cookapp.presentation.components.RecipeCard
import com.santog.cookapp.presentation.theme.CookAppTheme
import com.santog.cookapp.presentation.ui.RecipeViewModel
import com.santog.cookapp.util.TAG
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: RecipeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CookAppTheme {
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFF2F2F2)) {
                    LandingPage("", navController, viewModel)
                }
            }
        }
    }

}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LandingPage(name: String, navController: NavHostController, viewModel: RecipeViewModel) {

    val recipes = viewModel.recipes.value
    Log.d(TAG, "CookApp Landing page recipes list size: ${recipes.size}")
    val query = viewModel.query.value
    val keyboardController = LocalSoftwareKeyboardController.current

    Column {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            elevation = 8.dp,
            color = MaterialTheme.colors.primary
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                // user input
                TextField(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(8.dp),
                    value = query,
                    onValueChange = { input ->
                        viewModel.onQueryChanged(input)
                    },
                    label = {
                        Text(text = "Search")
                    },
                    leadingIcon = {
                        Icon(Icons.Filled.Search, "search icon")
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Search  // icon at the bottom right of keyboard
                    ),
                    keyboardActions = KeyboardActions(
                        onSearch = {
                            viewModel.newSearch(query)
                            keyboardController?.hide()
                        }
                    ),
                    textStyle = TextStyle(
                        color = MaterialTheme.colors.onSurface, // color designed to be on top of "surface" color
                        background = MaterialTheme.colors.surface   // predefined color in Material theme
                    ),
                )
            }
        }
        LazyColumn {
            itemsIndexed(
                items = recipes
            ) { index, recipe ->
                RecipeCard(recipe = recipe, onClick = {})
            }
        }
    }

    /*
    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            NavigationGraph(navController)
        }
    }
    */
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

// @Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val navController = rememberNavController()
    CookAppTheme {
        // LandingPage("Android", navController, viewModel)
    }
}
