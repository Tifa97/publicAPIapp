package com.example.android.publicapiapp.repo

import com.example.android.publicapiapp.api.APIClient
import com.example.android.publicapiapp.model.CharacterObject
import com.example.android.publicapiapp.repo.mapper.ResponseMapper

// Repository ne smije nista primati
class BreakingBadRepository() {
    val services by lazy { APIClient.authServices() }

    suspend fun getCharacters(): List<CharacterObject> {
        val result = services.getCharacters()

        var returnList = mutableListOf<CharacterObject>()
        if (result.isSuccessful) {
            result.body()?.let { list ->
                returnList = ResponseMapper().getCharacters(list)
            }
        }

        return returnList.toList()
    }
}
