package com.ice.expertat.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.ice.expertat.ThrottleFirst;
import com.ice.expertat.Tracking;
import com.ice.goodexecutor.GoodExecutor;

public class MainActivity extends AppCompatActivity {

    private int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSomeThing();
            }
        });

//        ReflectionUtils.printAll(MainActivity.class);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                    String name = Thread.currentThread().getName();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                }
            }
        };

        findViewById(R.id.tv_goodexecutor).setOnClickListener(v->{
            for(int i=0; i<10; i++){
                GoodExecutor.INSTANCE.execute(i, runnable);
            }
            for(int i=0; i<10; i++){
                GoodExecutor.INSTANCE.execute(i, runnable);
            }
            for(int i=0; i<10; i++){
                GoodExecutor.INSTANCE.execute(i, runnable);
            }
            for(int i=0; i<10; i++){
                GoodExecutor.INSTANCE.execute(i, runnable);
            }
        });

        findViewById(R.id.tv_goodexecutor_1).setOnClickListener(v->{
            GoodExecutor.INSTANCE.pause();
        });

        findViewById(R.id.tv_goodexecutor_2).setOnClickListener(v->{
            GoodExecutor.INSTANCE.resume();
        });
    }

    @ThrottleFirst(3000)
    public void doSomeThing(){
        num += 1;
        showSomeThing(num);
    }

    @Tracking
    private void showSomeThing(int num){
        Toast.makeText(this,"数字"+num,Toast.LENGTH_SHORT).show();
    }
}