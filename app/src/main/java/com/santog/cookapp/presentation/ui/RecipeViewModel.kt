package com.santog.cookapp.presentation.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santog.cookapp.domain.model.Recipe
import com.santog.cookapp.repository.RecipeRepository
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

class RecipeViewModel
@Inject constructor(
    private val repository: RecipeRepository,
    @Named("auth_token") private val token: String
) : ViewModel() {

    val recipes: MutableState<List<Recipe>> = mutableStateOf(ArrayList())

    init {
        viewModelScope.launch {
            val result = repository.search(
                token = token,
                page = 1,
                query = "chicken"
            )
            recipes.value = result
        }
    }

}
