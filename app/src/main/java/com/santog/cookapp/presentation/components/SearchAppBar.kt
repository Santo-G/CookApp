package com.santog.cookapp.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.santog.cookapp.presentation.ui.FoodCategory
import com.santog.cookapp.presentation.ui.getAllFoodCategories

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchAppBar(
    query: String,
    onQueryChanged: (String) -> Unit,
    onExecuteSearch: () -> Unit,
    keyboardController: SoftwareKeyboardController?,
    categoryScrollPosition: Int,
    selectedCategory: FoodCategory?,
    onSelectedCategoryChanged: (String) -> Unit,
    onChangeCategoryScrollPosition: (Int) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        elevation = 8.dp,
        color = Color.White
    ) {
        Column {

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
                        onQueryChanged(input)
                    },
                    label = {
                        Text(text = "Search")
                    },
                    leadingIcon = {
                        Icon(Icons.Filled.Search, "search icon")
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Search  // icon at the bottom right of the keyboard
                    ),
                    keyboardActions = KeyboardActions(
                        onSearch = {
                            onExecuteSearch()
                            keyboardController?.hide()
                        }
                    ),
                    textStyle = TextStyle(
                        color = MaterialTheme.colors.onSurface, // color designed to be on top of "surface" color
                        background = MaterialTheme.colors.surface   // predefined color in Material theme
                    ),
                )
            }

            ScrollableTabRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp),
                selectedTabIndex = categoryScrollPosition,
                indicator = {}
            ) {
                for (category in getAllFoodCategories()) {
                    FoodCategoryChip(
                        category = category.value,
                        isSelected = selectedCategory == category,
                        onSelectedCategoryChanged = { selectedCategory ->
                            onSelectedCategoryChanged(selectedCategory)
                            onChangeCategoryScrollPosition(getAllFoodCategories().indexOf(category))
                        },
                        onExecuteSearch = {
                            onExecuteSearch()
                        }
                    )
                }
            }
        }
    }
}
