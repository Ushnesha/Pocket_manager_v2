package com.example.pocket_manager_v2.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.pocket_manager_v2.entity.Expense
import io.reactivex.Completable

@Dao
interface ExpenseDao{

    @Query("SELECT * FROM expense_detail ORDER by date DESC")
    fun getAllExpense() : LiveData<List<Expense>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(expense: Expense) : Completable

    @Delete
    suspend fun delete(expense: Expense)

    @Query("DELETE FROM expense_detail")
    fun deleteAll()
}