package com.example.scanner.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.scanner.domain.models.HistoryModel
import io.reactivex.Flowable
import io.reactivex.Observable

@Dao
interface MyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(model: HistoryModel)

    @Query("SELECT * from my_table")
    fun getBests(): LiveData<List<HistoryModel>>

}