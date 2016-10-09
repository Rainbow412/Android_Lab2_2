package com.example.rainbow.lab2v2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.rainbow.lab1.R;

/**
 * Created by 123 on 2016/9/25.
 */
public class MainActivity extends AppCompatActivity {
    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        final EditText username = (EditText) findViewById(R.id.username);
        final EditText password = (EditText) findViewById(R.id.password);
        final TextInputLayout usernameLayout = (TextInputLayout) findViewById(R.id.usernameLayout);
        final TextInputLayout passwordLayout = (TextInputLayout) findViewById(R.id.passwordLayout);
        Button login = (Button) findViewById(R.id.login);
        assert login != null;
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.length() == 0) {
                    usernameLayout.setError("用户名不能为空");
                    passwordLayout.setError(null);
                } else if (password.length() == 0) {
                    usernameLayout.setError(null);
                    passwordLayout.setError("密码不能为空");
                } else {
                    usernameLayout.setError(null);
                    passwordLayout.setError(null);
                    if (username.getText().toString().equals("Android")
                            && password.getText().toString().equals("123456"))
                        Snackbar.make(v, "登陆成功", Snackbar.LENGTH_SHORT)
                                .setAction("按钮", new View.OnClickListener(){
                                    @Override
                                    public void onClick(View view){
                                        Toast.makeText(MainActivity.this, "Snackbar的按钮被点击了",
                                                Toast.LENGTH_LONG).show();
                                    }
                                }).setActionTextColor(getResources().getColor(R.color.colorPrimary))
                                .setDuration(5000).show();
                    else
                        Snackbar.make(v, "登陆失败", Snackbar.LENGTH_SHORT)
                                .setAction("按钮", new View.OnClickListener(){
                                    @Override
                                    public void onClick(View view){
                                        Toast.makeText(MainActivity.this, "Snackbar的按钮被点击了",
                                                Toast.LENGTH_LONG).show();
                                    }
                                }).setActionTextColor(getResources().getColor(R.color.colorPrimary))
                                .setDuration(5000).show();
                }
            }
        });


        RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.type);
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton type = (RadioButton) findViewById(checkedId);
                Snackbar.make(type, type.getText()+"身份被选中", Snackbar.LENGTH_SHORT)
                        .setAction("按钮", new View.OnClickListener(){
                            @Override
                            public void onClick(View view){
                                Toast.makeText(MainActivity.this, "Snackbar的按钮被点击了",
                                        Toast.LENGTH_LONG).show();
                            }
                        }).setActionTextColor(getResources().getColor(R.color.colorPrimary))
                        .setDuration(5000).show();
            }
        });

        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.type);
        Button register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < radioGroup.getChildCount(); i++) {
                    RadioButton type = (RadioButton) radioGroup.getChildAt(i);
                    {
                        if (type.isChecked()) {
                            Snackbar.make(v, type.getText()+"身份注册功能尚未开启", Snackbar.LENGTH_SHORT)
                                    .setAction("按钮", new View.OnClickListener(){
                                        @Override
                                        public void onClick(View view){
                                            Toast.makeText(MainActivity.this, "Snackbar的按钮被点击了",
                                                    Toast.LENGTH_LONG).show();
                                        }
                                    }).setActionTextColor(getResources().getColor(R.color.colorPrimary))
                                    .setDuration(5000).show();
                            break;
                        }
                    }
                }
            }
        });

    }

}
