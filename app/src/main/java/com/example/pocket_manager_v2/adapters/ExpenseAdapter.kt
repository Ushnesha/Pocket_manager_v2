package com.example.pocket_manager_v2.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pocket_manager_v2.R
import com.example.pocket_manager_v2.entity.Expense
import kotlin.math.exp

class ExpenseAdapter
internal constructor(context: Context) : RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder>(){

    private val inflater : LayoutInflater = LayoutInflater.from(context)
    private var expenses = emptyList<Expense>()

    inner class ExpenseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val balance : TextView = itemView.findViewById(R.id.bal)
        val desc  :TextView = itemView.findViewById(R.id.desc)
        val date  :TextView = itemView.findViewById(R.id.date)
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val exp = expenses[position]
        holder.balance.text=exp.bal
        holder.desc.text=exp.desc
        holder.date.text=exp.date
    }

    internal fun setExpenses(expenses:List<Expense>){
        this.expenses = expenses
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val itemView = inflater.inflate(R.layout.list_items, parent, false)
        return ExpenseViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return expenses.size
    }

}