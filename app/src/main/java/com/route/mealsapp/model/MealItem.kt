package com.route.mealsapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class MealItem(

    @PrimaryKey
    @SerializedName("idCategory")
    val id: String = "",

    @SerializedName("strCategory")
    val name: String = "",

    @SerializedName("strCategoryThumb")
    val imgUrl: String = "",

    @SerializedName("strCategoryDescription")
    val description: String = "",
)
