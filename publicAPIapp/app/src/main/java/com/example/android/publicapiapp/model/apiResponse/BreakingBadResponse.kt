package com.example.android.publicapiapp.model.apiResponse

import com.google.gson.annotations.SerializedName

//Response dobiven preko Json to Kotlin class plugina
//Dodaju se anotacije i spremno je

class BreakingBadResponse : ArrayList<BreakingBadResponseItem>()

data class BreakingBadResponseItem(
    @SerializedName("appearance")
    val appearance: List<Any>,
    @SerializedName("better_call_saul_appearance")
    val better_call_saul_appearance: List<Int>,
    @SerializedName("birthday")
    val birthday: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("char_id")
    val char_id: Int,
    @SerializedName("img")
    val img: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("nickname")
    val nickname: String,
    @SerializedName("occupation")
    val occupation: List<String>,
    @SerializedName("portrayed")
    val portrayed: String,
    @SerializedName("status")
    val status: String
)

