package com.example.ricknmorty.presentation


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ricknmorty.data.CharacterItem
import com.example.ricknmorty.databinding.ItemCharacterBinding

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private var currentCharacters: List<CharacterItem> = emptyList()

    fun setCharactersList(newCharacterList: List<CharacterItem>) {
        currentCharacters = newCharacterList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = currentCharacters[position]
        holder.bind(character)
    }

    override fun getItemCount(): Int = currentCharacters.size

    class CharacterViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(character: CharacterItem) = with(binding) {
            characterNameTextView.text = character.name
            statusTextView.text = character.status
            Glide.with(characterImageView)
                .load(character.image)
                .into(characterImageView)
        }
    }
}