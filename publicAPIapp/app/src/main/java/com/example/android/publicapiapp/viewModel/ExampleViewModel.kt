package com.example.android.publicapiapp.viewModel

import android.util.Log
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.publicapiapp.model.apiResponse.BreakingBadCharacterItem
import com.example.android.publicapiapp.model.apiResponse.BreakingBadResponse
import com.example.android.publicapiapp.repo.BreakingBadRepository
import kotlinx.coroutines.*
import retrofit2.Response

//prepisano iz baseViewModela na ALU, je li tu iskljucivo radi lakseg testiranja ili postoji jos razloga?
object ViewModelDispatcher{
    @VisibleForTesting
    var dispatcher: CoroutineDispatcher = Dispatchers.IO
}

class ExampleViewModel(private val breakingBadRepository: BreakingBadRepository) : ViewModel() {

    private val job: Job = Job()
    val scope: CoroutineScope = CoroutineScope((ViewModelDispatcher.dispatcher + job))

    private val _characters = MutableLiveData<ArrayList<BreakingBadCharacterItem>>()
     val characters: LiveData<ArrayList<BreakingBadCharacterItem>>
         get() = _characters

    //Ako radis ispravno, ne treba ti
    var characterList: ArrayList<BreakingBadCharacterItem> = ArrayList()


    fun loadCharacter() {
         scope.launch {
             val response: Response<BreakingBadResponse> = getResponse()
             val isResponseSuccessful = response.isSuccessful
             if (isResponseSuccessful){
                 characterList.add(response.body()!![0])
                 withContext(Dispatchers.Main){
                     _characters.value = characterList

                     //ovo ispod ne radi jer ne smijes imat response tu
                     //_characters.value?.add(response.body()!![0])
                 }
             }
             else{
                 Log.i("Response", "failed")
             }
         }
     }

     private suspend fun getResponse(): Response<BreakingBadResponse> {
         //Je li ovo ispravno?
         return withContext(ViewModelDispatcher.dispatcher){
             breakingBadRepository.getCharacter().execute()
         }
     }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

}