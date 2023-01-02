package com.example.quizzproject

import android.app.Application


class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        score = 0
        num_page = 0
    }

    companion object {
        var score = 0
        var num_page = 0
    }
}
