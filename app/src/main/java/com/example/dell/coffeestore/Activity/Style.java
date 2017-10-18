package com.example.dell.coffeestore.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dell.coffeestore.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Style extends AppCompatActivity {
    private ListView lv_style;
    private List<Map<String,Object>> stylelist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style);
        lv_style = (ListView) findViewById(R.id.lv_style);
        stylelist = getDate();
        StyleAdpter styleAdpter = new StyleAdpter(this);
        lv_style.setAdapter(styleAdpter);
    }
    private List<Map<String,Object>> getDate(){
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("style_iv1",R.drawable.natie1);
        map.put("style_tv_title","拿铁");
        map.put("style_tv_content","拿铁咖啡（Caffè Latte），浓缩咖啡与牛奶的经典混合。" +
                "咖啡在底层，牛奶在咖啡上面，最上面是一层奶泡。也可以放一些焦糖就成了焦糖拿铁。");
        map.put("style_tv_price","30");
        map.put("style_iv_star",R.drawable.star4);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("style_iv1",R.drawable.jiao2);
        map.put("style_tv_title","焦糖玛琪朵");
        map.put("style_tv_content","焦糖玛琪朵（Caramel Macchiato），由香浓热牛奶上加入浓缩咖啡、香草，最后淋上纯正焦糖而成，“Caramel”就是焦糖的意思。" +
                "焦糖玛琪朵就是加了焦糖的Macchiato，代表“甜蜜的印记”");
        map.put("style_tv_price","31");
        map.put("style_iv_star",R.drawable.star4);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("style_iv1",R.drawable.kabu3);
        map.put("style_tv_title","卡布奇诺");
        map.put("style_tv_content","卡布奇诺（Cappuccino），以等量的浓缩咖啡和蒸汽泡沫牛奶混合的意大利咖啡。" +
                "咖啡的颜色就像卡布奇诺教会的修士在深褐色的外衣上覆上一条头巾一样，咖啡因此得名。");
        map.put("style_tv_price","35");
        map.put("style_iv_star",R.drawable.star4);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("style_iv1",R.drawable.moka4);
        map.put("style_tv_title","摩卡");
        map.put("style_tv_content","摩卡咖啡（CafeMocha），是一种最古老的咖啡，是由意大利浓缩咖啡、巧克力酱、鲜奶油和牛奶混合而成，摩卡得名于有名的摩卡港。其独特之甘，酸，苦味，极为优雅。为一般高级人士所喜爱的优良品种。" +
                "普通皆单品饮用。饮之润滑可口。醇味历久不退。若调配综合咖啡，更是一种理想的品种。");
        map.put("style_tv_price","39");
        map.put("style_iv_star",R.drawable.star4);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("style_iv1",R.drawable.aier5);
        map.put("style_tv_title","爱尔兰");
        map.put("style_tv_content","爱尔兰咖啡（Irish Coffee），是一种既像酒又像咖啡的咖啡，由爱尔兰威士忌加入浓缩咖啡中，再在最上面放上一层鲜奶油构制而成。" +
                "可以这样说，爱尔兰咖啡是一种含有酒精的咖啡。");
        map.put("style_tv_price","39");
        map.put("style_iv_star",R.drawable.star4);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("style_iv1",R.drawable.wei6);
        map.put("style_tv_title","维也纳");
        map.put("style_tv_content","维也纳咖啡（Viennese），奥地利最著名的咖啡，由浓缩咖啡、鲜奶油和巧克力混合而成。" +
                "奶油柔和爽口，咖啡润滑微苦，糖浆即溶未溶。");
        map.put("style_tv_price","66");
        map.put("style_iv_star",R.drawable.star4);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("style_iv1",R.drawable.kang7);
        map.put("style_tv_title","康宝蓝");
        map.put("style_tv_content","康宝蓝（Con Panna），意大利咖啡品种之一，与玛琪雅朵齐名，" +
                "由浓缩咖啡喝鲜奶油混合而成，咖啡在下面，鲜奶油在咖啡上面。");
        map.put("style_tv_price","54");
        map.put("style_iv_star",R.drawable.star4);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("style_iv1",R.drawable.bai8);
        map.put("style_tv_title","白咖啡");
        map.put("style_tv_content","白咖啡（Flat white），是马来西亚的特产，白咖啡的颜色并不是白色，" +
                "但是比普通咖啡更清淡柔和，白咖啡味道纯正，甘醇芳香。");
        map.put("style_tv_price","54");
        map.put("style_iv_star",R.drawable.star4);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("style_iv1",R.drawable.nong9);
        map.put("style_tv_title","浓缩咖啡");
        map.put("style_tv_content","浓缩咖啡（Espresso)，属于意式咖啡，就是我们平常用咖啡直接冲出来的" +
                "那种，味道浓郁，入口微苦，咽后留香。适合上班族。");
        map.put("style_tv_price","50");
        map.put("style_iv_star",R.drawable.star4);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("style_iv1",R.drawable.mei10);
        map.put("style_tv_title","美式咖啡");
        map.put("style_tv_content","美式咖啡（Americano），是最普通的咖啡，属于黑咖啡的一种。" +
                "在浓缩咖啡中直接加入大量的水制成，口味比较淡，咖啡因含量较高。");
        map.put("style_tv_price","49");
        map.put("style_iv_star",R.drawable.star4);
        list.add(map);
        return list;
    }
    public final class viewHolder{
        public ImageView iv_style_cfname;
        public TextView tv_style_title;
        public TextView tv_style_content;
        public TextView tv_style_price;
        public ImageView iv_style_star;
    }
    public class StyleAdpter extends BaseAdapter{
        private LayoutInflater styleInflater;
        public StyleAdpter(Context context) {
            styleInflater =  LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return stylelist.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            viewHolder holder = null;
            if (convertView == null) {
                holder = new viewHolder();
                convertView = styleInflater.inflate(R.layout.style_item, null);
                holder.iv_style_cfname = (ImageView) convertView.findViewById(R.id.iv_style_cfname);
                holder.tv_style_title = (TextView) convertView.findViewById(R.id.tv_style_title);
                holder.tv_style_content = (TextView) convertView.findViewById(R.id.tv_style_content);
                holder.tv_style_price = (TextView) convertView.findViewById(R.id.tv_style_price);
                holder.iv_style_star = (ImageView) convertView.findViewById(R.id.iv_style_star);
                convertView.setTag(holder);
            } else {
                holder = (viewHolder) convertView.getTag();
            }
            holder.iv_style_cfname.setImageResource((Integer) stylelist.get(position).get("style_iv1"));
            holder.tv_style_title.setText((String) stylelist.get(position).get("style_tv_title"));
            holder.tv_style_content.setText((String) stylelist.get(position).get("style_tv_content"));
            holder.tv_style_price.setText((String) stylelist.get(position).get("style_tv_price"));
            holder.iv_style_star.setImageResource((Integer) stylelist.get(position).get("style_iv_star"));
            holder.iv_style_cfname.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (position) {
                        case 0: {
                            Intent styleIntent = new Intent(Style.this, RegisterActivity.class);
                            startActivity(styleIntent);

                        }
                    }
                }
            });

            return convertView;
        }
    }

}
