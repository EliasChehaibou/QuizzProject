package com.example.quizzproject

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class docker_prez : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.docker_prez)
    }
    fun startDockerquizz(view: View) {
        val asyncTask = AsyncCall()
        asyncTask.execute("Docker")

    }
}