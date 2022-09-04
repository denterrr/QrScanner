package com.example.scanner.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_table")
data class HistoryModel (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo
    var message:String
)