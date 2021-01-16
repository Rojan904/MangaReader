package com.example.mangarock.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.ImageLoader;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mangarock.Activities.AnimeActivity;
import com.example.mangarock.Activities.MainActivity;
import com.example.mangarock.Episodes;
import com.example.mangarock.Model.Episode;
import com.example.mangarock.R;

import java.util.List;

public class EpisodeAdapter extends RecyclerView.Adapter<EpisodeAdapter.MyViewHolder> {

    @NonNull
    private Context mContext;
    private List<Episode> episodeList;
    RequestOptions options;
      View.OnClickListener mClickListener;
    public EpisodeAdapter(List<Episode>episodeList,Context mContext){
        this.episodeList=episodeList;
        this.mContext=mContext;
        options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.loading)
                .error(R.drawable.loading);
    }
    public void setClickListener(View.OnClickListener callback) {
       mClickListener = callback;
    }


    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_listitem, parent, false);

        MyViewHolder viewHolder=new MyViewHolder(itemView);
        
        viewHolder.episodeview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mClickListener.onClick(itemView);



            }
        });

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Episode episodes=episodeList.get(position);
        holder.episode.setText(episodes.getEpisode());
        holder.date.setText(episodes.getDate());

        holder.likes.setText(episodes.getLikes());
    }

    @Override
    public int getItemCount() {
        return episodeList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView episode,date,likes;
        public ImageView img;
        RelativeLayout episodeview;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            episodeview=itemView.findViewById(R.id.viewepisode);
            episode = itemView.findViewById(R.id.episode);
            date=itemView.findViewById(R.id.date);
            img=itemView.findViewById(R.id.likeimg);
            likes=itemView.findViewById(R.id.likes);

        }
    }
}
