package com.example.wenews.network

import com.example.wenews.dto.football_360_model.FootballNewsResponse
import com.example.wenews.dto.post_models.PostModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("posts")
 suspend fun getNewsPosts():Response<List<PostModel>>

 @GET("sections/")
 suspend fun getFootballNewsPosts(@Query("page")page:String):Response<FootballNewsResponse>

}