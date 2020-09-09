package com.example.android.publicapiapp.model.apiResponse

import com.google.gson.annotations.SerializedName

//Potrebne anotacije

data class BreakingBadResponse(
    @SerializedName("characters")
    val characters: List<Character?>?
){
    data class Character(
        @SerializedName("appearance")
        val appearance: List<Int>?,
        @SerializedName("better_call_saul_appearance")
        val better_call_saul_appearance: Any?,
        @SerializedName("birthday")
        val birthday: Any?,
        @SerializedName("category")
        val category: String?,
        @SerializedName("char_id")
        val char_id: Int?,
        @SerializedName("img")
        val img: String?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("nickname")
        val nickname: String?,
        @SerializedName("occupation")
        val occupation: List<String>?,
        @SerializedName("portrayed")
        val portrayed: String?,
        @SerializedName("status")
        val status: String?
    )
}
