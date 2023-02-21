package com.santog.cookapp.repository

import com.santog.cookapp.domain.model.Recipe
import com.santog.cookapp.network.RecipeService
import com.santog.cookapp.network.model.RecipeDTOMapper

class RecipeRepositoryImpl(
    private val recipeService: RecipeService,
    private val mapper: RecipeDTOMapper
) : RecipeRepository {

    override suspend fun search(token: String, page: Int, query: String): List<Recipe> {
        val result = recipeService.search(token, page, query).results
        return mapper.toDomainList(result)
    }

    override suspend fun get(token: String, id: Int): Recipe {
        val result = recipeService.get(token, id)
        return mapper.mapToDomainModel(result)
    }

}
