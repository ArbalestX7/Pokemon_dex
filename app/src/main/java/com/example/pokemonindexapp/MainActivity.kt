package com.example.pokemonindexapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonindexapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var rvPokemon: RecyclerView
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Poke>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvPokemon = findViewById(R.id.rv_pokemon)
        rvPokemon.setHasFixedSize(true)

        list.addAll(getListPokemons())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvPokemon.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvPokemon.layoutManager = GridLayoutManager(this, 2)
            }
            R.id.about_page -> {
                val moveIntent = Intent(this@MainActivity,AboutActivity::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListPokemons(): ArrayList<Poke>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDesc = resources.getStringArray(R.array.data_desc)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataHeightWeight = resources.getStringArray(R.array.data_HeightWeight)
        val dataType = resources.getStringArray(R.array.data_type)
        val dataWeak =  resources.getStringArray(R.array.data_weak)
        val dataEvo = resources.getIntArray(R.array.data_evo)
        val listPoke = ArrayList<Poke>()
        for (i in dataName.indices) {
            val poke = Poke(dataName[i], dataDesc[i], dataPhoto[i], dataHeightWeight[i], dataType[i], dataWeak[i], dataEvo[i])
            listPoke.add(poke)
        }
        return listPoke
    }

    private fun showRecyclerList(){
        rvPokemon.layoutManager = LinearLayoutManager(this)
        val listPokemonAdapter = ListPokemonAdapter(list)
        rvPokemon.adapter = listPokemonAdapter

    }
}