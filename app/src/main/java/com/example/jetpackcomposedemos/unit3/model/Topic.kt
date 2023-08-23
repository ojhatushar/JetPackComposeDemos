package com.example.jetpackcomposedemos.unit3.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val name: Int,
    val availableCourses: Int,
    @DrawableRes val imagesRes: Int
)
