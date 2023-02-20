package com.santog.cookapp.domain.util

/**
 *  Map a Recipe to a NetworkEntity
 *  Entity -------->  RecipeDTO
 *  DomainModel --->  Recipe
 */
interface EntityMapper <Entity, DomainModel> {

    fun mapFromEntity(entity : Entity) : DomainModel
    fun mapToEntity(domainModel: DomainModel) : Entity

}
