package com.santog.cookapp.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FoodCategoryChip(
    category: String,
    onExecuteSearch: (String) -> Unit
) {
    Chip(
        onClick = { onExecuteSearch(category) },
        modifier = Modifier.padding(8.dp),
        shape = MaterialTheme.shapes.medium,
        colors = ChipDefaults.chipColors(MaterialTheme.colors.primary)
    ) {
        Text(
            text = category,
            style = MaterialTheme.typography.body2,
            color = Color.White,
            modifier = Modifier.padding(8.dp)
        )
    }
}
