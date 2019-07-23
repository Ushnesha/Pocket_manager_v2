package com.example.pocket_manager_v2.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.pocket_manager_v2.dao.ExpenseDao
import com.example.pocket_manager_v2.entity.Expense

class ExpenseRepository(val expenseDao: ExpenseDao){
    val allExpenses : LiveData<List<Expense>> = expenseDao.getAllExpense()

    @WorkerThread
    suspend fun insert(expense: Expense){
        expenseDao.insert(expense)
    }

}