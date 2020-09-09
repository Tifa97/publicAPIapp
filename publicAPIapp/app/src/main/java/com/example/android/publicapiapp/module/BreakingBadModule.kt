package com.example.android.publicapiapp.module

import com.example.android.publicapiapp.api.APIClient
import com.example.android.publicapiapp.api.ApiInterface
import com.example.android.publicapiapp.repo.BreakingBadRepository
import com.example.android.publicapiapp.viewModel.ExampleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val BreakingBadModule = module {
    single { BreakingBadRepository() }
    viewModel { ExampleViewModel(get()) }
}