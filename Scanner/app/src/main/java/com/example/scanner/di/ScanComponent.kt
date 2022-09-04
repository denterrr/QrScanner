package com.example.scanner.di

import android.content.Context
import com.example.scanner.presentation.history.HistoryFragment
import com.example.scanner.presentation.scan.ScanFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Scope
import javax.inject.Singleton

@Component(modules = [ScanModule::class, RepositoryModule::class])
@Singleton
interface ScanComponent {

    fun inject(scanFragment: ScanFragment)
    fun inject(historyFragment: HistoryFragment)

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun context(context: Context) : Builder

        fun build(): ScanComponent
    }

}

