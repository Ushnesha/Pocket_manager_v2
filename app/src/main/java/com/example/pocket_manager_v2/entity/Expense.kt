package com.example.pocket_manager_v2.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "expense_detail")
data class Expense(@PrimaryKey
                   @ColumnInfo(name="expenseId")
                   val id : String = UUID.randomUUID().toString(),
                   @ColumnInfo(name="balance")
                   val bal : String,
                   @ColumnInfo(name="description")
                   val desc : String,
                   @ColumnInfo(name="date")
                   val date : String)