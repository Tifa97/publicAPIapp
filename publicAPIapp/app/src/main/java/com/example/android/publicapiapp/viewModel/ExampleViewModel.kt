package com.example.android.publicapiapp.viewModel

import android.util.Log
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.android.publicapiapp.model.BreakingBadCharacter
import com.example.android.publicapiapp.repo.BreakingBadRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

object ViewModelDispatcher{
    @VisibleForTesting
    var dispatcher: CoroutineDispatcher = Dispatchers.IO
}

class ExampleViewModel(private val breakingBadRepository: BreakingBadRepository) : ViewModel() {

    private val job: Job = Job()
    val scope: CoroutineScope = CoroutineScope((ViewModelDispatcher.dispatcher + job))

    val characters: LiveData<List<BreakingBadCharacters>> = liveData {
        emit(breakingBadRepository.getCharacters())
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

}