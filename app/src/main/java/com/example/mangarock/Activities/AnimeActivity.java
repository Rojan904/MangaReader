package com.example.mangarock.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mangarock.Adapters.SectionPagerAdapter;
import com.example.mangarock.Episodes;
import com.example.mangarock.Fragments.Action;
import com.example.mangarock.Fragments.Completed;
import com.example.mangarock.Fragments.Hottest;
import com.example.mangarock.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;

public class AnimeActivity extends AppCompatActivity {
    ImageView subscribe;
   ImageView download;
   Button viewepisode;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);



        String name  = getIntent().getExtras().getString("name");
        String description = getIntent().getExtras().getString("description");
        String studio= getIntent().getExtras().getString("studio") ;
        String status= getIntent().getExtras().getString("status") ;
        String author= getIntent().getExtras().getString("author") ;
        String category = getIntent().getExtras().getString("category");
        int nb_episode = getIntent().getExtras().getInt("nb_episode") ;
        String rating = getIntent().getExtras().getString("rating") ;
        String image_url = getIntent().getExtras().getString("img") ;

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_name = findViewById(R.id.aa_anime_name);

        TextView tv_author = findViewById(R.id.aa_author);
        TextView tv_status = findViewById(R.id.aa_status);
        TextView tv_categorie = findViewById(R.id.aa_categorie) ;
        TextView tv_description = findViewById(R.id.aa_description);
        TextView tv_rating  = findViewById(R.id.aa_rating) ;
        ImageView img = findViewById(R.id.aa_thumbnail);

        tv_name.setText(name);
        tv_categorie.setText(category);
        tv_description.setText(description);
        tv_rating.setText(rating);

        tv_status.setText(status);
        tv_author.setText(author);

        collapsingToolbarLayout.setTitle(name);


        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading).error(R.drawable.loading);


        // set image using Glide
        Glide.with(this).load(image_url).apply(requestOptions).into(img);


    download=(ImageView) findViewById(R.id.download);
    download.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(AnimeActivity.this,"Downloaded",Toast.LENGTH_SHORT).show();
        }
    });

    viewepisode=(Button) findViewById(R.id.viewepisode);
    viewepisode.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(AnimeActivity.this, Episodes.class));
        }
    });

     subscribe=(ImageView) findViewById(R.id.subscribe);

     subscribe.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             boolean isfav = readState();
             if (isfav) {
                 subscribe.setBackgroundResource(R.drawable.ic_baseline_favorite_24);
                    isfav=false;
                    saveState(isfav);
                 Toast.makeText(AnimeActivity.this,"Added to favorites",Toast.LENGTH_SHORT).show();


             }
             else{
                 subscribe.setBackgroundResource(R.drawable.ic_baseline_favorite_border_24);
                 isfav=true;
                 saveState(isfav);
                 Toast.makeText(AnimeActivity.this,"Removed from favorites",Toast.LENGTH_SHORT).show();

             }
         }
     });
    }

    private void saveState(boolean isFavourite) {
        SharedPreferences aSharedPreferences = this.getSharedPreferences(
                "Favourite", Context.MODE_PRIVATE);
        SharedPreferences.Editor aSharedPreferencesEdit = aSharedPreferences
                .edit();
        aSharedPreferencesEdit.putBoolean("State", isFavourite);
        aSharedPreferencesEdit.commit();
    }

    private boolean readState() {
        SharedPreferences aSharedPreferences = this.getSharedPreferences(
                "Favourite", Context.MODE_PRIVATE);
        return aSharedPreferences.getBoolean("State", true);
    }





}