package com.example.android.publicapiapp.module

import com.example.android.publicapiapp.repo.BreakingBadRepository
import com.example.android.publicapiapp.viewModel.ExampleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val BreakingBadModule = module {
    factory { BreakingBadRepository(get()) }
    viewModel { ExampleViewModel(get()) }
}