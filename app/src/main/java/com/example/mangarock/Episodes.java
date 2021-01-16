package com.example.mangarock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.mangarock.Adapters.EpisodeAdapter;
import com.example.mangarock.Model.Episode;

import java.util.ArrayList;
import java.util.List;

public class Episodes extends AppCompatActivity {
    private List<Episode> episodeList = new ArrayList<>();
    private RecyclerView recyclerView;
    private EpisodeAdapter episodeAdapter;
    Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episodes);
        recyclerView = (RecyclerView) findViewById(R.id.rv1);

        episodeAdapter = new EpisodeAdapter(episodeList,mContext);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(episodeAdapter);

        prepareEpisode();
    }

    private void prepareEpisode() {
        Episode episode = new Episode("Episode 1", "01-07-2018", "","2088");
        episodeList.add(episode);
       episode = new Episode("Episode 2", "08-07-2018", "","2033");
       episodeList.add(episode);


        episode = new Episode("Episode 3", "15-07-2018", "","2055");
        episodeList.add(episode);

        episode = new Episode("Episode 4", "22-07-2018", "","3010");
        episodeList.add(episode);

        episode = new Episode("Episode 5", "29-07-2018", "","3001");
        episodeList.add(episode);

        episode = new Episode("Episode 6", "29-07-2018", "","3821");
        episodeList.add(episode);

        episode = new Episode("Episode 7", "06-08-2018", "","3980");
        episodeList.add(episode);

        episode = new Episode("Episode 8", "13-08-2018", "","3409");
        episodeList.add(episode);

        episode = new Episode("Episode 9", "20-08-2018", "","3240");
        episodeList.add(episode);

        episode = new Episode("Episode 10", "27-08-2018", "","4010");
        episodeList.add(episode);

        episode = new Episode("Episode 11", "05-09-2018", "","3091");
        episodeList.add(episode);

        episode = new Episode("Episode 12", "12-09-2018", "","3201");
        episodeList.add(episode);

        episode = new Episode("Episode 13", "19-09-2018", "","4358");
        episodeList.add(episode);

        episode = new Episode("Episode 14", "26-09-2018", "","4320");
        episodeList.add(episode);

        episode = new Episode("Episode 15", "03-09-2018", "","4222");
        episodeList.add(episode);
        episode = new Episode("Episode 16", "10-09-2018", "","4309");
        episodeList.add(episode);

        episode = new Episode("Episode 17", "17-09-2018", "","4102");
        episodeList.add(episode);

        episode = new Episode("Episode 18", "24-09-2018", "","4321");
        episodeList.add(episode);

        episode = new Episode("Episode 19", "01-10-2018", "","4905");
        episodeList.add(episode);

        episode = new Episode("Episode 20", "08-10-2018", "","4843");
        episodeList.add(episode);



        episodeAdapter.notifyDataSetChanged();
    }
}