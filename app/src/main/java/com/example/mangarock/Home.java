package com.example.mangarock;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.mangarock.Activities.AnimeActivity;
import com.example.mangarock.Adapters.ViewPagerAdapter;

import java.util.ArrayList;


public class Home extends Fragment {
    private static final String TAG = "My tag";
    @Nullable
    RecyclerView recyclerView;
    ViewPager viewPager;
    ViewFlipper vflipper;
    ViewPagerAdapter viewPagerAdapter;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;

    private Button button;
    private Context mContext;
    ImageView img1;
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    public Home() {
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        img1=view.findViewById(R.id.image1);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, Episodes.class));
                Toast.makeText(mContext, "You have clicked P1", Toast.LENGTH_LONG).show();
            }
        });
        return view;

    }

}

//        int[] images ={R.drawable.kaneki,R.drawable.image,R.drawable.manga};
//        vflipper=view.findViewById(R.id.v_flipper);
//
//        button=view.findViewById(R.id.btnsign);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                BottomNavigation.fragmentManager.beginTransaction().replace(R.id.fragment_container, new Genre(),null).commit();
//            }
//        });
       

//
//        viewPager = view.findViewById(R.id.viewpager);
//        viewPagerAdapter = new ViewPagerAdapter(mContext);
//        viewPager.setAdapter(viewPagerAdapter);
////for(int image:images){flipperImages(image);}
//        sliderDotspanel = view.findViewById(R.id.SliderDots);
//        dotscount = viewPagerAdapter.getCount();
//        dots = new ImageView[dotscount];
//        for(int i = 0; i < dotscount; i++){
//
//            dots[i] = new ImageView(mContext);
//            dots[i].setImageDrawable(ContextCompat.getDrawable(mContext.getApplicationContext(), R.drawable.non_active_dot));
//
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//
//            params.setMargins(8, 0, 8, 0);
//
//            sliderDotspanel.addView(dots[i], params);
//
//        }
//        dots[0].setImageDrawable(ContextCompat.getDrawable(mContext.getApplicationContext(), R.drawable.active_dot));
//
//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//                for(int i = 0; i< dotscount; i++){
//                    dots[i].setImageDrawable(ContextCompat.getDrawable(mContext.getApplicationContext(), R.drawable.non_active_dot));
//                }
//
//                dots[position].setImageDrawable(ContextCompat.getDrawable(mContext.getApplicationContext(), R.drawable.active_dot));
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 4000);
//
//    }
//
//    //    public void flipperImages(int image)
////    {
////        ImageView imageview=new ImageView(mContext);
////        imageview.setBackgroundResource(image);
////
////        vflipper.addView(imageview);
////        vflipper.setFlipInterval(4000);
////        vflipper.setAutoStart(true);
////
////        vflipper.setInAnimation(mContext,android.R.anim.slide_out_right);
////        vflipper.setOutAnimation(mContext,android.R.anim.slide_out_right);
////
////    }
//    public class MyTimerTask extends TimerTask {
//
//        @Override
//        public void run() {
//
//            Home.this.getActivity().runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    if(viewPager.getCurrentItem() == 0){
//                        viewPager.setCurrentItem(1);
//                    } else if(viewPager.getCurrentItem() == 1){
//                        viewPager.setCurrentItem(2);
//                    } else {
//                        viewPager.setCurrentItem(0);
//                    }
//                }
//            });
//
//        }
//
//    }






