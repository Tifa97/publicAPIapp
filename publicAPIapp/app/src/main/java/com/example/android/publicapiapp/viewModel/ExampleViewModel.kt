package com.example.android.publicapiapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.publicapiapp.model.CharacterObject
import com.example.android.publicapiapp.repo.BreakingBadRepository
import kotlinx.coroutines.*

class ExampleViewModel(private val breakingBadRepository: BreakingBadRepository) : BaseViewModel() {

    private val _characters = MutableLiveData<List<CharacterObject>>()
     val characters: LiveData<List<CharacterObject>>
         get() = _characters

    fun loadCharacter() {
         scope.launch {
             withContext(Dispatchers.Main) {
                 _characters.value = breakingBadRepository.getCharacters()
             }
         }
     }
}
