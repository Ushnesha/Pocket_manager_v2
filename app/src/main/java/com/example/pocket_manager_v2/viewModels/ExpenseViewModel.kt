package com.example.pocket_manager_v2.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.pocket_manager_v2.db.ExpenseDatabase
import com.example.pocket_manager_v2.entity.Expense
import com.example.pocket_manager_v2.repository.ExpenseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExpenseViewModel(application: Application) : AndroidViewModel(application){

    private val repository:ExpenseRepository
    val expenses : LiveData<List<Expense>>

    init{
        val expenseDao = ExpenseDatabase.getDatabase(getApplication(), viewModelScope).expenseDao()
        repository = ExpenseRepository(expenseDao)
        expenses=repository.allExpenses
    }

    fun insert(expense: Expense) = viewModelScope.launch (Dispatchers.IO){
        repository.insert(expense)
    }

}