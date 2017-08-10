package com.example.shinelon.gittest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Shinelon on 2017/8/10.
 * 黑科技-1像素页面保活
 */
public class HooliganActivity extends AppCompatActivity {
    public static HooliganActivity instance; //单例静态

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        //获得窗体对象
        Window window = getWindow();
        window.setGravity(Gravity.LEFT | Gravity.TOP);
        //设置参数
        WindowManager.LayoutParams params = window.getAttributes();
        params.x = 0;
        params.y = 0;
        params.height = 1;
        params.width = 1;
        window.setAttributes(params);
    }

    /**
     * 开启保活页面
     */
    public static void startHooligan() {
        Intent intent = new Intent(MyApplication.getAppliactionContext(), HooliganActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        MyApplication.getAppliactionContext().startActivity(intent);
    }

    /**
     * 关闭保活页面
     */
    public static void killHooligan() {
        if (instance != null) {
            instance.finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        instance = null;
    }
}
