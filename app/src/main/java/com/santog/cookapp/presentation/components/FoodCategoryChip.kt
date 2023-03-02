package com.santog.cookapp.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FoodCategoryChip(
    category: String,
    isSelected: Boolean = false,
    onSelectedCategoryChanged: (String) -> Unit,
    onExecuteSearch: () -> Unit
) {
    Chip(
        modifier = Modifier
            .padding(8.dp)
            .toggleable(
                value = isSelected,
                onValueChange = { }
            ),
        onClick = {
            onSelectedCategoryChanged(category)
            onExecuteSearch()
        },
        shape = MaterialTheme.shapes.medium,
        colors = if (isSelected)
            ChipDefaults.chipColors(Color.LightGray)
        else
            ChipDefaults.chipColors(MaterialTheme.colors.primary)
    ) {
        Text(
            text = category,
            style = MaterialTheme.typography.body2,
            color = Color.White,
            modifier = Modifier.padding(8.dp)
        )
    }
}
