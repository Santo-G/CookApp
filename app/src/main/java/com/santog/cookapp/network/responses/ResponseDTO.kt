package com.santog.cookapp.network.responses


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import com.santog.cookapp.network.model.RecipeDTO

@Keep
data class ResponseDTO(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: String,
    @SerializedName("results")
    val results: List<RecipeDTO>
)
