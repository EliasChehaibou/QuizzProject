package com.example.quizzproject

import android.app.AlertDialog
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
        val binding: QuestionBinding = DataBindingUtil.setContentView(this, R.layout.question)
        val layoutManager = LinearLayoutManager(findViewById<RecyclerView>(R.id.recycler_view).context,LinearLayoutManager.VERTICAL, false)
        findViewById<RecyclerView>(R.id.recycler_view).setLayoutManager(layoutManager)
        val jsonObject = questionnaire.instance.jsonArray.getJSONObject(MyApplication.num_page)
        val qst: String = jsonObject.get("question") as String
        binding.question = qst
        val answers_obj: JSONObject = jsonObject.get("answers") as JSONObject
        val answers = getNonNullValues(answers_obj)
        binding.answers = answers
        if (MyApplication.num_page+1<questionnaire.instance.jsonArray.length()) {
            binding.bouton = "NEXT"
        }
        else {
            binding.bouton = "END"
        }
        binding.executePendingBindings()
    }

    fun goHome(view: View) {
        MyApplication.num_page = 0
        MyApplication.score = 0
        val intent = Intent(this, home::class.java)
        startActivity(intent)
    }

    fun checkLists(booleanList: List<Boolean>, stringList: List<String>) : Boolean {
        if (booleanList.size != stringList.size) {
            return false
        }
        for (i in booleanList.indices) {
            if (booleanList[i] && stringList[i] != "true") {
                return false
            }
            if (!booleanList[i] && stringList[i] != "false") {
                return false
            }
        }
        return true
    }

    fun goNextActivity() {
        if (MyApplication.num_page+1<questionnaire.instance.jsonArray.length()) {
            MyApplication.num_page = MyApplication.num_page+1
            val intent = Intent(this, question::class.java)
            startActivity(intent)
        }
        else {
            val intent = Intent(this, result::class.java)
            startActivity(intent)
        }
    }

    fun filterList(booleanList: List<String>, stringList: List<String>) : String {
        var result = ""
        for (i in booleanList.indices) {
            if (booleanList[i] == "true") {
                result = result + stringList[i] + "\n"
            }
        }
        return result
    }

    fun goNext(view: View) {
        val adapter = findViewById<RecyclerView>(R.id.recycler_view).adapter as MyAdapter
        val selectedAnswers = adapter.selectedAnswers
        val jsonObject = questionnaire.instance.jsonArray.getJSONObject(MyApplication.num_page)
        val correct_answers_obj: JSONObject = jsonObject.get("correct_answers") as JSONObject
        val correct_answers = getNonNullValues(correct_answers_obj)
        val answers_obj: JSONObject = jsonObject.get("answers") as JSONObject
        val answers = getNonNullValues(answers_obj)
        if (checkLists(selectedAnswers,correct_answers )) {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("True")
            builder.setPositiveButton("OK") { dialog, which ->
                goNextActivity()
            }
            val alertDialog: AlertDialog = builder.create()

            alertDialog.show()
            MyApplication.score = MyApplication.score+1
        } else {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("False")
            builder.setMessage("The correct response is: \n"+filterList(correct_answers,answers ))
            builder.setPositiveButton("OK") { dialog, which ->
                goNextActivity()
            }
            val alertDialog: AlertDialog = builder.create()
            alertDialog.show()
        }
    }
}