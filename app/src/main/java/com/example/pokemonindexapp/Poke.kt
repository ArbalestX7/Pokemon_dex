package com.example.pokemonindexapp
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Poke(
    val name: String,
    val desc: String,
    val photo: String,
    val height_weight: String,
    val type: String,
    val weak: String,
    val evo: Int
) : Parcelable
