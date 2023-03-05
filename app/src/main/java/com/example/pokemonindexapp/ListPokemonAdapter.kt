package com.example.pokemonindexapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class ListPokemonAdapter(val listPoke: ArrayList<Poke>): RecyclerView.Adapter<ListPokemonAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDesc: TextView = itemView.findViewById(R.id.tv_item_desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_pokemon, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listPoke.size


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val Poke = listPoke[position]
        Glide.with(holder.itemView.context)
            .load(Poke.photo)
            .into(holder.imgPhoto)
        holder.tvName.text = Poke.name
        holder.tvDesc.text = Poke.desc

        holder.itemView.setOnClickListener{
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra(DetailActivity.EXTRA_POKEMON, Poke)
            holder.itemView.context.startActivity(intentDetail)
        }

    }
}