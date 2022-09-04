package com.example.scanner.di

import android.content.Context
import com.example.scanner.data.database.MyDatabase
import com.example.scanner.data.database.dao.MyDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ScanModule() {

    @Provides
    @Singleton
    fun provideDao(context: Context): MyDao{
        return MyDatabase.getInstance(context).getMyDao()
    }

}