package com.example.skymobiletest.homeScreen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.skymobiletest.R
import java.util.*

class MovieListAdapter(
    context: Context,
    private val listOfVMMovies: ArrayList<MovieViewModel>
) : BaseAdapter() {

    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return listOfVMMovies.size
    }

    override fun getItem(position: Int): Any {
        return listOfVMMovies[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView

        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_movie, null)
            view?.let {
                val viewHolder = ViewHolder()
                viewHolder.titleTextView = view.findViewById(R.id.textViewTitle) as TextView
                viewHolder.thumbnailImageView = view.findViewById(R.id.imageViewThumbnail) as ImageView
                view.tag = viewHolder
            }
        }
        val viewHolder = view?.tag as ViewHolder
        viewHolder.titleTextView?.text = listOfVMMovies[position].title
        Glide.with(view)
            .load(listOfVMMovies.get(position).cover_url)
            .placeholder(R.drawable.ic_baseline_photo_24)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(viewHolder.thumbnailImageView!!)
        return view
    }
}

class ViewHolder {
    var titleTextView: TextView? = null
    var thumbnailImageView: ImageView? = null
}