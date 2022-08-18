package com.example.animedb.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.animedb.data.model.MovieDetail

import com.example.animedb.databinding.ItemMoviesBinding
import com.squareup.picasso.Picasso


class AdapterHome() : RecyclerView.Adapter<AdapterHome.Holder>(), AdapterContract {

    lateinit var onItemClickListener: (MovieDetail) -> Unit
    private var animeList : MutableList<MovieDetail> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            ItemMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onItemClickListener
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(animeList[position])
    }

    override fun getItemCount(): Int {
        return animeList.size
    }

    fun updateItemsHome(itemList: List<MovieDetail>) {
        animeList.addAll(itemList)
        notifyDataSetChanged()
    }

    override fun replaceItems(items : List<*>){
        this.animeList = items.filterIsInstance<MovieDetail>() as MutableList<MovieDetail>
        notifyDataSetChanged()
    }

    class Holder(
        private val binding: ItemMoviesBinding,
        private val onItemClickListener: (MovieDetail) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {
        lateinit var content: MovieDetail

        fun bind(content: MovieDetail) {

            if(content.title.image.width == 8699){
                Picasso.get().load(content.title.image.url).resize(800,0).into(binding.ivPoster)
            }else{
                Picasso.get().load(content.title.image.url).into(binding.ivPoster)
            }


            binding.tvTitle.text= content.title.title

            binding.root.setOnClickListener{
                onItemClickListener.invoke(content)
            }

        }

    }

}