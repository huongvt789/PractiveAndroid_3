package com.huongtlu.thuchanh_three;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class recive_Activity extends AppCompatActivity {
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recive_);
        txt = findViewById(R.id.txtNhan);
        Intent i = getIntent();
        String s = i.getStringExtra("info");
        txt.setText("Hello " + s);
    }
}
