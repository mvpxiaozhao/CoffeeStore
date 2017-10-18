package com.example.dell.coffeestore.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.dell.coffeestore.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.widget.NumberPicker.OnScrollListener.SCROLL_STATE_FLING;

public class Coffee_userActivity extends AppCompatActivity implements AbsListView.OnScrollListener ,AdapterView.OnItemClickListener {
    private int[] pic = new int[]{R.drawable.kabuqinuo, R.drawable.maoshi, R.drawable.shangdao,
            R.drawable.xingbake};
    private String[] data[] = new String[][]{{"左岸咖啡店   ", "星海广场001号", "041183404848"}, {"漫猫咖啡店   ", "中山区无名街002号", "041183404444"}
            , {"星巴克咖啡店 ", "甘井子区数码路北段18-25号", "88147265"}, {"萌客思维主题咖啡馆", "甘井子区软件园路144号", "15041190144"}};

    private ListView lv_list;
    private SimpleAdapter sim_adapter;
    private List<Map<String, Object>> datalist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_user);

        lv_list = (ListView) findViewById(R.id.lv_list);
        datalist = new ArrayList<Map<String, Object>>();

        sim_adapter = new SimpleAdapter(Coffee_userActivity.this, getData(), R.layout.main, new String[]{"pic", "title", "address", "post"}, new int[]
                {R.id.iv_pic, R.id.tv_title, R.id.tv_address, R.id.tv_post});

        lv_list.setAdapter(sim_adapter);
        lv_list.setOnScrollListener(this);
        lv_list.setOnItemClickListener(this);
    }

    private List<Map<String, Object>> getData() {
        for (int i = 0; i < data.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("pic", pic[i]);
            map.put("title", data[i][0]);
            map.put("address", data[i][1]);
            map.put("post", data[i][2]);
            datalist.add(map);

        }
        return datalist;
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int scrollState) {
        switch(scrollState) {
            case SCROLL_STATE_FLING:
                for (int i = 0; i < data.length; i++) {

                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("pic", pic[i]);
                    map.put("title", data[i][0]);
                    map.put("address", data[i][1]);
                    map.put("post", data[i][2]);
                    datalist.add(map);
                    sim_adapter.notifyDataSetChanged();
                }
                break;
        }

    }

    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2) {


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        switch (position) {

            case 0:
                Intent intent = new Intent(Coffee_userActivity.this,Style.class);
                startActivity(intent);
                break;
            case 1:
                Intent intent1 = new Intent(Coffee_userActivity.this, MainActivity.class);
                startActivity(intent1);
                break;
            case 2:
                Intent intent2 = new Intent(Coffee_userActivity.this, Style.class);
                startActivity(intent2);
                break;
            case 3:
                Intent intent3 = new Intent(Coffee_userActivity.this, MainActivity.class);
                startActivity(intent3);
                break;
            case 4:
                Intent inten4 = new Intent(Coffee_userActivity.this, Style.class);
                startActivity(inten4);
                break;
            case 5:
                Intent intent5 = new Intent(Coffee_userActivity.this, MainActivity.class);
                startActivity(intent5);
                break;
            case 6:
                Intent intent6 = new Intent(Coffee_userActivity.this, Style.class);
                startActivity(intent6);
                break;
            case 7:
                Intent intent7 = new Intent(Coffee_userActivity.this, MainActivity.class);
                startActivity(intent7);
                break;
        }

    }
}
