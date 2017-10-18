package com.example.dell.coffeestore.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dell.coffeestore.Class.DBAdapter;
import com.example.dell.coffeestore.Class.PeopleInfo;
import com.example.dell.coffeestore.Class.T_feedbackinformation;
import com.example.dell.coffeestore.Class.yijiansql;
import com.example.dell.coffeestore.R;


public class Coffee_Idea extends Activity implements View.OnClickListener{


    private Button mBtnIdea;
    private EditText mEtName;
    private EditText mEtShow;
    private EditText mEtPhone;
    private Button mBtnYes;

    private Button mBtnKan;
    private Button mBtnQq;
    private Button mBtnMail;
    private Button mBtnWechat;
    private TextView mKan;





    String[] item_list={"功能意见","界面意见","您的新需求","操作意见","流量问题","其他"};

    yijiansql fendAdapter;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee__idea);
        fendAdapter=new yijiansql(this);
        fendAdapter.openDB();
        mBtnIdea = (Button) findViewById(R.id.btn_idea);
        mEtName = (EditText) findViewById(R.id.et_name);
        mEtShow = (EditText) findViewById(R.id.et_show);
        mEtPhone = (EditText) findViewById(R.id.et_phone);
        mBtnYes = (Button) findViewById(R.id.btn_yes);

        mBtnKan = (Button) findViewById(R.id.btn_kan);
        mBtnQq = (Button) findViewById(R.id.btn_qq);
        mBtnMail = (Button) findViewById(R.id.btn_mail);
        mBtnWechat = (Button) findViewById(R.id.btn_wechat);
        mKan = (TextView) findViewById(R.id.kan);;
        mBtnIdea.setOnClickListener(this);
        mBtnYes.setOnClickListener(this);

        mBtnKan.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_idea:
                showDialog();
            break;
            case R.id.btn_yes:
                String name=mEtName.getText().toString().trim();
                String type=mBtnIdea.getText().toString().trim();
                String content=mEtShow.getText().toString().trim();
                String phone=mEtPhone.getText().toString().trim();
                T_feedbackinformation people2=new T_feedbackinformation(name,type,content,phone);
                fendAdapter.Insert(people2);
                mKan.setText("数据添加成功"+"\n");

                break;

            case R.id.btn_kan:
                T_feedbackinformation[] peoples=fendAdapter.qurryAll();
                if (peoples==null) {
                    mKan.setText("数据库为空");
                    return;
                }
                else {
                    String result="";
                    System.out.println("-->>"+"数据库记录一共有"+peoples.length+"条");
                    for (int i = 0; i < peoples.length; i++) {
                        result+=peoples[i].showInfo();
                    }
                    mKan.setText(result);
                }
                break;
        }

    }

    private void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("选择服务");
        builder.setItems(item_list, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mBtnIdea.setText(item_list[which]+"");
            }
        }).show();
//        AlertDialog dialog = builder.create();
//        dialog.show();
}
}
