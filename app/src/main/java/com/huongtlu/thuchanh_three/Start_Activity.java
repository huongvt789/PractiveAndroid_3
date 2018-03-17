package com.huongtlu.thuchanh_three;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Start_Activity extends AppCompatActivity implements View.OnClickListener {
    TextView txtA, txtB, txttong;

    Button btnsend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_);
        txtA = findViewById(R.id.txtA);
        txtB = findViewById(R.id.txtB);
        txttong = findViewById(R.id.txtTong);
        btnsend = (Button) findViewById(R.id.btnSet);
        btnsend.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        Intent i = new Intent(this, recive2_Activity.class);
        startActivityForResult(i, 1001);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1001) {
            if (resultCode == RESULT_OK) {
                String a = data.getStringExtra("SoA");
                String b = data.getStringExtra("SoB");
                txtA.setText("So A: " + a);
                txtB.setText("So B: " + b);
                txttong.setText("Tong: " + (Integer.parseInt(a) + Integer.parseInt(b)));
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Tra ve thanh cong", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Tra ve that bai", Toast.LENGTH_LONG).show();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}