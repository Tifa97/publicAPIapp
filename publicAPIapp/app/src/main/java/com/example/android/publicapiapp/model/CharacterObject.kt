package com.example.android.publicapiapp.model

//Objekt u koji pretvaramo response

data class CharacterObject(
    val appearance: List<Any>,
    val better_call_saul_appearance: Any?,
    val birthday: Any?,
    val category: String?,
    val char_id: Int?,
    val img: String?,
    val name: String?,
    val nickname: String?,
    val occupation: List<String?>?,
    val portrayed: String?,
    val status: String?
)