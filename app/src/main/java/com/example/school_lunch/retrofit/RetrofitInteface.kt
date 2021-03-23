package com.example.school_lunch.retrofit

import com.example.school_lunch.data.Row
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


// 서버에서 호출할 메서드를 선언하는 인터페이스
interface RetrofitInteface {

    // 코드의 재사용성을 높이기 위해 여기서 meal service를 value 값으로 넣어준다.
    @GET("/mealServiceDietInfo?")
    fun ApiService(@Query("ATPT_OFCDC_SC_CODE") ATPT_OFCDC_SC_CODE: String,
                   @Query("ATPT_OFCDC_SC_NM") ATPT_OFCDC_SC_NM: String,
                   @Query("SD_SCHUL_CODE") SD_SCHUL_CODE: String,
                   @Query("SCHUL_NM") SCHUL_NM: String,
                   @Query("MMEAL_SC_CODE") MMEAL_SC_CODE: String,
                   @Query("MMEAL_SC_NM") MMEAL_SC_NM: String,
                   @Query("MLSV_YMD") MLSV_YMD: String,
                   @Query("MLSV_FGR") MLSV_FGR: String,
                   @Query("DDISH_NM") DDISH_NM: String,
                   @Query("ORPLC_INFO") ORPLC_INFO: String,
                   @Query("CAL_INFO") CAL_INFO: String,
                   @Query("NTR_INFO") NTR_INFO: String,
                   @Query("MLSV_FROM_YMD") MLSV_FROM_YMD: String,
                   @Query("MLSV_TO_YMD") MLSV_TO_YMD: String): Call<Row>
}