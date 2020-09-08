package com.example.android.publicapiapp.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.android.publicapiapp.model.BreakingBadCharacters
import com.example.android.publicapiapp.model.BreakingBadCharacterItem
import org.w3c.dom.Text

@BindingAdapter("nameString")
fun TextView.setName(character: BreakingBadCharacterItem){
    character?.let {
        text = character.name
    }
}
