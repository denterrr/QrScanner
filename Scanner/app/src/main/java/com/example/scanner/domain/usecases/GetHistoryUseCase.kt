package com.example.scanner.domain.usecases

import com.example.scanner.domain.MyRepositoryInterface
import javax.inject.Inject

class GetHistoryUseCase @Inject constructor(private val repo: MyRepositoryInterface) {
    fun execute() = repo.allScans
}