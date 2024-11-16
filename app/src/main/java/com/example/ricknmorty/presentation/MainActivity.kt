package com.example.ricknmorty.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.ricknmorty.data.RetrofitInstance
import com.example.ricknmorty.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val characterAdapter = CharacterAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initRecycler()
        getCharacters()
    }

    private fun initRecycler() {
        binding.charactersRecyclerView.adapter = characterAdapter
    }

    private fun getCharacters() = lifecycleScope.launch {
        try {
            val charactersResponse = RetrofitInstance.getApi().getCharactersList()
            if (charactersResponse.isSuccessful) {
                val characters = charactersResponse.body()?.results ?: emptyList() // Extract results
                characterAdapter.setCharactersList(characters) // Pass the list to the adapter
            } else {
                Toast.makeText(this@MainActivity, "Error: ${charactersResponse.message()}", Toast.LENGTH_SHORT).show()
            }
        } catch (error: Exception) {
            Toast.makeText(this@MainActivity, "Can't get data from network", Toast.LENGTH_SHORT).show()
        }
    }

}
