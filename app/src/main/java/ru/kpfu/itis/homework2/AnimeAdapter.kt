package ru.kpfu.itis.homework2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.kpfu.itis.homework2.databinding.ItemAnimeBinding

class AnimeAdapter(
    private var list: List<Anime>,
    private val glide: RequestManager,
    private val onItemClick: (Anime) -> Unit,
) : RecyclerView.Adapter<AnimeHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AnimeHolder = AnimeHolder(
        binding = ItemAnimeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        glide = glide,
        onItemClick = onItemClick
    )

    override fun onBindViewHolder(
        holder: AnimeHolder,
        position: Int
    ) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

}