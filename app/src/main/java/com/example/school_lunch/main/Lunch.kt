package com.example.school_lunch.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import android.util.Log
import com.example.school_lunch.retrofit.RetrofitBuilder
import com.example.school_lunch.databinding.ActivityLunchBinding
import java.text.SimpleDateFormat
import java.util.*
import com.example.school_lunch.data.Meal
import retrofit2.Callback
import retrofit2.Response

// Main

// retrofit interface 사용
class Lunch : AppCompatActivity() {

    val sec: Long = System.currentTimeMillis() // 현재 시간
    val date = Date(sec) // 현재 시간 저장

    val dateFormatOne = SimpleDateFormat("yyyyMMdd", Locale("ko", "KR")).format(date)
    val dateFormatTwo = SimpleDateFormat("yyyy년 MM월 dd일 \nEE요일", Locale("ko", "KR")).format(date)

    val sTime = dateFormatTwo.format(date)

    // 식사코드 1,2,3
    // 아침 점심 저녁 순으로 배정
    var time: Int = 0

    val bind by lazy { ActivityLunchBinding.inflate(layoutInflater) }

    val TAG: String = "로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bind.root)

        bind.today.text = sTime

        bind.morning.setOnClickListener {
            time = 1
            Build()
        }
        bind.lunch.setOnClickListener {
            time = 2
            Build()
        }
        bind.dinner.setOnClickListener {
            time = 3
            Build()
        }


    }

    fun Build() {
        RetrofitBuilder.getInstance.ApiService("${dateFormatOne}",time).enqueue(object : Callback<Meal> {



            override fun onResponse(call: Call<Meal>, response: Response<Meal>) {

                val res = response.body()!!.mealServiceDietInfo[1].row
                if (res != null) {

                    for (i in 0 until res.size) {

                        val obj = res.get(i)
                        val row = obj.DDISH_NM
                                .replace("/", "")
                                .replace("<br/>", "\n")
                                .replace("<br>", "\n")
                                .replace("*", "")
                                .replace("."+i, "")

                        when (time) {
                            1 -> {
                                bind.textMorning.text = row
                                Log.d(TAG, "onFirstResponse: ${row}")
                            }
                            2 -> {
                                bind.textLunch.text = row
                                Log.d(TAG, "onSecondResponse: ${row}")
                            }
                            3 -> {
                                bind.textDinner.text = row
                                Log.d(TAG, "onThirdResponse: ${row}")
                            }
                        }

                    }
                    Log.d(TAG, "성공 : ${response.raw()}")
                }
            }

            override fun onFailure(call: Call<Meal>, t: Throwable) {
                Log.d(TAG, "실패 - ${t} ")
            }

        })
    }


}