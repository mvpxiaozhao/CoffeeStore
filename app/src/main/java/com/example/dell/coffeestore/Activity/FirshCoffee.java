package com.example.dell.coffeestore.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dell.coffeestore.R;

public class FirshCoffee extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGHT= 3000; //延迟三秒

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_firsh);
//            Runnable runnable=new Runnable(){
//                @Override
//                public void run() {
//                    // TODO Auto-generated method stub
//                    //要做的事情，这里再次调用此Runnable对象，以实现每两秒实现一次的定时器操作
//                    handler.postDelayed(this, 2000);
//                }
//            };
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run() {
                    Intent mainIntent = new Intent(FirshCoffee.this,LoginActivity.class);
                    startActivity(mainIntent);
                    FirshCoffee.this.finish();
                }
            }, SPLASH_DISPLAY_LENGHT);
        }
    }

