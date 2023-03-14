package com.example.animedbmvvmkotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.animedbmvvmkotlin.databinding.AnimeListItemBinding
import com.example.animedbmvvmkotlin.model.Data

class AnimeListAdapter : RecyclerView.Adapter<AnimeListAdapter.ViewHolder>() {
    private var animeList = ArrayList<Data>()

    fun setAnimeList(movieList: List<Data>) {
        this.animeList = movieList as ArrayList<Data>
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: AnimeListItemBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            AnimeListItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load( animeList[position].image)
            .into(holder.binding.animeImage)
        holder.binding.animeTitle.text = animeList[position].title
    }

    override fun getItemCount(): Int {
        return animeList.size
    }
}

