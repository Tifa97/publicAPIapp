package com.example.android.publicapiapp.viewModel

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

//Korisno imati BaseViewModel kad imas vise ViewModela koji koriste iste stvari

object ViewModelDispatcher{
    @VisibleForTesting
    var dispatcher: CoroutineDispatcher = Dispatchers.IO
}

abstract class BaseViewModel : ViewModel() {

    private val job: Job = Job()
    val scope: CoroutineScope = CoroutineScope((ViewModelDispatcher.dispatcher + job))


    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}