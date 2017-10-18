package com.example.dell.coffeestore.Activity;

import android.os.Handler;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.coffeestore.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CoffeeActivity extends AppCompatActivity {
    private ViewPager mViewPaper;
    private List<ImageView> images;
    private List<View> dots;
    private int currentItem;
    //记录上一次点的位置
    private int oldPosition = 0;
    //存放图片的id
    private int[] imageIds = new int[]{
            R.drawable.coffee1,
            R.drawable.coffee2,
            R.drawable.coffee3,
            R.drawable.coffee4,
            R.drawable.coffee4
    };
    //存放图片的标题
    private String[] titles = new String[]{
            "coffee1",
            "coffee2",
            "coffee3",
            "coffee4",
            "coffee5"
    };
    private TextView title;
    //private ViewPagerAdapter adapter;
    private ScheduledExecutorService scheduledExecutorService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);
//        mViewPaper = (ViewPager) findViewById(R.id.vp);
//        //显示的图片
//        images = new ArrayList<ImageView>();
//        for(int i = 0; i < imageIds.length; i++){
//            ImageView imageView = new ImageView(this);
//            imageView.setBackgroundResource(imageIds[i]);
//            images.add(imageView);
//        }
//        //显示的小点
//        dots = new ArrayList<View>();
//        dots.add(findViewById(R.id.dot_0));
//        dots.add(findViewById(R.id.dot_1));
//        dots.add(findViewById(R.id.dot_2));
//        dots.add(findViewById(R.id.dot_3));
//        dots.add(findViewById(R.id.dot_4));
//
//        title = (TextView) findViewById(R.id.title);
//        title.setText(titles[0]);
//
//        adapter = new ViewPagerAdapter();
//        mViewPaper.setAdapter(adapter);
//
//        mViewPaper.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//
//
//            @Override
//            public void onPageSelected(int position) {
//                title.setText(titles[position]);
//                dots.get(position).setBackgroundResource(R.drawable.ic_launcher);
//                dots.get(oldPosition).setBackgroundResource(R.drawable.selector_tab);
//
//                oldPosition = position;
//                currentItem = position;
//            }
//
//            @Override
//            public void onPageScrolled(int arg0, float arg1, int arg2) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int arg0) {
//
//            }
//        });
//    }
//
//    /**
//     * 自定义Adapter
//     * @author liuyazhuang
//     *
//     */
//    public class ViewPagerAdapter extends PagerAdapter {
//
//        @Override
//        public int getCount() {
//            return images.size();
//        }
//
//        @Override
//        public boolean isViewFromObject(View arg0, Object arg1) {
//            return arg0 == arg1;
//        }
//
//        @Override
//        public void destroyItem(ViewGroup view, int position, Object object) {
//            // TODO Auto-generated method stub
////          super.destroyItem(container, position, object);
////          view.removeView(view.getChildAt(position));
////          view.removeViewAt(position);
//            view.removeView(images.get(position));
//        }
//
//        @Override
//        public Object instantiateItem(ViewGroup view, int position) {
//            // TODO Auto-generated method stub
//            view.addView(images.get(position));
//            return images.get(position);
//        }
//
//    }
//
//
//    /**
//     * 利用线程池定时执行动画轮播
//     */
//    @Override
//    protected void onStart() {
//        // TODO Auto-generated method stub
//        super.onStart();
//        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
//        scheduledExecutorService.scheduleWithFixedDelay(
//                new ViewPageTask(),
//                2,
//                2,
//                TimeUnit.SECONDS);
//    }
//
//
//    /**
//     * 图片轮播任务
//     * @author liuyazhuang
//     *
//     */
//    public static class ViewPageTask implements Runnable{
//
//        @Override
//        public void run() {
//            currentItem = (currentItem + 1) % imageIds.length;
//            mHandler.sendEmptyMessage(0);
//        }
//    }
//
//    /**
//     * 接收子线程传递过来的数据
//     */
//    private Handler mHandler = new Handler(){
//        public void handleMessage(android.os.Message msg) {
//            mViewPaper.setCurrentItem(currentItem);
//        };
//    };
//    @Override
//    protected void onStop() {
//        // TODO Auto-generated method stub
//        super.onStop();
//        if(scheduledExecutorService != null){
//            scheduledExecutorService.shutdown();
//            scheduledExecutorService = null;
//        }
//    }

    }
}

