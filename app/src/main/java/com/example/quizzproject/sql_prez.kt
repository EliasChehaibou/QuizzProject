package com.example.quizzproject

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class sql_prez : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sql_prez)
    }

    fun startSQLquizz(view: View) {
        val asyncTask = AsyncCall()
        asyncTask.execute("SQL")

    }
}