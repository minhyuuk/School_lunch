package com.example.school_lunch.retrofit

import com.example.school_lunch.data.Meal
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


// 서버에서 호출할 메서드를 선언하는 인터페이스
interface RetrofitInteface {

    // 코드의 재사용성을 높이기 위해 여기서 meal service를 value 값으로 넣어준다.
    @GET("hub/mealServiceDietInfo?")
    fun ApiService(
            @Query("MLSV_YMD") day: String, // 식사 일자
            @Query("MMEAL_SC_CODE") num: Int, // 아침 점심 저녁, 1,2,3
            @Query("ATPT_OFCDC_SC_CODE") gwangju: String = "F10", // 광주 교육청 코드,  F10
            @Query("SD_SCHUL_CODE") school: Int = 7380292, // 표준 학교 코드, 7380292
            @Query("KEY") key: String = "9e67bf29119b4c5389bec9404585ad45", // api 인증키, 9e67bf29119b4c5389bec9404585ad45
            @Query("Type") Type: String = "json", // json 타입
            @Query("pIndex") pIndex: Int? = 1, // 페이지 위치            |   기본값 : 1(sample key는 1 고정)
            @Query("psize") pSize: Int? = 100  // 페이지 당 신청 숫자     |  기본값 : 100(sample key는 5 고정)

    ): Call<Meal>

}