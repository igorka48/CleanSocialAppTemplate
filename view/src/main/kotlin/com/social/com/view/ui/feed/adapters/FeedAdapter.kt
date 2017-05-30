package com.social.com.view.ui.feed.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.social.com.domain.model.Feed
import kotlinx.android.synthetic.main.cell_feed.view.*

import com.social.com.view.ui.R

class FeedAdapter(private val context: Context) : RecyclerView.Adapter<FeedAdapter.ViewHolder>() {

    var data: List<Feed>? = null
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    init {
        Log.d("DAGGER TEST", "FeedAdapter")
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.cell_feed, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val feed = data?.get(position)
        holder.itemView.textView1.text = "Feed " + feed?.title
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }
}