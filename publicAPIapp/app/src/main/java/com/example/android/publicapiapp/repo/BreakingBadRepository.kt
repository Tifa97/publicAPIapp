package com.example.android.publicapiapp.repo

import com.example.android.publicapiapp.api.APIClient
import com.example.android.publicapiapp.api.ApiInterface


//Repository ne smije nista primati
class BreakingBadRepository(){
    val services by lazy { APIClient.authServices() }

    fun getCharacter() = services.getCharacter()
}