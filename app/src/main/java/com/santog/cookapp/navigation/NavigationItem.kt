package com.santog.cookapp.navigation

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * This class contains navigation related files.
 * Sealed class with:
 * - item title
 * - item icon
 * - item route
 */

sealed class NavigationItem(var title: String, var icon: ImageVector?, var screen_route: String) {
    object Home : NavigationItem("Home", null, "home")
    object RecipeListScreen : NavigationItem("Recipe List", null, "recipe_list")
}
