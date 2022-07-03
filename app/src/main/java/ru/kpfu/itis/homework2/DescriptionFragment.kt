package ru.kpfu.itis.homework2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import ru.kpfu.itis.homework2.databinding.FragmentDescriptionBinding

class DescriptionFragment : Fragment(R.layout.fragment_description) {
    private var _binding: FragmentDescriptionBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDescriptionBinding.bind(view)
        val id: Int = arguments?.getInt(ARG_TEXT)?.or(0)!!
        var a = AnimeRepository.animeList[id]
        Glide.with(this).load(a.pictureUrl).into(binding.ivDescriptionAnime)
        with(binding) {
            tvDescriptionId.text = "id: $id"
            tvDescriptionName.text = "Name: ${a.name}"
            tvDescriptionDes.text = "${a.description}"
        }
    }

    companion object {
        private const val ARG_TEXT = "anime"

        fun createBundle(id: Int): Bundle {
            val bundle = Bundle()
            bundle.putInt(
                ARG_TEXT,
                id
            )
            return bundle
        }
    }
}