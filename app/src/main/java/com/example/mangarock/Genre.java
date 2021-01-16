package com.example.mangarock;

import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.mangarock.Adapters.RecyclerViewAdapter;
import com.example.mangarock.Adapters.SectionPagerAdapter;
import com.example.mangarock.Fragments.Action;
import com.example.mangarock.Fragments.Completed;
import com.example.mangarock.Fragments.Hottest;
import com.example.mangarock.Model.Anime;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Genre extends Fragment {

    View myFragment;

    ViewPager viewPager;
    TabLayout tabLayout;
    SearchView mysearchview;
    RecyclerView recyclerView;
    ArrayList<String>lst;
    ArrayAdapter<String>adapter;
    Context mContext;
    RecyclerViewAdapter recyclerViewAdapter;
    public Genre() {
        // Required empty public constructor
    }
    public void onAttach(Context context) {
        super.onAttach(context);
       mContext = context;
    }


    public static Genre getInstance()    {
        return new Genre();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myFragment = inflater.inflate(R.layout.fragment_genre, container, false);

        viewPager = myFragment.findViewById(R.id.viewPager);
        tabLayout = myFragment.findViewById(R.id.tabLayout);
        mysearchview=myFragment.findViewById(R.id.searchview);
        recyclerView=myFragment.findViewById(R.id.rv);
        recyclerViewAdapter=new RecyclerViewAdapter(mContext,lst);

        mysearchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                                        @Override
                                        public boolean onQueryTextSubmit(String query) {
                                            return false;
                                        }

                                        @Override
                                        public boolean onQueryTextChange(String newText) {
                                            recyclerViewAdapter.getFilter().filter(newText);
                                            return false;
                                        }
                                    }
);

        return myFragment;
    }

    public void setRecyclerViewAdapter(List<Anime> lst) {

        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(mContext, lst);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        recyclerView.setAdapter(myAdapter);
    }
    //Call onActivity Create method


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
//    adapter=new ArrayAdapter<RecyclerViewAdapter>(this,android.R.layout.simple_list_item_1,lst);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setUpViewPager(ViewPager viewPager) {
        SectionPagerAdapter adapter = new SectionPagerAdapter(getChildFragmentManager());

        adapter.addFragment(new Hottest(), "Hottest");
        adapter.addFragment(new Action(), "Action");
        adapter.addFragment(new Completed(),"Completed");

        viewPager.setAdapter(adapter);
    }



//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        super.onCreateOptionsMenu(menu, inflater);
//        inflater.inflate(R.menu.search_menu, menu);
//        MenuItem menuItem = menu.findItem(R.id.search);
//
//       SearchView searchView = (SearchView) menuItem.getActionView();
////        menuItem.setActionView(searchView);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
////                RecyclerViewAdapter.getFilter().filter(newText);
//                return false;
//            }
//        });
//
//
//
//    }


}