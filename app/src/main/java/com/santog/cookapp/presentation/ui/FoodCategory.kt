package com.santog.cookapp.presentation.ui

import com.santog.cookapp.presentation.ui.FoodCategory.*

enum class FoodCategory(val value: String) {
    CHICKEN("Chicken"),
    BEEF("Beef"),
    SOUP("Soup"),
    DESSERT("Dessert"),
    VEGETARIAN("Vegetarian"),
    MILK("Milk"),
    VEGAN("Vegan"),
    PIZZA("Pizza"),
    DONUT("Donut"),
}

fun getAllFoodCategories(): List<FoodCategory> {
    return listOf(
        CHICKEN, BEEF, SOUP, DESSERT, VEGETARIAN, MILK, VEGAN, PIZZA, DONUT
    )
}

fun getFoodCategory(value: String): FoodCategory? {
    val map = values().associateBy(FoodCategory::value)
    return map[value]
}
