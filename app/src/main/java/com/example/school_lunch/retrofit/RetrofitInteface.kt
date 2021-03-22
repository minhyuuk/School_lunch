package com.example.school_lunch.retrofit

import com.example.school_lunch.data.lunch
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInteface {
    @GET("open.neis.go.kr/hub/mealServiceDietInfo")
    fun  ApiService(): Call<lunch>
}