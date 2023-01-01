package com.example.quizzproject

import android.os.AsyncTask
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import org.json.JSONArray

class AsyncCall( val callback: Callback) : AsyncTask<String, String, JSONArray>() {

    interface Callback {
        fun onTaskCompleted(result: JSONArray)
    }

    override fun doInBackground(vararg params: String?): JSONArray {
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
        connection.disconnect()
        return JSONArray(qst)
    }

    override fun onPostExecute(result: JSONArray?) {
        super.onPostExecute(result)
        callback.onTaskCompleted(result!!)
    }
}