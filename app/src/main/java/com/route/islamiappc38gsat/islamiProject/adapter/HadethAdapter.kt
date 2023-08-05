package com.route.islamiappc38gsat.islamiProject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.route.islamiappc38gsat.R
import com.route.islamiappc38gsat.islamiProject.data.Hadeth

class HadethAdapter(var hadethList: List<Hadeth>? = null) :
    Adapter<HadethAdapter.HadethViewHolder>() {
    var onHadethItemClickListener: OnHadethItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadethViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hadeth, parent, false)
        return HadethViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hadethList?.size ?: 0
    }

    override fun onBindViewHolder(holder: HadethViewHolder, position: Int) {
        val item = hadethList?.get(position)
        holder.hadethTextView.text = item?.hadethTitle
        holder.view.setOnClickListener {
            onHadethItemClickListener?.onHadethClick(item ?: return@setOnClickListener)
        }
    }

    fun updateData(hadethList: List<Hadeth>) {
        this.hadethList = hadethList
        notifyDataSetChanged()

    }

    class HadethViewHolder(val view: View) : ViewHolder(view) {
        val hadethTextView: TextView = view.findViewById(R.id.hadeth_text)
    }


}
