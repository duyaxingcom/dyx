package com.bawei.dyx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.dyx.bean.ZCbean;
import com.bawei.dyx.iview.Iview;
import com.bawei.dyx.presenter.Zpresenterd;
import com.google.gson.Gson;

public class TwoActivity extends AppCompatActivity implements Iview {

    private Button button_zc,login_fanhui;
    private EditText edit_mima;
    private TextView text_fanhui;
    private EditText qr;
    private EditText shouji;
    private Zpresenterd zpresenterd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        button_zc = findViewById(R.id.button_zc);
        edit_mima = findViewById(R.id.mima);
        text_fanhui = findViewById(R.id.login_fanhui);
        qr = findViewById(R.id.zc_mm);
        shouji = findViewById(R.id.shouji);
        //初始化P
        zpresenterd = new Zpresenterd();
        zpresenterd.attchView(this);
        //注册
        button_zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TwoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void getData(String data) {
        Gson gson=new Gson();
        ZCbean json = gson.fromJson(data, ZCbean.class);
        String zh = edit_mima.getText().toString();
        String shouji1 = shouji.getText().toString();
        String qr1 = qr.getText().toString();
        if (zh==null&&shouji1!=null&&qr1!=null){
            Toast.makeText(TwoActivity.this,"登录成功",Toast.LENGTH_LONG).show();

        }
       if (zh!=null&&shouji1!=null&&qr1!=null){
           Toast.makeText(TwoActivity.this,"登录失败",Toast.LENGTH_LONG).show();

       }
    }

}
