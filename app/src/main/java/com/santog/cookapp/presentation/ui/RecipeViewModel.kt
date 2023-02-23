package com.santog.cookapp.presentation.ui

import androidx.lifecycle.ViewModel
import com.santog.cookapp.repository.RecipeRepository
import javax.inject.Inject
import javax.inject.Named

class RecipeViewModel
@Inject constructor(
    private val repository: RecipeRepository,
    @Named("auth_token") private val token: String
) : ViewModel() {

    init {
        println("ViewModel repository value: $repository")
        println("ViewModel token value: $token")
    }

    fun getRepository() = repository

    fun getToken() = token

}
