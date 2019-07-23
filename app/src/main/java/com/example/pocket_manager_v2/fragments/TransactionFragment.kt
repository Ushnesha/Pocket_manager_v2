package com.example.pocket_manager_v2.fragments


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.pocket_manager_v2.R
import com.example.pocket_manager_v2.adapters.ExpenseAdapter
import com.example.pocket_manager_v2.ui.ExpenseDetailActivity
import com.example.pocket_manager_v2.viewModels.ExpenseViewModel
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fragment_transaction.*


class TransactionFragment : Fragment() {

    private var modelView : ExpenseViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_transaction, container, false)

        return rootView
    }

    companion object {
        const val newExpenseActivityRequestCode=1
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         val adt = ExpenseAdapter(activity!!)
        recycler_view.adapter=adt
        recycler_view.layoutManager=LinearLayoutManager(activity)

        modelView=ViewModelProviders.of(activity!!).get(ExpenseViewModel::class.java)
        modelView!!.expenses.observe(activity!!, Observer { expenses ->
            expenses?.let{
                adt.setExpenses(expenses)
            }

        })

        fab.setOnClickListener{
            val intent = Intent(activity!!, ExpenseDetailActivity::class.java)
            startActivityForResult(intent, newExpenseActivityRequestCode)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

    }

}