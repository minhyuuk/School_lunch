package com.example.school_lunch.retrofit

import com.example.school_lunch.data.Row
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInteface {
    @GET("/mealServiceDietInfo")
    fun  ApiService(
        @Query("시도교육청코드") ATPT_OFCDC_SC_CODE:String
    ): Call<Row>

}