package com.example.android.publicapiapp.repo

class BreakingBadRepository(private val apiInterface: ApiInterface){
    suspend fun getCharacters() = apiInterface.getCharacters()
}