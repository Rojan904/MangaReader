package com.example.mangarock.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mangarock.Activities.AnimeActivity;
import com.example.mangarock.Model.Anime;
import com.example.mangarock.Model.Episode;
import com.example.mangarock.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>implements Filterable {

    RequestOptions options;
    private Context mContext;
    private List<Anime> mData;
    private List<Anime> mDatafilter;



    public RecyclerViewAdapter(Context mContext, List lst) {


        this.mContext = mContext;
        this.mData = lst;
        this.mDatafilter=mData;
        options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.loading)
                .error(R.drawable.loading);


    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.tab_bar, parent, false);
        // click listener here
        MyViewHolder viewHolder=new MyViewHolder(view);
        viewHolder.view_container1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(mContext, AnimeActivity.class);
                i.putExtra("name",mData.get(viewHolder.getAdapterPosition()).getName());
                i.putExtra("description",mData.get(viewHolder.getAdapterPosition()).getDescription());
//                i.putExtra("studio",mData.get(viewHolder.getAdapterPosition()).getStudio());

//                i.putExtra("nb_episode",mData.get(viewHolder.getAdapterPosition()).getNb_episode());
                i.putExtra("rating",mData.get(viewHolder.getAdapterPosition()).getRating());
                i.putExtra("category",mData.get(viewHolder.getAdapterPosition()).getCategorie());
                i.putExtra("author",mData.get(viewHolder.getAdapterPosition()).getAuthor());
                i.putExtra("status",mData.get(viewHolder.getAdapterPosition()).getStatus());
                i.putExtra("img",mData.get(viewHolder.getAdapterPosition()).getImage_url());

                mContext.startActivity(i);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.name.setText(mDatafilter.get(position).getName());
        holder.rate.setText(mDatafilter.get(position).getRating());
//        holder.studio.setText(mData.get(position).getStudio());
        holder.cat.setText(mDatafilter.get(position).getCategorie());
        holder.author.setText(mDatafilter.get(position).getAuthor());
        holder.status.setText(mDatafilter.get(position).getStatus());
        Glide.with(mContext).load(mData.get(position).getImage_url()).apply(options).into(holder.AnimeThumbnail);

    }

    @Override
    public int getItemCount() {
        return mDatafilter.size();

    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String Key = constraint.toString();
                if (Key.isEmpty()) {
                    mDatafilter = mData;
                } else {
                    List<Anime> lstfiltered = new ArrayList<>();
                    for (Anime row : mData) {
                        if (row.getName().toLowerCase().contains(Key.toLowerCase())) {
                            lstfiltered.add(row);
                        }

                    }
                    mDatafilter = lstfiltered;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mDatafilter;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mDatafilter = (List<Anime>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name, rate, studio, cat,author,status;
        ImageView AnimeThumbnail;
        LinearLayout view_container1;



        public MyViewHolder(View itemView) {
            super(itemView);
            view_container1=itemView.findViewById(R.id.container1);
            name = itemView.findViewById(R.id.rowname);
//            studio = itemView.findViewById(R.id.studio);
            rate = itemView.findViewById(R.id.rating);
            cat = itemView.findViewById(R.id.category);
            author=itemView.findViewById(R.id.author);
            status=itemView.findViewById(R.id.status);
            AnimeThumbnail = itemView.findViewById(R.id.thumbnail);


        }
    }
}
