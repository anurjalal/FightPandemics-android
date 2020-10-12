package com.fightpandemics.data.model.posts

data class Author(
    val id: String,
    val location: Location?,
    val name: String?,
    val photo: String?,
    val type: String?
)