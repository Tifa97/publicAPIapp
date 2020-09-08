package com.example.android.publicapiapp.viewModel

import android.util.Log
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.android.publicapiapp.api.ApiInterface
import com.example.android.publicapiapp.model.BreakingBadCharacterItem
import com.example.android.publicapiapp.model.BreakingBadCharacters
import com.example.android.publicapiapp.repo.BreakingBadRepository
import kotlinx.coroutines.*
import retrofit2.Response

object ViewModelDispatcher{
    @VisibleForTesting
    var dispatcher: CoroutineDispatcher = Dispatchers.IO
}

class ExampleViewModel(private val breakingBadRepository: BreakingBadRepository) : ViewModel() {

    private val job: Job = Job()
    val scope: CoroutineScope = CoroutineScope((ViewModelDispatcher.dispatcher + job))

   private val _characters = MutableLiveData<List<BreakingBadCharacterItem>>()
    val characters: LiveData<List<BreakingBadCharacterItem>>
        get() = _characters

    init {
        loadCharacters()
    }

    private fun loadCharacters() {
        scope.launch {
            val response: Response<BreakingBadCharacters> = getResponse()
            val isResponseSuccessful = response.isSuccessful
            if (isResponseSuccessful){
                withContext(Dispatchers.Main){
                    _characters.value = response.body()
                }
            }
            else{
                Log.i("Response", "failed")
            }
        }
    }

    private suspend fun getResponse(): Response<BreakingBadCharacters> {
        return withContext(Dispatchers.IO){
            breakingBadRepository.getCharacters().execute()
        }
    }


    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

}