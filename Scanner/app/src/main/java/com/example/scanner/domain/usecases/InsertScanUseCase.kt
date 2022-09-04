package com.example.scanner.domain.usecases

import androidx.lifecycle.LiveData
import com.example.scanner.domain.MyRepositoryInterface
import com.example.scanner.domain.models.HistoryModel
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject

class InsertScanUseCase @Inject constructor(private val repo: MyRepositoryInterface) {
    fun execute(model: HistoryModel) = repo.insert(model)
}