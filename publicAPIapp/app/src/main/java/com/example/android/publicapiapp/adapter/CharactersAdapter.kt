package com.example.android.publicapiapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android.publicapiapp.databinding.ListItemCharacterBinding
import com.example.android.publicapiapp.model.CharacterObject

class CharactersAdapter : ListAdapter<CharacterObject, CharactersAdapter.ViewHolder>(CharacterDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position!!))
    }


    class ViewHolder private constructor(val binding: ListItemCharacterBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: CharacterObject){
            binding.txtName.text = item.name
            binding.txtNickname.text = item.nickname
            binding.txtPortrayed.text = item.portrayed
            binding.executePendingBindings()
        }

        companion object{
            fun from(parent: ViewGroup) : ViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemCharacterBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class CharacterDiffCallBack : DiffUtil.ItemCallback<CharacterObject>(){
    override fun areItemsTheSame(
        oldItem: CharacterObject,
        newItem: CharacterObject
    ): Boolean {
        return  oldItem.char_id == newItem.char_id
    }

    override fun areContentsTheSame(
        oldItem: CharacterObject,
        newItem: CharacterObject
    ): Boolean {
        return oldItem == newItem
    }

}
