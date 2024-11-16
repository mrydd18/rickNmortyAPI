package com.example.ricknmorty.data

data class CharacterList(
    val results: List<CharacterItem>
)

data class CharacterItem(
    val id: Int,
    val name: String,
    val status: String,
    val image: String
)