package com.santog.cookapp.domain.util

/**
 *  Map a Recipe to a NetworkEntity
 *  T -------->  RecipeDTO
 *  DomainModel --->  Recipe
 */
interface DomainMapper<T, DomainModel> {

    fun mapToDomainModel(model: T): DomainModel
    fun mapFromDomainModel(domainModel: DomainModel): T

}
