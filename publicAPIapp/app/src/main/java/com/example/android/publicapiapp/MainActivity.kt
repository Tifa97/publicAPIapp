package com.example.android.publicapiapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.android.publicapiapp.adapter.CharactersAdapter
import com.example.android.publicapiapp.databinding.ActivityMainBinding
import com.example.android.publicapiapp.model.CharacterObject
import com.example.android.publicapiapp.viewModel.ExampleViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: ExampleViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setListener()
        observeCharacters()
    }

    private fun setListener() {
        binding.btnAdd.setOnClickListener {
            viewModel.loadCharacter()
        }
    }

    private fun observeCharacters() {
        // uvijek radi ovako (npr. list ->)
        viewModel.characters.observe(this, Observer { list ->
            setupRecycler(list)
        })
    }

    private fun setupRecycler(it: List<CharacterObject>?) {
        val adapter = CharactersAdapter()
        binding.recycler.adapter = adapter
        adapter.submitList(it)
        val manager = GridLayoutManager(this, 1)
        binding.recycler.layoutManager = manager
    }
}
