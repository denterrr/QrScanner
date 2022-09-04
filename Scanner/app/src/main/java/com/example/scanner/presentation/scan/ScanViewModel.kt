package com.example.scanner.presentation.scan

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.scanner.data.database.MyDatabase
import com.example.scanner.data.database.dao.MyDao
import com.example.scanner.domain.models.HistoryModel
import com.example.scanner.domain.usecases.InsertScanUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ScanViewModel @Inject constructor(private val insertScanUseCase: InsertScanUseCase):ViewModel() {

    fun insertScan(scan: HistoryModel) {
        viewModelScope.launch(Dispatchers.IO) {
            insertScanUseCase.execute(scan)
        }
    }

}