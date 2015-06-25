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


public class MainActivity extends ActionBarActivity {

    private ViewPager mViewPager;
    private AdverPagerAdapter mAdapter;
    private final int DEFAULT_COUNT = 4;
    private final int RETURN_COUNT = 100;
    private int[] imageRecource = {R.mipmap.ic_launcher, R.mipmap.pic, R.mipmap.pic, R.mipmap.pic};
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
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(screenWidth, screeHeight / 4);
        mViewPager.setLayoutParams(params);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
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
            View view = LayoutInflater.from(mContext).inflate(R.layout.image_item, container, false);
            ImageView imageview = (ImageView) view.findViewById(R.id.image_item);
            imageview.setImageResource(imageRecource[position]);
            container.addView(imageview);
            return imageview;
        }

        @Override
        public void finishUpdate(ViewGroup container) {
            super.finishUpdate(container);
        }
    }
}
