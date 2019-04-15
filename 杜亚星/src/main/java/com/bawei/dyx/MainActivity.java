package com.bawei.dyx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.dyx.bean.JsonBean;
import com.bawei.dyx.iview.Iview;
import com.bawei.dyx.presenter.Presenter;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements Iview {

    private EditText phone;
    private EditText mima;
    private Button button;
    private TextView zc;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化框架
        phone = findViewById(R.id.login_zh);
        mima = findViewById(R.id.login_mm);
        button = findViewById(R.id.button);
        zc = findViewById(R.id.zc);
        //初始化P层
        presenter = new Presenter();
        presenter.attchView(this);
        //点击按钮跳转
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取数据
                String phone1 = phone.getText().toString();
                String pwd = mima.getText().toString();
              if (!phone1.isEmpty()&&!pwd.isEmpty()){
                    presenter.getData(phone1,pwd);
                }

               /* if (phone1==null&&pwd!=null){
             Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_LONG).show();

         }
         else {
             Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_LONG).show();
         }*/
            }

        });
        //注册
        zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TwoActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void getData(String data) {
        Gson gson=new Gson();
        JsonBean bean = gson.fromJson(data, JsonBean.class);
     if (bean.getStatus().equals("0000")){
          Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_LONG).show();
         Intent intent = new Intent(MainActivity.this, ShowActivity.class);
         startActivity(intent);
      }
      else{
          Toast.makeText(MainActivity.this,"登录失败",Toast.LENGTH_LONG).show();
      }
    }
}
