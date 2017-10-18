package com.example.dell.coffeestore.Activity;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.dell.coffeestore.Fragment.HomeFragment;
import com.example.dell.coffeestore.Fragment.MeFragment;
import com.example.dell.coffeestore.Fragment.SearchFragment;
import com.example.dell.coffeestore.Fragment.ShopCarFragment;
import com.example.dell.coffeestore.Fragment.SortFagment;
import com.example.dell.coffeestore.R;

import java.util.ArrayList;
public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {
    private ViewPager mainViewPager;
    private RadioGroup tabsRg;
    private RadioButton RBA;
    private RadioButton RBB;
    private RadioButton RBC;
    private RadioButton RBD;
    private RadioButton RBE;
    private ArrayList<Fragment> fragmentArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewPager = (ViewPager) findViewById(R.id.main_ViewPager);
        tabsRg = (RadioGroup) findViewById(R.id.tabs_rg);
        RBA = (RadioButton) findViewById(R.id.RB_a);
        RBB = (RadioButton) findViewById(R.id.RB_b);
        RBC = (RadioButton) findViewById(R.id.RB_c);
        RBD = (RadioButton) findViewById(R.id.RB_d);
        RBE = (RadioButton) findViewById(R.id.RB_e);
        fragmentArrayList=new ArrayList<Fragment>();
        Fragment homeFragment=new HomeFragment();
        Fragment meFragment=new MeFragment();
        Fragment searchFragment=new SearchFragment();
        Fragment shopcarFragment=new ShopCarFragment();
        Fragment sortFragment=new SortFagment();
        fragmentArrayList.add(homeFragment);
        fragmentArrayList.add(meFragment);
        fragmentArrayList.add(searchFragment);
        fragmentArrayList.add(shopcarFragment);
        fragmentArrayList.add(sortFragment);
        mainViewPager.setAdapter(new MyAdapter(getSupportFragmentManager(),fragmentArrayList));
        mainViewPager.setCurrentItem(0);
        mainViewPager.addOnPageChangeListener(new Mylistner());
        tabsRg.setOnCheckedChangeListener(this);
    }
    public  class MyAdapter extends FragmentPagerAdapter{

        ArrayList<Fragment> list;
        public MyAdapter(FragmentManager fm, ArrayList<Fragment> list) {
            super(fm);
            this.list= list;
        }
        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

//        @Override
//        public android.support.v4.app.Fragment getItem(int index) {
//            return list.get(index);
//        }
//        @Override
//        public int getCount() {
//            return list.size();
//        }
   }
    public class  Mylistner implements ViewPager.OnPageChangeListener{
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }
        @Override
        public void onPageSelected(int position) {
            int current =mainViewPager.getCurrentItem();
            switch (current){
                case 0:
//                    //判断是否选择
//                    if (isChecked()) {
//                        //如果选择, 把选择的状态, 合并到现有的状态中.
//                        mergeDrawableStates(drawableState, CHECKED_STATE_SET);
//                    }
//                    .check设置
                    tabsRg.check(R.id.RB_a);
                    break;
                case 1:
                    tabsRg.check(R.id.RB_b);
                    break;
                case 2:
                    tabsRg.check(R.id.RB_c);
                    break;
                case 3:
                    tabsRg.check(R.id.RB_d);
                    break;
                case 4:
                    tabsRg.check(R.id.RB_e);
                    break;
            }
        }
        @Override
        public void onPageScrollStateChanged(int state) {
        }
    }
    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        int current=0;
        switch (checkedId){
            case R.id.RB_a:
                current=0;
                break;
            case R.id.RB_b:
                current=1;
                break;
            case R.id.RB_c:
                current=2;
                break;
            case R.id.RB_d:
                current=3;
                break;
            case R.id.RB_e:
                current=4;
                break;
        }
        if (mainViewPager.getCurrentItem()!=current){
            mainViewPager.setCurrentItem(current);
        }
    }
     public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        // 按下键盘上返回按钮
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitAppDialog();
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }
    public void exitAppDialog() {
        new AlertDialog.Builder(this)

                // .setIcon(android.R.drawable.ic_menu_info_detailsp)
                .setTitle("提示").setMessage("你确定要退出吗").setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        }).setPositiveButton("确定", new DialogInterface.OnClickListener()

        {
            public void onClick(DialogInterface dialog, int whichButton) {
                finish();
            }
        }).show();
    }
}
