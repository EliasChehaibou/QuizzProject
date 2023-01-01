package com.example.quizzproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class question : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val jsonObject = questionnaire.instance.jsonArray.getJSONObject(0)
        println(jsonObject)
        setContentView(R.layout.question)
    }
}