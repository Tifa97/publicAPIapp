package com.example.android.publicapiapp.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.android.publicapiapp.model.apiResponse.BreakingBadCharacterItem

//Potrebno raditi iz activityja

@BindingAdapter("nameString")
fun TextView.setName(character: BreakingBadCharacterItem){
    character?.let {
        text = character.name
    }
}

@BindingAdapter("nicknameString")
fun TextView.setNickname(character: BreakingBadCharacterItem){
    character?.let {
        text = character.nickname
    }
}

@BindingAdapter("portrayedString")
fun TextView.setPortrayed(character: BreakingBadCharacterItem){
    character?.let {
        text = character.portrayed
    }
}
