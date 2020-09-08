package com.example.android.publicapiapp.repo

import com.example.android.publicapiapp.api.ApiInterface

class BreakingBadRepository(private val apiInterface: ApiInterface){
    suspend fun getCharacters() = apiInterface.getCharacters()
}