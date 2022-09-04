package com.example.scanner.di

import com.example.scanner.data.database.repository.MyRepository
import com.example.scanner.domain.MyRepositoryInterface
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun bindrepo(repo: MyRepository):MyRepositoryInterface
}