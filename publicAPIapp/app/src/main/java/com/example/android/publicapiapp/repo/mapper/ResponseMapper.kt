package com.example.android.publicapiapp.repo.mapper

import com.example.android.publicapiapp.model.CharacterObject
import com.example.android.publicapiapp.model.apiResponse.BreakingBadResponse

class ResponseMapper {
    fun getCharacters(characters: BreakingBadResponse): MutableList<CharacterObject> {
        val list = mutableListOf<CharacterObject>()
        characters.forEach {
            it.let {
                list.add(
                    CharacterObject(
                        appearance = it.appearance,
                        better_call_saul_appearance = it.better_call_saul_appearance,
                        birthday = it.birthday,
                        category = it.category,
                        char_id = it.char_id,
                        img = it.img,
                        name = it.name,
                        nickname = it.nickname,
                        occupation = it.occupation,
                        portrayed = it.portrayed,
                        status = it.status
                    )
                )
            }
        }
        return list
    }
}