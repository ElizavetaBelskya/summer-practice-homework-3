package ru.kpfu.itis.homework2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import ru.kpfu.itis.homework2.databinding.FragmentAnimeListBinding

class AnimeListFragment : Fragment(R.layout.fragment_anime_list) {
    private var _binding: FragmentAnimeListBinding? = null
    private val binding get() = _binding!!
    private var adapter: AnimeAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAnimeListBinding.bind(view)
        initAdapter()
    }

    private fun initAdapter() {
        adapter = AnimeAdapter(
            AnimeRepository.animeList,
            Glide.with(this), {
                findNavController().navigate(
                    R.id.action_animeListFragment_to_descriptionFragment,
                    DescriptionFragment.createBundle(it.id),
                )
            }
        )
        binding.rvAnime.adapter = adapter

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}