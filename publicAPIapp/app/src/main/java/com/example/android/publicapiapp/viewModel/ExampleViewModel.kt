package com.example.android.publicapiapp.viewModel

import android.util.Log
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.publicapiapp.model.CharacterObject
import com.example.android.publicapiapp.model.apiResponse.BreakingBadResponse
import com.example.android.publicapiapp.repo.BreakingBadRepository
import kotlinx.coroutines.*
import retrofit2.Response

class ExampleViewModel(private val breakingBadRepository: BreakingBadRepository) : BaseViewModel() {

    private val _characters = MutableLiveData<List<CharacterObject>>()
     val characters: LiveData<List<CharacterObject>>
         get() = _characters


    fun loadCharacter() {
         scope.launch {
             withContext(Dispatchers.Main){
                 _characters.value = breakingBadRepository.getCharacters()
             }
         }
     }
}