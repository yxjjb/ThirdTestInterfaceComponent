package com.example.thirdtest;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class Myclass extends Dialog {

    private EditText name;
    private EditText password;
    private Button cancer;
    private Button signin;

    public Myclass(Context context){
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);
        name = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.password);
        cancer = (Button) findViewById(R.id.Cancel);
        signin = (Button) findViewById(R.id.Signin);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = name.getText().toString();        //获取用户名
                String pwd1 = password.getText().toString();         //获取密码
                Log.v("LoginApp", "输入用户名为：" + user);
                Log.v("LoginApp", "输入密码为：" + pwd1);
                if (user.equals("yyy") && pwd1.equals("123456")) {
                    Log.v("LoginApp", "登陆成功！");
                } else {
                    Log.v("LoginApp", "登陆失败！");
                }
            }
        });

        cancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }


}
