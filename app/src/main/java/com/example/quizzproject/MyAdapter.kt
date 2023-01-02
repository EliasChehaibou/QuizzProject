package com.example.quizzproject

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject

class MyAdapter(private val stringList: List<String>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    internal val selectedAnswers = mutableListOf<Boolean>()

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


    init {
        val jsonObject = questionnaire.instance.jsonArray.getJSONObject(MyApplication.num_page)
        val answers_obj: JSONObject = jsonObject.get("answers") as JSONObject
        val answers = getNonNullValues(answers_obj)
        selectedAnswers.addAll(List(answers.size) { false })
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val checkbox: CheckBox = itemView.findViewById(R.id.checkbox)
        val textView: TextView = itemView.findViewById(R.id.text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.question, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.textView.text = stringList[position]
        holder.checkbox.setOnCheckedChangeListener { _, isChecked ->
            selectedAnswers[position] = isChecked
        }
    }

    override fun getItemCount() = stringList.size
}