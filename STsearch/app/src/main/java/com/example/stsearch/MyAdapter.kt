package com.example.stsearch

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.mycustomlayout.view.*
class MyAdapter(val mContext:Context,
                val videoList:ArrayList<videoItem>) :
                RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
                    class MyViewHolder(itemView:View):
                            RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflator=LayoutInflater.from(parent.context)
        val videoItem=layoutInflator.inflate(R.layout.mycustomlayout,parent,false)
        return MyViewHolder(videoItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        var singleVideoItem=videoList.get(position)
        holder.itemView.video_title.text =singleVideoItem.videoTitle
        holder.itemView.video_level.text ="Level:"+singleVideoItem.videoLevel
        Picasso.with(mContext)
                .load("https://i.ytimg.com/vi/"
                +singleVideoItem.videoId+"/sddefault.jpg"
                )
                .resize(640,360)
                .centerCrop()
                .into(holder.itemView.video_thumbnail)
        holder.itemView.LL.setOnClickListener{

            var playVideoIntent = Intent(mContext, ThirdActivity::class.java).apply {
                putExtra("VIDEO_ID",""+singleVideoItem.videoId)
                putExtra("VIDEO_TITLE",""+singleVideoItem.videoTitle)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }

            mContext.startActivity(playVideoIntent)
                 }
    }


    override fun getItemCount(): Int {
        return videoList.size
    }
                }