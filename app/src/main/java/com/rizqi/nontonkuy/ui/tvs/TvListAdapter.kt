package com.rizqi.nontonkuy.ui.tvs

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rizqi.nontonkuy.R
import com.rizqi.nontonkuy.data.model.Tv
import kotlinx.android.synthetic.main.items_tv.view.*

class TvListAdapter : RecyclerView.Adapter<TvListAdapter.TvViewHolder>() {

    private var listTv = ArrayList<Tv>()

    fun setList(tvs: ArrayList<Tv>?) {
        if (tvs == null) return
        listTv.clear()
        listTv.addAll(tvs)
        notifyDataSetChanged()
    }

    class TvViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(tv: Tv) {
            with(itemView) {
                tv_show_name.text = tv.name
                tv_first_air_date.text = tv.first_air_date
                tv_overview.text = tv.overview
                tv_vote_average.text = tv.vote_average.toString()
                tv_vote_count.text = " from ${tv.vote_count}"

                Glide.with(context).load("https://image.tmdb.org/t/p/w500${tv.poster_path}")
                    .into(tv_poster)

                setOnClickListener {
                    val intent = Intent(context, TvDetailActivity::class.java)
                    intent.putExtra(TvDetailActivity.EXTRA_TV, tv)
                    context.startActivity(intent)
                }
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_tv, parent, false)
        return TvViewHolder(view)
    }

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        val movie = listTv[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listTv.size
}