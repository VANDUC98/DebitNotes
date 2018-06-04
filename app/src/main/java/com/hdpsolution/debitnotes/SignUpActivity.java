package com.hdpsolution.debitnotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.rengwuxian.materialedittext.MaterialEditText;

public class SignUpActivity extends AppCompatActivity {
    private LinearLayout lnInput;
    private MaterialEditText edtNumberPhone;
    private MaterialEditText edtName;
    private MaterialEditText edtPassWord;
    private MaterialEditText edtRePassword;
    private Button btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        lnInput = (LinearLayout) findViewById(R.id.lnInput);
        edtName = (MaterialEditText) findViewById(R.id.edtName);
        edtPassWord = (MaterialEditText) findViewById(R.id.edtPassWord);
        edtRePassword = (MaterialEditText) findViewById(R.id.edtRePassword);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
