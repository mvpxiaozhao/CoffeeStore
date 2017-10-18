package com.example.dell.coffeestore.Fragment;


import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.dell.coffeestore.Activity.Coffee_Idea;
import com.example.dell.coffeestore.Activity.RegisterActivity;
import com.example.dell.coffeestore.Activity.Style;
import com.example.dell.coffeestore.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortFagment  extends Fragment implements View.OnClickListener,AdapterView.OnItemClickListener {
    private ListView lv_list;
    private SimpleAdapter sim_adapter;
    private List<Map<String,Object>> datalist;
    private String  data[]=new  String[]{"我的信息","我的评论","地址管理","我的收藏","我的礼券","我的积分","我的信息","设置"};
    private Button btn_land;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_sort_fagment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lv_list = (ListView) getActivity().findViewById(R.id.lv_list4);

        datalist = new ArrayList<Map<String,Object>>();
        sim_adapter = new SimpleAdapter(getActivity(),getData(),R.layout.layout,new  String[]{"text","pic"},new int[]{R.id.tv_text,R.id.tv_pic
        });
        lv_list.setAdapter(sim_adapter);

        lv_list.setOnItemClickListener(this);

    }
    private  List<Map<String,Object>>  getData(){
        for (int i=0;i<data.length;i++){
            Map<String,Object> map= new HashMap<String,Object>();
            map.put("text", data[i]);
            map.put("pic" ,">");
            datalist.add(map);
        }
        return datalist;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //数组需要索引，索引相当于位置
        switch (position){
            case 0:

                break;
            case  1:
                Intent styleIntent1 = new Intent(getActivity(),Coffee_Idea.class);
                startActivity(styleIntent1);

                break;
        }


    }
}
