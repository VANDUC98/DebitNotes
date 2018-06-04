package com.hdpsolution.debitnotes;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rengwuxian.materialedittext.MaterialEditText;

public class LoginActivity extends AppCompatActivity {
    private LinearLayout lnInput;
    private MaterialEditText edtNumberPhone;
    private MaterialEditText edtPassWord;
    private Button btnSignIn;
    private TextView tv;
    private TextView tvSignUp;
    private TextView tvAppName;
    private TextView tvSlogan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        lnInput = (LinearLayout) findViewById(R.id.lnInput);
        edtPassWord = (MaterialEditText) findViewById(R.id.edtPassWord);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        tvAppName=findViewById(R.id.tvAppName);
        tvSlogan=findViewById(R.id.tvSlogan);
        Typeface face=Typeface.createFromAsset(getAssets(), "font/NABILA.TTF");
        tvAppName.setTypeface(face);
        tvSlogan.setTypeface(face);
        tv = (TextView) findViewById(R.id.tv);
        tvSignUp = (TextView) findViewById(R.id.tvSignUp);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,Home.class);
                startActivity(intent);
            }
        });
        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
