package com.example.dell.coffeestore.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dell.coffeestore.Class.DBAdapter;
import com.example.dell.coffeestore.Class.PeopleInfo;
import com.example.dell.coffeestore.Class.T_userinformation;
import com.example.dell.coffeestore.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTextView3;

    private EditText mEditTextUserName;
    private EditText mEditTextUserPass;
    private EditText mEditTextUserSex;
    private EditText mEditTextUserPhone;
    private Button mButtonUserOk;
    private Button mButtonUserback;
    private Button mButtonUserall;
    DBAdapter adpter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        mEditTextUserName = (EditText) findViewById(R.id.editText_user_name);
        mEditTextUserPass = (EditText) findViewById(R.id.editText_user_pass);
        mEditTextUserSex = (EditText) findViewById(R.id.editText_user_sex);

        mEditTextUserPhone = (EditText) findViewById(R.id.editText_user_phone);
        mButtonUserOk = (Button) findViewById(R.id.button_user_ok);
        mButtonUserback = (Button) findViewById(R.id.Button_user_back);
        mTextView3= (TextView) findViewById(R.id.textView_user_chulai);
        mButtonUserall= (Button) findViewById(R.id.Button_user_all);
        mButtonUserOk.setOnClickListener(this);
        mButtonUserall.setOnClickListener(this);
        mButtonUserback.setOnClickListener(this);
        adpter=new DBAdapter(this);
        adpter.openDB();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_user_ok:
                String name=mEditTextUserName.getText().toString().trim();
                String pass=mEditTextUserPass.getText().toString().trim();
                String sex=mEditTextUserSex.getText().toString().trim();
                String phone=mEditTextUserPhone.getText().toString().trim();
                PeopleInfo people1=new PeopleInfo(name,pass,sex,phone);
                adpter.Insert(people1);
                mTextView3.setText("数据添加成功"+"\n");
                break;
            case R.id.Button_user_all:

                PeopleInfo[] peoples=adpter.qurryAll();
            if (peoples==null) {
                mTextView3.setText("数据库为空");
                return;
            }
            else {
                String result="";
                System.out.println("-->>"+"数据库记录一共有"+peoples.length+"条");
                for (int i = 0; i < peoples.length; i++) {
                    result+=peoples[i].showInfo();
                }
                mTextView3.setText(result);
            }
                break;
            case R.id.Button_user_back:
                Intent styleIntenf= new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(styleIntenf);
                finish();
                break;
        }

    }
}
