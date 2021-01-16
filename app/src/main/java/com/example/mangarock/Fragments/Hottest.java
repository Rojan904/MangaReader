package com.example.mangarock.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
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


public class Hottest extends Fragment {
    private RecyclerView myrv;
    private List<Anime> lstAnime = new ArrayList<>();
    Context mContext;
    RequestQueue requestQueue;
    JsonArrayRequest ArrayRequest;
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.genre_hottest, container, false);

        myrv = view.findViewById(R.id.rv);
        try {
            JSONObject object = new JSONObject(readjson());
            JSONArray array = object.getJSONArray("anime");

            for (int i = 0; i <10; i++) {

                JSONObject jsonObject = array.getJSONObject(i);
                String name = jsonObject.getString("name");
                String rating = jsonObject.getString("Rating");
                String description = jsonObject.getString("description");
                String img= jsonObject.getString("img");
//                String studio= jsonObject.getString("studio");
                String category= jsonObject.getString("categorie");
                String author= jsonObject.getString("author");
                String status=jsonObject.getString("status");


                Anime anime = new Anime();
                anime.setName(name);
                anime.setRating(rating);
                anime.setImage_url(img);
//                anime.setStudio(studio);
                anime.setDescription(description);
                anime.setCategorie(category);
                anime.setAuthor(author);
                anime.setStatus(status);


////
                //Toast.makeText(MainActivity.this,anime.toString(),Toast.LENGTH_SHORT).show();
                lstAnime.add(anime);

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
//    private  final String URL_JSON = "https://github.com/asarode/anime-list/blob/master/data/data.json";
//    private JsonArrayRequest ArrayRequest ;
//    private RequestQueue requestQueue ;
//    private List<Anime> lstAnime = new ArrayList<>();
//    private RecyclerView myrv ;
//    Context mContext;
//    public Hottest(){
//    }
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        mContext = context;
//    }
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.genre_hottest, container, false);
//
//        myrv = view.findViewById(R.id.rv);
//        jsoncall();
//        return view;
//    }
//    public void jsoncall() {
//
//
//        ArrayRequest = new JsonArrayRequest(Request.Method.GET,URL_JSON,null, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//
//                JSONObject jsonObject = null;
//
//
//                for (int i = 0 ; i<response.length();i++) {
//
//
//
//                    try {
//
//                        jsonObject = response.getJSONObject(i);
//                        Anime anime = new Anime();
//
//                        anime.setName(jsonObject.getString("name"));
//                        anime.setRating(jsonObject.getString("Rating"));
//                        anime.setDescription(jsonObject.getString("description"));
//                        anime.setImage_url(jsonObject.getString("img"));
//                        anime.setStudio(jsonObject.getString("studio"));
//                        anime.setCategorie(jsonObject.getString("categorie"));
//                        //Toast.makeText(MainActivity.this,anime.toString(),Toast.LENGTH_SHORT).show();
//                        lstAnime.add(anime);
//                    }
//                    catch ( JSONException e) {
//                        e.printStackTrace();
//                    }
//            }
//
//
//                Toast.makeText(mContext,"Size of List "+ String.valueOf(lstAnime.size()),Toast.LENGTH_SHORT).show();
//                Toast.makeText(mContext,lstAnime.get(1).toString(),Toast.LENGTH_SHORT).show();
//
//            setRecyclerViewAdapter(lstAnime);
//        }
//    }, new Response.ErrorListener() {
//
//        @Override
//        public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//
//
//        requestQueue = Volley.newRequestQueue(mContext);
//        requestQueue.add(ArrayRequest);
//    }
//
//
//
//    public void setRecyclerViewAdapter (List<Anime> lst) {
//
//        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(mContext,lst) ;
//        myrv.setLayoutManager(new LinearLayoutManager(mContext));
//        myrv.setAdapter(myAdapter);
//
//
//
//
//    }
//
//}

