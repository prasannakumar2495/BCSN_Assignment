package com.example.bcsnassignment.viewmodel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bcsnassignment.R
import com.example.bcsnassignment.model.BinanceAPIItem

class BCSNRecyclerAdapter(val contextBCSN: Context, val userList: List<BinanceAPIItem>) :
    RecyclerView.Adapter<BCSNRecyclerAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var volume: TextView = itemView.findViewById(R.id.recyclerTV2)
        var lastPrice: TextView = itemView.findViewById(R.id.recyclerTV4)
        var priceChange: TextView = itemView.findViewById(R.id.recyclerTV6)
        var priceChangePercent: TextView = itemView.findViewById(R.id.recyclerTV8)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView =
            LayoutInflater.from(contextBCSN).inflate(
                R.layout.recyclerviewlayout,
                parent, false
            )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.volume.text = userList[position].volume
        holder.lastPrice.text = userList[position].lastPrice
        holder.priceChange.text = userList[position].priceChange
        holder.priceChangePercent.text = userList[position].priceChangePercent
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}