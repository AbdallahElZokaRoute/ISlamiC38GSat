package com.route.islamiappc38gsat.islamiProject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.route.islamiappc38gsat.R
import com.route.islamiappc38gsat.islamiProject.data.SuraName

class SuraNamesAdapter(val suraNamesList: List<SuraName>) :
    Adapter<SuraNamesAdapter.SuraNamesViewHolder>() {
    var onSuraItemClickListener: OnSuraItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuraNamesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_sura_name, parent, false)
        return SuraNamesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return suraNamesList.size
    }

    override fun onBindViewHolder(holder: SuraNamesViewHolder, position: Int) {
        val item = suraNamesList.get(position)
        holder.suraName.text = item.name
        holder.suraPosition.text = "${item.positionOfSura}"
        holder.view.setOnClickListener {
            onSuraItemClickListener?.onSuraClick(item)
        }

    }

    class SuraNamesViewHolder(val view: View) : ViewHolder(view) {
        val suraName: TextView = view.findViewById(R.id.sura_name)
        val suraPosition: TextView = view.findViewById(R.id.sura_position)

    }

}