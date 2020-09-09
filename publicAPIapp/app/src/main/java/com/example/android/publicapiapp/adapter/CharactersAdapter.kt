package com.example.android.publicapiapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android.publicapiapp.databinding.ListItemCharacterBinding
import com.example.android.publicapiapp.model.apiResponse.BreakingBadCharacterItem

class CharactersAdapter : ListAdapter<BreakingBadCharacterItem, CharactersAdapter.ViewHolder>(CharacterDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position!!))
    }


    class ViewHolder private constructor(val binding: ListItemCharacterBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: BreakingBadCharacterItem){
            binding.character = item
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

class CharacterDiffCallBack : DiffUtil.ItemCallback<BreakingBadCharacterItem>(){
    override fun areItemsTheSame(
        oldItem: BreakingBadCharacterItem,
        newItem: BreakingBadCharacterItem
    ): Boolean {
        return  oldItem.char_id == newItem.char_id
    }

    override fun areContentsTheSame(
        oldItem: BreakingBadCharacterItem,
        newItem: BreakingBadCharacterItem
    ): Boolean {
        return oldItem == newItem
    }

}
