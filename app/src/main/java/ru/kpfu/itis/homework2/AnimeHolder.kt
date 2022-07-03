package ru.kpfu.itis.homework2

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.kpfu.itis.homework2.databinding.ItemAnimeBinding

class AnimeHolder(
    private val binding: ItemAnimeBinding,
    private val glide: RequestManager,
    private val onItemClick: (Anime) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(anime: Anime) {
        with(binding) {
            tvName.text = anime.name
            root.setOnClickListener {
                onItemClick(anime)
            }

            glide
                .load(anime.pictureUrl)
                .placeholder(R.drawable.attack)
                .error(R.drawable.totoro)
                .into(ivCover)
        }
    }

}