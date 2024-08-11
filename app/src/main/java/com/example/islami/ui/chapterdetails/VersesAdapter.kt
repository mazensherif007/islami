package com.route.islamic41.ui.chapterDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.islami.databinding.ItemVerseBinding

class VersesAdapter(
    private val versesList: List<String>,
) : Adapter<VersesAdapter.ViewHolder>() {
    class ViewHolder(
        val binding: ItemVerseBinding,
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.item_verse,parent,false)
        val binding =
            ItemVerseBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = versesList.size

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int,
    ) {
        val content = versesList[position]
        holder.binding.content.text = "$content (${position + 1})"
    }
}