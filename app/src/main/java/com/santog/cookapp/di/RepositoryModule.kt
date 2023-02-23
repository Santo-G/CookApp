package com.santog.cookapp.di

import com.santog.cookapp.network.RecipeService
import com.santog.cookapp.network.model.RecipeDTOMapper
import com.santog.cookapp.repository.RecipeRepository
import com.santog.cookapp.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(
        // constructor dependency
        recipeService: RecipeService,
        recipeDTOMapper: RecipeDTOMapper
    ): RecipeRepository {
        return RecipeRepositoryImpl(
            recipeService,
            recipeDTOMapper
        )
    }
}
