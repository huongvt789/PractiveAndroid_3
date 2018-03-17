package com.huongtlu.thuchanh_three;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ExplicitActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edt;
Button btnsend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit);
        edt = findViewById(R.id.edtInsert);
        btnsend=(Button) findViewById(R.id.btnsend1);
        btnsend.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, recive_Activity.class);
        i.putExtra("info", edt.getText().toString());
        startActivity(i);
    }
}
