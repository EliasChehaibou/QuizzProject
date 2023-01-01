package com.example.quizzproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizzproject.databinding.QuestionBinding
import org.json.JSONObject
import androidx.recyclerview.widget.RecyclerView



class question : AppCompatActivity()  {

    fun getNonNullValues(jsonObject: JSONObject): List<String> {
        val values = mutableListOf<String>()
        for (key in jsonObject.keys()) {
            val value = jsonObject.getString(key)
            if (value != "null") {
                values.add(value)
            }
        }
        return values
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val jsonObject = questionnaire.instance.jsonArray.getJSONObject(0)
        val binding: QuestionBinding = DataBindingUtil.setContentView(this, R.layout.question)
        val qst: String = jsonObject.get("question") as String
        binding.question = qst
        val layoutManager = LinearLayoutManager(findViewById<RecyclerView>(R.id.recycler_view).context,LinearLayoutManager.VERTICAL, false)
        findViewById<RecyclerView>(R.id.recycler_view).setLayoutManager(layoutManager)
        val answers_obj: JSONObject = jsonObject.get("answers") as JSONObject
        val answers = getNonNullValues(answers_obj)
        println(answers)
        binding.answers = answers
        binding.bouton = "Question suivante"
        println(jsonObject)
        binding.executePendingBindings()
    }

    fun goHome(view: View) {
        val intent = Intent(this, home::class.java)
        startActivity(intent)
    }

}