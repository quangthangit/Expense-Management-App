package com.example.expensemanagementapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.RecyclerView
import com.example.expensemanagementapp.R
import com.example.expensemanagementapp.data.Expense
import com.example.expensemanagementapp.ui.viewmodel.ExpenseViewModel

class ExpenseAdapter(private var itemList: MutableList<Expense>) : RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder>() {

    class ExpenseViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name)
        val date: TextView = itemView.findViewById(R.id.date)
        val cost: TextView = itemView.findViewById(R.id.cost)
        val title: TextView = itemView.findViewById(R.id.title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_expense, parent, false)
        return ExpenseViewHolder(view)
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val item = itemList[position]
        holder.name.text = item.name
        holder.date.text = item.date
        holder.title.text = item.name[0].toString()
        if(item.type == "income") {
            holder.cost.text = buildString {
                append("+ ")
                append(item.cost)
                append(" vnd")
            }
            holder.cost.setTextColor("#25A969".toColorInt())
        } else {
            holder.cost.text = buildString {
                append("- ")
                append(item.cost)
                append(" vnd")
            }
            holder.cost.setTextColor("#F95B51".toColorInt())
        }
    }

    fun getItemAt(position: Int): Expense = itemList[position]

    fun removeAt(position: Int) {
        itemList.removeAt(position)
        notifyItemRemoved(position)
    }
    fun submitList(newList: MutableList<Expense>) {
        itemList = newList
        notifyDataSetChanged()
    }
}