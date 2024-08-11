package com.example.islami.ui.hadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.ItemHadethBinding

class HadethListAdapter(val hadethList: List<Hadeth>) :
    RecyclerView.Adapter<HadethListAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemHadethBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHadethBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = hadethList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.chapterTitle.text = hadethList[position].title

        if (onItemClickListener != null)
            holder.binding.root.setOnClickListener {
                onItemClickListener?.onItemClick(position, hadeth = hadethList[position])
            }
    }

    var onItemClickListener: OnItemClickListener? = null

    fun interface OnItemClickListener {
        fun onItemClick(position: Int, hadeth: Hadeth)
    }
}