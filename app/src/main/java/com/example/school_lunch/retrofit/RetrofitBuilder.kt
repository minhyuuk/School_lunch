package com.example.school_lunch.retrofit

import android.util.Log
import androidx.constraintlayout.widget.Constraints.TAG
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// 싱글턴, 메모리를 하나만 사용
object RetrofitBuilder {

    // 레트로핏 클라이언트 선언
    private var instance: Retrofit? = null
//    private lateinit var retrofitClient : Retrofit

    // 레트로핏 클라이언트 가져오기

    // 싱글톤
    fun getInstance(): Retrofit? {
        Log.d(TAG, "RetrofitClient - getClient() 호출")

        if (instance == null) {

            // 레트로핏 빌더를 통해 인스턴스 생성
            instance = Retrofit.Builder()
                    .baseUrl("https://open.neis.go.kr/hub")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
        return instance
    }

    private fun createOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        builder.addInterceptor(interceptor)
        return builder.build()

    }
}