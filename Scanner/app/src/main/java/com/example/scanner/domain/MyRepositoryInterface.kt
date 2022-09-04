package com.example.scanner.domain

import androidx.lifecycle.LiveData
import com.example.scanner.domain.models.HistoryModel
import io.reactivex.Flowable
import io.reactivex.Observable

interface MyRepositoryInterface {
    val allScans: LiveData<List<HistoryModel>>

    fun insert(model: HistoryModel)
}