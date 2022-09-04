package com.example.scanner.presentation.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.scanner.domain.models.HistoryModel
import com.example.scanner.domain.usecases.GetHistoryUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class HistoryViewModel @Inject constructor(private val getHistoryUseCase: GetHistoryUseCase): ViewModel() {

    fun getHistory() = getHistoryUseCase.execute()
}