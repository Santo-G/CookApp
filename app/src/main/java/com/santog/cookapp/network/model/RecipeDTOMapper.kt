package com.santog.cookapp.network.model

import com.santog.cookapp.domain.model.Recipe
import com.santog.cookapp.domain.util.DomainMapper


class RecipeDTOMapper : DomainMapper<RecipeDTO, Recipe> {

    override fun mapToDomainModel(model: RecipeDTO): Recipe {
        return Recipe(
            cooking_instructions = model.cookingInstructions,
            date_added = model.dateAdded,
            date_updated = model.dateUpdated,
            description = model.description,
            featured_image = model.featuredImage,
            ingredients = model.ingredients ?: listOf(),
            long_date_added = model.longDateAdded,
            long_date_updated = model.longDateUpdated,
            pk = model.pk,
            publisher = model.publisher,
            rating = model.rating,
            source_url = model.sourceUrl,
            title = model.title
        )
    }

    override fun mapFromDomainModel(domainModel: Recipe): RecipeDTO {
        return RecipeDTO (
            cookingInstructions = domainModel.cooking_instructions,
            dateAdded = domainModel.date_added,
            dateUpdated = domainModel.date_updated,
            description = domainModel.description,
            featuredImage = domainModel.featured_image,
            ingredients = domainModel.ingredients,
            longDateAdded = domainModel.long_date_added,
            longDateUpdated = domainModel.long_date_updated,
            pk = domainModel.pk,
            publisher = domainModel.publisher,
            rating = domainModel.rating,
            sourceUrl = domainModel.source_url,
            title = domainModel.title
        )
    }

    fun fromEntityList(initial : List<RecipeDTO>) : List<Recipe> {
        return initial.map { recipeDTO ->
            mapToDomainModel(recipeDTO)
        }
    }

    fun toEntityList(initial : List<Recipe>) : List<RecipeDTO> {
        return initial.map { recipe ->
            mapFromDomainModel(recipe)
        }
    }

}
