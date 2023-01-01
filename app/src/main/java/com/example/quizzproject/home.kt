package com.example.quizzproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)
    }

    fun goResult(view: View) {
        val intent = Intent(this, result::class.java)
        startActivity(intent)
    }

    fun goSQLprez(view: View) {
        val intent = Intent(this, sql_prez::class.java)
        startActivity(intent)
    }
    fun goLinuxprez(view: View) {
        val intent = Intent(this, linux_prez::class.java)
        startActivity(intent)
    }
    fun goDockerprez(view: View) {
        val intent = Intent(this, docker_prez::class.java)
        startActivity(intent)
    }
}