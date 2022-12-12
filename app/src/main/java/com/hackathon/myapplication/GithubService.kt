package com.hackathon.myapplication

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("/{word}")
    suspend fun getWords(@Path("word") word:String): Response<ApiResult>
}