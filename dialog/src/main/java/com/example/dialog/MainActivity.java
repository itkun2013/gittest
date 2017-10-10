package com.example.dialog;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dialog.fragment.EcgFragmnet12;
import com.example.dialog.fragment.EcgFragmnet3;
import com.example.dialog.fragment.EcgFragmnet5;
import com.example.dialog.fragment.RespFragment;
import com.example.dialog.fragment.Spo2Fragment;

public class MainActivity extends AppCompatActivity {
    EcgFragmnet3 ecgFragmnet3;
    EcgFragmnet5 ecgFragmnet5;
    EcgFragmnet12 ecgFragmnet12;
    RespFragment respFragment;
    Spo2Fragment spo2Fragment;
    private Button button;
    private Button button5;
    private Button button12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btn3);
        button5 = (Button) findViewById(R.id.btn5);
        button12 = (Button) findViewById(R.id.btn12);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setEcgFragment(3);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setEcgFragment(5);
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setEcgFragment(12);
            }
        });
        //根据数据库的信息来布局对应的ragment
        setEcgFragment(3);
        setRespFragment();
        setSpo2Fragment();
    }

    /**
     * 血氧
     */
    private void setSpo2Fragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        spo2Fragment = new Spo2Fragment();
        transaction.replace(R.id.fl_two, spo2Fragment);
        transaction.commit();
    }

    /**
     * 呼吸
     */
    private void setRespFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        respFragment = new RespFragment();
        transaction.replace(R.id.fl_three, respFragment);
        transaction.commit();
    }

    /**
     * 心电布局
     *
     * @param i
     */
    private void setEcgFragment(int i) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        if (i == 3) {
            ecgFragmnet3 = new EcgFragmnet3();
            transaction.replace(R.id.fl_one, ecgFragmnet3);
        } else if (i == 5) {
            ecgFragmnet5 = new EcgFragmnet5();
            transaction.replace(R.id.fl_one, ecgFragmnet5);
        } else {
            ecgFragmnet12 = new EcgFragmnet12();
            transaction.replace(R.id.fl_one, ecgFragmnet12);
        }
        transaction.commit();
    }


}
