package com.example.scanner.presentation.history

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.scanner.R
import com.example.scanner.domain.models.HistoryModel
import kotlinx.android.synthetic.main.scan_item.view.*

class HistoryAdapter: RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {
    private var list = emptyList<HistoryModel>()

    class HistoryViewHolder(view:View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.scan_item, parent, false)
        return HistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.itemView.msg.text = list[position].message
    }

    override fun getItemCount(): Int  = list.size

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list2: List<HistoryModel>) {
        list = list2
        notifyDataSetChanged()
    }
}