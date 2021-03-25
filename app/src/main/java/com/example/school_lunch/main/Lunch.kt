package com.example.school_lunch.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.school_lunch.R

// Main

// retrofit interface 사용
class Lunch : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lunch)
    }
}