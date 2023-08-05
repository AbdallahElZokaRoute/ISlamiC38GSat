package com.route.islamiappc38gsat.islamiProject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.route.islamiappc38gsat.R

class VersesAdapter(var versesList: List<String>? = null) :
    Adapter<VersesAdapter.VerseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_verse, parent, false)
        return VerseViewHolder(view)
    }

    override fun getItemCount(): Int {
        return versesList?.size ?: 0
    }

    override fun onBindViewHolder(holder: VerseViewHolder, position: Int) {
        val item = versesList?.get(position)
        holder.verseTextView.text = item
    }

    fun updateData(versesList: List<String>?) {
        this.versesList = versesList
        notifyDataSetChanged()
    }

    class VerseViewHolder(val view: View) : ViewHolder(view) {
        val verseTextView: TextView = view.findViewById(R.id.verse_text)
    }


}