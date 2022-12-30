package com.example.quizzproject

import android.os.AsyncTask
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

internal class AsyncCall : AsyncTask<String, String, String>() {
    override fun doInBackground(vararg params: String?): String {
        val param = params[0]
        val url = URL("https://quizapi.io/api/v1/questions?apiKey=aCR3XVbrLsb0O5jsa7nwwtnF45zS5bUgdQDfSlVW&category="+param+"&limit=10")
        val connection = url.openConnection() as HttpURLConnection
        connection.requestMethod = "GET"
        connection.setRequestProperty("Content-Type", "application/json")
        connection.connect()
        val inputStream = connection.inputStream
        val reader = BufferedReader(InputStreamReader(inputStream))

        var line: String? = reader.readLine()
        while (line != null) {
            println(line)
            line = reader.readLine()
        }
        connection.disconnect()
        return "Résultat"
    }

    override fun onPostExecute(result: String?) {

    }
}