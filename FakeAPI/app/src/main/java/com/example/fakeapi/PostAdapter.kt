package com.example.fakeapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.list_item.view.*

class PostAdapter(
    private val posts: List<Post>,
    private val mListenr: OnItemClickListener
) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {



    interface OnItemClickListener {
        fun onAddClick(id:Int?)
    }

    class PostViewHolder(var root: View, private val listener: OnItemClickListener?) :
        RecyclerView.ViewHolder(root) {
        fun bind(post: Post) {
            with(root) {
                title.text = post.title
                body.text = post.body
                deleteButton.setOnClickListener {
                    listener?.onAddClick(post.id)
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : PostViewHolder {

        return PostViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.list_item, parent, false),
            mListenr
        )
    }


    override fun onBindViewHolder(
        holder: PostViewHolder,
        position: Int
    ) = holder.bind(posts[position])


    override fun getItemCount(): Int = posts.size
}