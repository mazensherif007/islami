package com.example.islami.ui.quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.islami.R

class ChapterRecyclerAdapter(private val chapters: List<String>) :
    Adapter<ChapterRecyclerAdapter.ViewHolder>() {

    var onItemClickListener: OnItemClickListener? = null

    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val title: TextView = itemview.findViewById(R.id.chapter_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chapter, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = chapters.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val title = chapters[position]
        holder.title.setText(title)
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener {
                onItemClickListener?.onItemClick(position, title)
            }
        }
    }

    fun interface OnItemClickListener {
        fun onItemClick(position: Int, title: String)
    }
}
