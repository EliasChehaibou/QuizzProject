package com.example.quizzproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONArray

class linux_prez : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.linux_prez)
    }

    fun startLinuxquizz(view: View) {
        val asyncTask = AsyncCall(object : AsyncCall.Callback {
            override fun onTaskCompleted(result: JSONArray) {
                questionnaire.instance.jsonArray = result
            }
        })
        val a = asyncTask.execute("Linux").get()
        val intent = Intent(this, question::class.java)
        startActivity(intent)

    }
}