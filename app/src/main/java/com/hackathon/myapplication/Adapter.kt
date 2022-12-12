package com.hackathon.myapplication

import android.icu.number.NumberFormatter.with
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

class Adapter(val list:List<Item>) : RecyclerView.Adapter<Adapter.AdapterViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.AdapterViewHolder {
        return AdapterViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_word, parent, false))
    }

    override fun onBindViewHolder(holder: Adapter.AdapterViewHolder, position: Int) {
        val item = list[position];
        holder.def.setText(item.definition);
        holder.type.setText(item.type)
    }

    override fun getItemCount(): Int {
        return list.size;
    }

    inner class AdapterViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val type = itemView.findViewById<EditText>(R.id.etText);
        val def = itemView.findViewById<Button>(R.id.btn)
    }
}