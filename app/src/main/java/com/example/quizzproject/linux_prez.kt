package com.example.quizzproject

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class linux_prez : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.linux_prez)
    }

    fun startLinuxquizz(view: View) {
        val asyncTask = AsyncCall()
        asyncTask.execute("Linux")

    }
}