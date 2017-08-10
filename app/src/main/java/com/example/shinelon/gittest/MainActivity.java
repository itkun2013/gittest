package com.example.shinelon.gittest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initEvent();
    }

    /**
     * 监听锁屏和解锁通知，不能静态注册广播，只能动态注册
     */
    private void initEvent() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        registerReceiver(new BootCompletereceive(), filter);
    }

    /**
     * 屏幕开关监听
     */
    private class BootCompletereceive extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
                HooliganActivity.killHooligan();
            } else if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
                HooliganActivity.startHooligan();
            }
        }
    }
}
