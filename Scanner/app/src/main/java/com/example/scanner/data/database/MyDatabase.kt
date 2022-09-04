package com.example.scanner.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.scanner.data.database.dao.MyDao
import com.example.scanner.domain.models.HistoryModel

@Database(entities = [HistoryModel::class], version = 1)
abstract class MyDatabase: RoomDatabase() {

    abstract fun getMyDao(): MyDao

    companion object{
        private var startDatabase: MyDatabase ?= null

        @Synchronized
        fun getInstance(context: Context): MyDatabase{
            return if(startDatabase==null){
                startDatabase = Room.databaseBuilder(context,MyDatabase::class.java,"db").build()
                startDatabase as MyDatabase
            }else{
                startDatabase as MyDatabase
            }
        }
    }
}