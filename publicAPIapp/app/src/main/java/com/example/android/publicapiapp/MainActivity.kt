package com.example.android.publicapiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.android.publicapiapp.adapter.CharactersAdapter
import com.example.android.publicapiapp.databinding.ActivityMainBinding
import com.example.android.publicapiapp.model.BreakingBadCharacterItem
import com.example.android.publicapiapp.model.BreakingBadCharacters
import com.example.android.publicapiapp.module.BreakingBadModule
import com.example.android.publicapiapp.viewModel.ExampleViewModel
import org.koin.android.ext.android.bind
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.ext.android.viewModel

import org.koin.core.context.startKoin
import java.util.*

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: ExampleViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observeCharacters()
    }

    private fun observeCharacters() {
        viewModel.characters.observe(this, Observer {
            setupRecycler(it)
        } )
    }

    private fun setupRecycler(it: List<BreakingBadCharacterItem>?) {
        val adapter = CharactersAdapter()
        binding.recycler.adapter = adapter
        adapter.submitList(it)
        val manager = GridLayoutManager(this, 1)
        binding.recycler.layoutManager = manager
    }
}