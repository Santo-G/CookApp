package com.santog.cookapp.network.model

import com.santog.cookapp.domain.model.Recipe
import com.santog.cookapp.domain.util.EntityMapper


class RecipeNetworkMapper : EntityMapper<RecipeDTO, Recipe> {

    override fun mapFromEntity(entity: RecipeDTO): Recipe {
        return Recipe(
            cooking_instructions = entity.cookingInstructions,
            date_added = entity.dateAdded,
            date_updated = entity.dateUpdated,
            description = entity.description,
            featured_image = entity.featuredImage,
            ingredients = entity.ingredients ?: listOf(),
            long_date_added = entity.longDateAdded,
            long_date_updated = entity.longDateUpdated,
            pk = entity.pk,
            publisher = entity.publisher,
            rating = entity.rating,
            source_url = entity.sourceUrl,
            title = entity.title
        )
    }

    override fun mapToEntity(domainModel: Recipe): RecipeDTO {
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
            mapFromEntity(recipeDTO)
        }
    }

    fun toEntityList(initial : List<Recipe>) : List<RecipeDTO> {
        return initial.map { recipe ->
            mapToEntity(recipe)
        }
    }

}
