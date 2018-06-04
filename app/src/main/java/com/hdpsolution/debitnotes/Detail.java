package com.hdpsolution.debitnotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.hdpsolution.debitnotes.model.Data;

import java.util.ArrayList;
import java.util.Date;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent i = getIntent();
        Data data = (Data) i.getSerializableExtra("object");
        Toast.makeText(this, data.getName(), Toast.LENGTH_SHORT).show();
    }
}
