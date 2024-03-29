package com.santog.cookapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.santog.cookapp.navigation.HomeScreen
import com.santog.cookapp.navigation.NavigationItem
import com.santog.cookapp.navigation.RecipeListScreen
import com.santog.cookapp.presentation.components.*
import com.santog.cookapp.presentation.components.animations.HeartButtonAnimation
import com.santog.cookapp.presentation.theme.CookAppTheme
import com.santog.cookapp.presentation.ui.RecipeViewModel
import com.santog.cookapp.util.TAG
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

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
    val selectedCategory = viewModel.selectedCategory.value
    val loading = viewModel.loading.value

    Column {

        SearchAppBar(
            query = query,
            onQueryChanged = viewModel::onQueryChanged,     // delegate the execution to viewModel function
            onExecuteSearch = viewModel::newSearch,     // delegate the execution to viewModel function
            keyboardController = keyboardController,
            categoryScrollPosition = viewModel.getCategoryScrollPosition(),
            selectedCategory = selectedCategory,
            onSelectedCategoryChanged = viewModel::onSelectedCategoryChanged,   // delegate the execution to viewModel function
            onChangeCategoryScrollPosition = viewModel::onChangeCategoryScrollPosition  // delegate the execution to viewModel function
        )

        var isLoading by remember {
            mutableStateOf(true)
        }

        // simulate delay
        LaunchedEffect(key1 = true) {
            delay(3000)
            isLoading = false
        }

        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn {
                itemsIndexed(
                    items = recipes
                ) { index, recipe ->
                        shimmerRecipeCardItem(
                            cardHeight = 320.dp,
                            isLoading = isLoading,
                            contentAfterLoading = {
                                RecipeCard(recipe = recipe, onClick = {})
                            }
                        )
                }
            }
            // Hierarchy in Compose: lower in composable is on top and viceversa
            // CircularIndeterminateProgressBar put as bottom element would be shown (overlay on top of LazyColumn)
            CircularIndeterminateProgressBar(isDisplayed = loading)
        }


              // for test purposes only
/*                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                        .align(alignment = Alignment.CenterHorizontally)
                ) {
                    // PulsingDemoAnimation()
                    //  HeartButtonAnimation()
                }*/


// Box lets you overlay composables one over to another
        /*Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn {
                itemsIndexed(
                    items = recipes
                ) { index, recipe ->
                    RecipeCard(recipe = recipe, onClick = {})
                }
            }
            // Hierarchy in Compose: lower in composable is on top and viceversa
            // CircularIndeterminateProgressBar put as bottom element would be shown (overlay on top of LazyColumn)
            CircularIndeterminateProgressBar(isDisplayed = loading)
        }*/
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
