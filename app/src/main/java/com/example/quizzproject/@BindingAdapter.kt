package com.example.quizzproject

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("items")
fun setItems(recyclerView: RecyclerView, items: List<Any>) {
    recyclerView.adapter = MyAdapter(items as List<String>)
}