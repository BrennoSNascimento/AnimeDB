package com.example.animedb.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.animedb.R
import com.example.animedb.data.model.MovieDetail
import com.example.animedb.data.model.teste
import com.example.animedb.databinding.FragmentHomeBinding
import com.example.animedb.presentation.adapter.AdapterHome
import com.example.animedb.presentation.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.collections.ArrayList

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var moviesAdapter: AdapterHome
    private lateinit var binding: FragmentHomeBinding
    private lateinit var layoutManager: GridLayoutManager

    private var movieIdList: ArrayList<String> = ArrayList()
    private var movieDetailList: ArrayList<MovieDetail> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        setup()
        return binding.root
    }

    private fun setup() {
        viewModel.executeGetMovies()
        setupAdapter()
        setupObserver()
    }

    private fun setupAdapter() {

        moviesAdapter = AdapterHome()
        layoutManager = GridLayoutManager(binding.rvMovies.context, 2)
        binding.rvMovies.adapter = moviesAdapter
        binding.rvMovies.layoutManager = layoutManager

        binding.rvMovies.apply {
            moviesAdapter.onItemClickListener = {
                val args = Bundle().apply {
                    putSerializable(ARG,
                        teste(it.title.title,
                            it.genres,
                            it.title.runningTimeInMinutes,
                            it.ratings.rating,
                            it.title.image.width,
                            it.title.image.url,
                            it.plotOutline.text))
                }
                findNavController().navigate(R.id.action_homeFragment_to_animeDetailFragment, args)
            }
        }
    }

    private fun setupObserver() {
        viewModel.movies.observe(viewLifecycleOwner, Observer {
            it.let {
                it.forEach {
                    newTitleList(it)
                }
            }
        })

        viewModel.isLoading.observe(viewLifecycleOwner, Observer {
            if (it) {
                binding.progress.visibility = View.VISIBLE
            } else {
                binding.progress.visibility = View.GONE
            }

        })

        viewModel.isFinish.observe(viewLifecycleOwner, Observer {
            it.let { binding.progress.visibility = View.VISIBLE }
        })

        viewModel.movieDetail.observe(viewLifecycleOwner, Observer {
            it.let {
                binding.progress.visibility = View.INVISIBLE
                binding.tvWait.visibility = View.INVISIBLE
                binding.rvMovies.visibility = View.VISIBLE
                movieDetailList.addAll(viewModel.movieDetailList)
                moviesAdapter.replaceItems(viewModel.movieDetailList)
            }
        })

    }


    private fun newTitleList(id: String) {
        val newId = id.replace("/title/", "").replace("/", "")
        movieIdList.add(newId)

        if (movieIdList.size == 100) {

            for (k in 0..10) {
                viewModel.t(movieIdList[k])
            }

        }
    }


    companion object {
        const val ARG = "Arg"
    }
}