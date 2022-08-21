package com.example.wenews.dto.football_360_model

data class InstanceData(
    val country: Country,
    val full_title: String,
    val fullname: String,
    val id: String,
    val image: String,
    val is_active: Boolean,
    val is_national: Boolean,
    val kit_number: Int,
    val logo: String,
    val person: Person,
    val position: Position,
    val slug: String,
    val thumbnail: String,
    val title: String
)