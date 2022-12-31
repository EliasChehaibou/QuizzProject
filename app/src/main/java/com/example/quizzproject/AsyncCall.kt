package com.example.quizzproject

import android.os.AsyncTask
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import com.google.gson.Gson
import org.json.JSONArray

internal class AsyncCall : AsyncTask<String, String, String>() {
    override fun doInBackground(vararg params: String?): String? {
        val param = params[0]
        val url = URL("https://quizapi.io/api/v1/questions?apiKey=aCR3XVbrLsb0O5jsa7nwwtnF45zS5bUgdQDfSlVW&category="+param+"&limit=10")
        val connection = url.openConnection() as HttpURLConnection
        connection.requestMethod = "GET"
        connection.setRequestProperty("Content-Type", "application/json")
        connection.connect()
        val inputStream = connection.inputStream
        val reader = BufferedReader(InputStreamReader(inputStream))

        var qst = ""
        var line: String? = reader.readLine()
        while (line != null) {
            qst += line
            line = reader.readLine()
        }
        println(qst)
        connection.disconnect()
        return qst
    }

    override fun onPostExecute(result: String?) {
            val gson = Gson()
            val jsonArray = JSONArray(result)
            val jsonObject = jsonArray.getJSONObject(1)
            println(jsonObject)
            val questionnaire = gson.fromJson(gson.toJson(jsonObject), questionnaire::class.java)

            println(questionnaire)
    }
}