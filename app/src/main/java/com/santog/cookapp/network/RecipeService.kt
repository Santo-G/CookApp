package com.santog.cookapp.network

import com.santog.cookapp.network.model.RecipeDTO
import com.santog.cookapp.network.responses.ResponseDTO
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RecipeService {

    @GET("search")
    suspend fun search(
        @Header("Autorization") token : String,
        @Query("page") page : Int,
        @Query("query") query : String
    ) : ResponseDTO

    @GET("get")
    suspend fun get(
        @Header("Autorization") token : String,
        @Query("id") id : Int
    ) : RecipeDTO

}