package com.social.com.view.ui.socials.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.social.com.domain.model.Post
import kotlinx.android.synthetic.main.cell_post.view.*

import com.social.com.view.ui.R

class PostsAdapter(private val context: Context) : RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    var data: List<Post>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.cell_post, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = data?.get(position)
        holder.itemView.textView1.text = "post " + post?.title
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }
}