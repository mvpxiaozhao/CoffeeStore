package com.example.dell.coffeestore.Fragment;



import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dell.coffeestore.Activity.CoffeeActivity;
import com.example.dell.coffeestore.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class HomeFragment extends Fragment implements View.OnClickListener {
    private ViewPager mViewPaper;
    private List<ImageView> images;
    private List<View> dots;
    private int currentItem;
    //记录上一次点的位置
    private int oldPosition = 0;
    //存放图片的id
    private int[] imageIds = new int[]{
            R.drawable.coffee5,
            R.drawable.coffee6,
            R.drawable.coffee7,
            R.drawable.coffee8,
            R.drawable.coffee6
    };
    //存放图片的标题
    private String[]  titles = new String[]{
            "coffee1",
            "coffee2",
            "coffee3",
            "coffee4",
            "coffee5"
    };
    private TextView title;
    private ViewPagerAdapter adapter;
    private ScheduledExecutorService scheduledExecutorService;



    private ImageView mImageViewHome1;
    private ImageView mImageViewHome2;
    private ImageView mImageViewHome3;
    private ImageView mImageViewHome4;
    private ImageView mImageViewHome5;
    private ImageView mImageViewHome6;

    private ImageView mImageViewHome7;

    private ImageView mImageViewHome8;
    private ImageView mImageViewHomeStore1;
    private ImageView mImageViewHomeStore2;
    private ImageView mImageViewHomeStore3;
    private ImageView mImageViewHomeStore4;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home_fragment, container, false);
        return view;}
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mImageViewHome1 = (ImageView) getActivity().findViewById(R.id.imageView_home_1);
        mImageViewHome2 = (ImageView) getActivity().findViewById(R.id.imageView_home_2);
        mImageViewHome3 = (ImageView) getActivity().findViewById(R.id.imageView_home_3);
        mImageViewHome4 = (ImageView) getActivity().findViewById(R.id.imageView_home_4);
        mImageViewHome5 = (ImageView) getActivity().findViewById(R.id.imageView_home_5);
        mImageViewHome6 = (ImageView) getActivity().findViewById(R.id.imageView_home_6);
        mImageViewHome7 = (ImageView) getActivity().findViewById(R.id.imageView_home_7);
        mImageViewHome8 = (ImageView) getActivity().findViewById(R.id.imageView_home_8);
        mImageViewHomeStore1 = (ImageView) getActivity().findViewById(R.id.imageView_home_store1);
        mImageViewHomeStore2 = (ImageView) getActivity().findViewById(R.id.imageView_home_store2);
        mImageViewHomeStore3 = (ImageView) getActivity().findViewById(R.id.imageView_home_store3);
        mImageViewHomeStore4 = (ImageView) getActivity().findViewById(R.id.imageView_home_store4);
        mImageViewHomeStore1.setImageResource(R.drawable.coffee1);
        mImageViewHomeStore2.setImageResource(R.drawable.coffee2);
        mImageViewHomeStore3.setImageResource(R.drawable.coffee3);
        mImageViewHomeStore4.setImageResource(R.drawable.coffee4);
        mImageViewHome1.setImageResource(R.drawable.ic_launcher);
        mImageViewHome2.setImageResource(R.drawable.ic_launcher);
        mImageViewHome3.setImageResource(R.drawable.ic_launcher);
        mImageViewHome4.setImageResource(R.drawable.ic_launcher);
        mImageViewHome5.setImageResource(R.drawable.ic_launcher);
        mImageViewHome6.setImageResource(R.drawable.ic_launcher);
        mImageViewHome7.setImageResource(R.drawable.ic_launcher);
        mImageViewHome8.setImageResource(R.drawable.ic_launcher);
        mImageViewHome1.setOnClickListener(this);
        mImageViewHome2.setOnClickListener(this);
        mImageViewHome3.setOnClickListener(this);
        mImageViewHome4.setOnClickListener(this);
        mImageViewHome5.setOnClickListener(this);
        mImageViewHome6.setOnClickListener(this);
        mImageViewHome7.setOnClickListener(this);
        mImageViewHome8.setOnClickListener(this);
        mImageViewHomeStore1.setOnClickListener(this);
        mImageViewHomeStore1.setOnClickListener(this);
        mImageViewHomeStore1.setOnClickListener(this);
        mImageViewHomeStore1.setOnClickListener(this);
        mViewPaper = (ViewPager) getActivity().findViewById(R.id.vp);
        //显示的图片
        images = new ArrayList<ImageView>();
        for(int i = 0; i < imageIds.length; i++){
            ImageView imageView = new ImageView(getActivity());
            imageView.setBackgroundResource(imageIds[i]);
            images.add(imageView);
        }
        //显示的小点
        dots = new ArrayList<View>();
        dots.add(getActivity().findViewById(R.id.dot_0));
        dots.add(getActivity().findViewById(R.id.dot_1));
        dots.add(getActivity().findViewById(R.id.dot_2));
        dots.add(getActivity().findViewById(R.id.dot_3));
        dots.add(getActivity().findViewById(R.id.dot_4));
        title = (TextView) getActivity().findViewById(R.id.title444);
        title.setText(titles[0]);
        adapter = new ViewPagerAdapter();
        mViewPaper.setAdapter(adapter);
        mViewPaper.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {//滑动监听事件
            @Override
            public void onPageSelected(int position) {
                title.setText(titles[position]);
                dots.get(position).setBackgroundResource(R.drawable.ic_launcher);
                dots.get(oldPosition).setBackgroundResource(R.drawable.ffffff);
                oldPosition = position;
                currentItem = position;
            }
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }
            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
        onStartl();
    }
    public class ViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }
//        destroyItem（）：从当前container中删除指定位置（position）的View;
        @Override
        public void destroyItem(ViewGroup view, int position, Object object) {
            // TODO Auto-generated method stub
//          super.destroyItem(container, position, object);
//          view.removeView(view.getChildAt(position));
//          view.removeViewAt(position);
            view.removeView(images.get(position));}
//        instantiateItem()：做了两件事，第一：将当前视图添加到container中，第二：返回当前View
        @Override
        public Object instantiateItem(ViewGroup view, int position) {
            // TODO Auto-generated method stub
            view.addView(images.get(position));
            return images.get(position);
        }
    }
        public void onStartl() {
            // TODO Auto-generated method stub
            scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
            scheduledExecutorService.scheduleWithFixedDelay(
                    new Runnable(){//声明一个线程
                        @Override
                        public void run() {
                            currentItem = (currentItem + 1) % imageIds.length;
                            mHandler.sendEmptyMessage(0);//发送一个请求
                        }
                    },//线程
                    2,//延迟
                    2,//时间
                    TimeUnit.SECONDS);//单位);
        }
        private Handler mHandler = new Handler() {
            public void handleMessage(android.os.Message msg) {
                   mViewPaper.setCurrentItem(currentItem);//设置现在的View
//                setCurrentItem(int index)方法主要用来制定初始化的页面。例如加入3个页面通过setCurrentItem(0)制定第一个页面为当前页面
            };
        };
        @Override
        public void onStop() {
            // TODO Auto-generated method stub
            super.onStop();//结束这个线程池
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdown();
                scheduledExecutorService = null;
            }
        }
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.imageView_home_1:
                    Intent intent1 = new Intent();
                    intent1.setAction("com.great.activity_intent.coffee_userActivity");
                    //Data内容：scheme://host形式
                    startActivity(intent1);
                    break;
                case R.id.imageView_home_2:
                    Intent intent2 = new Intent();
                    intent2.setAction("com.great.activity_intent.coffee_informationActivity");
                    //Data内容：scheme://host形式
                    startActivity(intent2);

                    break;
                case R.id.imageView_home_3:
                    Intent intent3 = new Intent(getActivity(), CoffeeActivity.class);

                    //Data内容：scheme://host形式
                    startActivity(intent3);

                    break;
                case R.id.imageView_home_4:

                    break;
                case R.id.imageView_home_5:

                    break;
                case R.id.imageView_home_6:

                    break;
                case R.id.imageView_home_7:

                    break;
                case R.id.imageView_home_8:

                    break;

                case R.id.imageView_home_store1:

                    break;
                case R.id.imageView_home_store2:

                    break;
                case R.id.imageView_home_store3:

                    break;
                case R.id.imageView_home_store4:
                    break;

            }
        }
    }





