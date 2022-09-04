package com.example.scanner.data.database.repository

import androidx.lifecycle.LiveData
import com.example.scanner.data.database.dao.MyDao
import com.example.scanner.domain.MyRepositoryInterface
import com.example.scanner.domain.models.HistoryModel
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject

class MyRepository @Inject constructor(private val myDao: MyDao): MyRepositoryInterface {
    override val allScans: LiveData<List<HistoryModel>>
        get() = myDao.getBests()

    override fun insert(model: HistoryModel) {
        myDao.insert(model)
    }
}