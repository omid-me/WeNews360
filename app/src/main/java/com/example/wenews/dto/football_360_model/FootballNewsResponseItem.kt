package com.example.wenews.dto.football_360_model

import com.example.wenews.model.football_model.PostModel


data class FootballNewsResponseItem(
    val default_cover: Any,
    val id: String,
    val key: String,
    val mobile_order: Int,
    val order: Int,
    val page: String,
    val posts: List<Post>,
    val redirect_to: Any,
    val section_type: Any,
    val section_type_mobile: Any,
    val sort_by: String,
    val sort_order: String,
    val title: String
)
fun FootballNewsResponseItem.getFootballPostModel():List<PostModel>{

    return posts.map {
        PostModel(
            id=it.post.code.toInt(),
            title = it.post.title,
            cover = it.post.primary_media,
            createdAt = it.post.created_at.toString(),
            body = it.post.sub_title,
            author = it.post.author.full_name

        )
    }
}





