package com.example.quizzproject

import com.google.gson.Gson

class questionnaire {
    var id: Int? = null
    var question: String? = null
    val gson = Gson()
    var answers = gson.fromJson("", answers::class.java)
    var multiple_correct_answers: Boolean? = null
    var correct_answers = gson.fromJson("", correct_answers::class.java)
    var category: String? = null
    var explanation: String? = null
    var tip: String? = null
    var tags: String? = null
    var difficulty: String? = null
}