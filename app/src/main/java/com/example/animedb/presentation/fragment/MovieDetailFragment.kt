package com.example.animedb.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.animedb.R
import com.example.animedb.data.model.teste
import com.example.animedb.databinding.FragmentMovieDetailBinding
import com.example.animedb.presentation.fragment.HomeFragment.Companion.ARG
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment : Fragment() {

    private lateinit var binding: FragmentMovieDetailBinding
    private lateinit var movie: teste
    private var genres: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        movie = arguments?.getSerializable(ARG) as teste
        setup()
        return binding.root
    }

    private fun setup() {

        setupView()
    }

    private fun setupView() = binding.apply {
        tvTitle.text = movie.name
        tvMin.text = getString(R.string.Time).plus(" ").plus(movie.duration.toString())
        tvImdbRank.text = getString(R.string.Rank).plus(" ").plus(movie.rank.toString())

        var count = 0

        movie.genres.forEach {
            count += 1
            genres = if (count < movie.genres.size) {
                genres.plus(it).plus(", ")
            } else {
                genres.plus(it).plus(" ")
            }
        }.toString()

        tvGenres.text = genres

        if (movie.imageWidth == 8699) {
            Picasso.get().load(movie.imageUrl).resize(800, 0).into(binding.ivPoster)
        } else {
            Picasso.get().load(movie.imageUrl).into(binding.ivPoster)
        }

        tvPlot.text = movie.plot

        ivBack.setOnClickListener {
            findNavController().navigate(R.id.action_animeDetailFragment_to_homeFragment)
        }
    }


}