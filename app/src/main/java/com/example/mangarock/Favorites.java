package com.example.mangarock;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.mangarock.Adapters.RecyclerViewAdapter;
import com.example.mangarock.Adapters.SectionPagerAdapter;
import com.example.mangarock.Fragments.Action;
import com.example.mangarock.Fragments.Completed;
import com.example.mangarock.Fragments.Hottest;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class Favorites extends Fragment {
    @Nullable
    View myFragment;

    ViewPager viewPager;
    TabLayout tabLayout;
    SearchView mysearchview;
    RecyclerView recyclerView;
    ArrayList<String> lst;
    ArrayAdapter<String> adapter;
    Context mContext;
    RecyclerViewAdapter recyclerViewAdapter;
    public Favorites() {
        // Required empty public constructor
    }
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        myFragment = inflater.inflate(R.layout.fragment_favorites, container, false);

        viewPager = myFragment.findViewById(R.id.viewPager);
        tabLayout = myFragment.findViewById(R.id.tabLayout);
        recyclerView=myFragment.findViewById(R.id.rv);
        recyclerViewAdapter=new RecyclerViewAdapter(mContext,lst);

        return myFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
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

        adapter.addFragment(new Hottest(), "Downloaded");
        adapter.addFragment(new Action(), "Subscribed");


        viewPager.setAdapter(adapter);
    }
}
