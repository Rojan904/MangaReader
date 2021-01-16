package com.example.mangarock.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mangarock.Adapters.RecyclerViewAdapter;
import com.example.mangarock.Model.Anime;
import com.example.mangarock.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Completed extends Fragment {
    private RecyclerView myrv;
    private List<Anime> lstAnime = new ArrayList<>();
    Context mContext;

    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.genre_completed,null);
        myrv = view.findViewById(R.id.rv);

        try {
            JSONObject object = new JSONObject(readjson());
            JSONArray array2 = object.getJSONArray("completed");
            for (int i = 0; i < array2.length(); i++) {
                JSONObject jsonObject2 = array2.getJSONObject(i);
                String name2 = jsonObject2.getString("name");
                String rating2 = jsonObject2.getString("Rating");
                String description2 = jsonObject2.getString("description");
                String img2= jsonObject2.getString("img");
//                String studio= jsonObject.getString("studio");
                String category2= jsonObject2.getString("categorie");
                String author2= jsonObject2.getString("author");
                String status2=jsonObject2.getString("status");

                Anime myanime= new Anime();
                myanime.setName(name2);
                myanime.setRating(rating2);
                myanime.setImage_url(img2);
                myanime.setDescription(description2);
                myanime.setCategorie(category2);
                myanime.setAuthor(author2);
                myanime.setStatus(status2);
                lstAnime.add(myanime);

            }
//            Toast.makeText(mContext, "Size of List " + String.valueOf(lstAnime.size()), Toast.LENGTH_SHORT).show();
//            Toast.makeText(mContext, lstAnime.get(1).toString(), Toast.LENGTH_SHORT).show();
//
            setRecyclerViewAdapter(lstAnime);
        } catch (JSONException e) {
            e.printStackTrace();
        }
       return view;
    }
    private String readjson() {
        String json = null;
        try {
            // Opening data.json file
            InputStream inputStream = getActivity().getAssets().open("anime.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            // read values in the byte array
            inputStream.read(buffer);
            inputStream.close();
            // convert byte to string
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;

    }

    public void setRecyclerViewAdapter(List<Anime> lst) {

        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(mContext, lst);
        myrv.setLayoutManager(new LinearLayoutManager(mContext));

        myrv.setAdapter(myAdapter);
    }
}
