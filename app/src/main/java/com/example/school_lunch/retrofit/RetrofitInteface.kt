package com.example.school_lunch.retrofit

import com.example.school_lunch.data.Row
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


// 서버에서 호출할 메서드를 선언하는 인터페이스
interface RetrofitInteface {

    @GET("mealServiceDietInfo?/{ATPT_OFCDC_SC_CODE}")
    fun  ApiService(@Query("시도교육청코드") ATPT_OFCDC_SC_CODE:String): Call<Row>


}