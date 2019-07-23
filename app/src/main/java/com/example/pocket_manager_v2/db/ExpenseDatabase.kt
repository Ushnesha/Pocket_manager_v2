package com.example.pocket_manager_v2.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.pocket_manager_v2.dao.ExpenseDao
import com.example.pocket_manager_v2.entity.Expense
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Expense::class], version = 1)
abstract  class ExpenseDatabase : RoomDatabase(){

    abstract fun expenseDao() : ExpenseDao

    companion object {

        @Volatile
        private var INSTANCE : ExpenseDatabase? = null

        fun getDatabase(context  :Context, scope : CoroutineScope) : ExpenseDatabase{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                    ExpenseDatabase::class.java,
                    "Expense_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(ExpenseDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }

        private class ExpenseDatabaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback(){
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                INSTANCE?.let { db -> scope.launch(Dispatchers.IO){
                    populateDb(db.expenseDao())
                } }
            }
        }

        suspend fun populateDb(expenseDao: ExpenseDao ){
            expenseDao.deleteAll()
        }

    }
}