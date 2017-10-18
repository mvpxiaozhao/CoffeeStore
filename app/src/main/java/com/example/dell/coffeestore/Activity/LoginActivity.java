package com.example.dell.coffeestore.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.coffeestore.Class.DBAdapter;
import com.example.dell.coffeestore.Class.PeopleInfo;
import com.example.dell.coffeestore.Class.T_userinformation;
import com.example.dell.coffeestore.R;

public class LoginActivity extends AppCompatActivity  implements View.OnClickListener{
    private EditText user;
    private EditText pass;
    private Button button_ok;
    private CheckBox checkBox;
    private Button button_in;
    String userinfo="userinfo";
    String uNme="userinfo1";
    String uPwd="userinfo2";
    DBAdapter dbAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = (EditText) findViewById(R.id.editText_user);
        pass = (EditText) findViewById(R.id.editText_pass);
        button_ok = (Button) findViewById(R.id.button_log_iog);
        button_in = (Button) findViewById(R.id.button_log_register);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        loaUserInfo();
        dbAdapter=new DBAdapter(this);
        dbAdapter.openDB();
        button_ok.setOnClickListener(this);
        button_in.setOnClickListener(this);
    }
    //开始
    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        Log.i("1", "Start");
    }
    //启动 [riː'stɑːt]
    @Override
    protected void onRestart() {
        // TODO Auto-generated method stub
        super.onRestart();
        Log.i("1", "Restart");
    }
    //暂停 Pause[pɔːz] n. 暂停；间歇
    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        Log.i("1", "Pause");
    }
    //停止
    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        Log.i("1", "Stop");
    }
    //破坏
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        Log.i("1", "Destroy");
        if(checkBox.isChecked()){
            saveUseerInfo(user.getText().toString(),pass.getText().toString());
        }
    }
    //成新开始n. 摘要；[管理] 履历，简历
    //  vt. 重新开始，继续；恢复，重新占用
    // vi. 重新开始，继续
    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        Log.i("1", "Resume");
    }
    private void loaUserInfo(){
        SharedPreferences sp=getSharedPreferences(userinfo,MODE_PRIVATE);

        user.setText(sp.getString(uNme,null));
        pass.setText(sp.getString(uPwd,null));


    }
    private void saveUseerInfo(String userName,String userPwd){
        SharedPreferences sp=getSharedPreferences(userinfo,MODE_PRIVATE);//创建文件  sp
        SharedPreferences.Editor editorSp=sp.edit();//Editor 表示向那个文件储存  sp
        editorSp.putString(uNme,userName);
        editorSp.putString(uPwd,userPwd);
        editorSp.commit();//上传

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_log_iog:
                int i;
                boolean e=false;
                String name="";
                String passs="";
                String stringname=user.getText().toString().trim();
                String stringpass=pass.getText().toString().trim();
                if (stringname.equals("")){
                    Toast.makeText(LoginActivity.this,"请输入mane",Toast.LENGTH_LONG).show();
                    return;
                }
                if (stringpass.equals("")){
                    Toast.makeText(LoginActivity.this,"请输入pass",Toast.LENGTH_LONG).show();
                    ;
                }
                PeopleInfo[] peoples=dbAdapter.qurryAll();
                for (i = 0; i < peoples.length; i++) {
                    name=peoples[i].name();
                    passs=peoples[i].pass();
                    if (stringname.equals(name)&&stringpass.equals(passs)) {
                        e=true;
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();

                    }

                }


                break;
            case R.id.button_log_register:
                Intent intent2=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent2);

                break;

        }



    }


}

