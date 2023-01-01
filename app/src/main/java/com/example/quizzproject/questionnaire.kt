package com.example.quizzproject

import org.json.JSONArray

class questionnaire private constructor() {
    companion object {
        val instance: questionnaire by lazy { questionnaire() }
    }
    var jsonArray: JSONArray = JSONArray()
}