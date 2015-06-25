package com.adv.viewpageradv;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class MainActivity extends ActionBarActivity {

    private ViewPager mViewPager;
    private AdverPagerAdapter mAdapter;
    private final int DEFAULT_COUNT = 4;
    private final int RETURN_COUNT = 20;
    private int[] imageRecource = {R.mipmap.image1, R.mipmap.image2, R.mipmap.image3, R.mipmap.image4};
    private int screenWidth, screeHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        screenWidth = metrics.widthPixels;
        screeHeight = metrics.heightPixels;
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(screenWidth, screeHeight / 6);
        mViewPager.setLayoutParams(params);
        mAdapter = new AdverPagerAdapter(this);
        mViewPager.setAdapter(mAdapter);
    }

    class AdverPagerAdapter extends PagerAdapter {

        private Context mContext;

        public AdverPagerAdapter(Context context) {
            mContext = context;
        }

        @Override
        public int getCount() {
            return RETURN_COUNT;
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view == o;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            position %= DEFAULT_COUNT;
            L.e("position=" + position, true);
            View view = LayoutInflater.from(mContext).inflate(R.layout.image_item, container, false);
            ImageView imageview = (ImageView) view.findViewById(R.id.image_item);
            imageview.setImageResource(imageRecource[position]);
            container.addView(view);
            return view;
        }

        @Override
        public void finishUpdate(ViewGroup container) {
            int position = mViewPager.getCurrentItem();
            L.d("finishUpdate before,position=" + position, true);
            if(position==RETURN_COUNT-1){
                position=DEFAULT_COUNT-1;
                mViewPager.setCurrentItem(position,false);
            }
        }
    }
}
