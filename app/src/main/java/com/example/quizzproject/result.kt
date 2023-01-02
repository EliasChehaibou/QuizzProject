package com.example.quizzproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.quizzproject.databinding.ResultBinding


class result : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ResultBinding = DataBindingUtil.setContentView(this, R.layout.result)
        binding.score = "You get a score of "+MyApplication.score+"/10"
    }

    fun goHome(view: View) {
        MyApplication.num_page = 0
        MyApplication.score = 0
        val intent = Intent(this, home::class.java)
        startActivity(intent)
    }

    fun shareViaGmail(view : View) {
        val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_SUBJECT, "")
            putExtra(Intent.EXTRA_TEXT, "I had a score of "+MyApplication.score+"/10 in my Quizz !")
        }
        startActivity(Intent.createChooser(emailIntent, null))
    }

}