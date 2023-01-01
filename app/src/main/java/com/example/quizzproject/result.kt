package com.example.quizzproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class result : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result)
    }

    fun goHome(view: View) {
        val intent = Intent(this, home::class.java)
        startActivity(intent)
    }

    fun shareViaGmail(view : View) {
        val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_SUBJECT, "")
            putExtra(Intent.EXTRA_TEXT, "I had a score of x/10 in my ---- Quizz !")
        }
        startActivity(Intent.createChooser(emailIntent, null))
    }

}