package com.example.myapp2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp2.R;

public class SignActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBt;
    private String mUser_package_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        mBt = findViewById(R.id.bt_confirm_login);
        mBt.setOnClickListener(this);
        mBt.setEnabled(false);

        //获取传递的数据
        Intent intent = getIntent();
        Uri uri = intent.getData();

        //获取参数值
        String type = uri.getQueryParameter("type");
        mUser_package_name = uri.getQueryParameter("user_package_name");

        //类型type 检验
        if (TextUtils.equals(type, "1")) {
            //Todo 未登录 处理
            request5037();
        }
    }

    /**
     * 外部 app 拉起授权 (code:5037)
     * 服务器校验 是否授权
     * 授权 页面A状态
     */

    private void request5037() {
        mBt.setEnabled(true);
    }


    @Override
    public void onClick(View v) {
        Intent intent1 = new Intent();
        intent1.setAction("kx.com.kx.bapp2.sign");
        intent1.putExtra("token", "xxxx-xxxx-xxxxx");
        intent1.putExtra("app_pkg", "com.kx.aapp");
        sendBroadcast(intent1);
        finish();
    }
}