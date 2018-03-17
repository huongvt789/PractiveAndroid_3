package com.huongtlu.thuchanh_three;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class recive2_Activity extends AppCompatActivity implements View.OnClickListener {
    EditText edt1, edt2;
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recive2_);
        edt1 = (EditText) findViewById(R.id.edtA);
        edt2 = (EditText) findViewById(R.id.edtB);
        btn1 = (Button) findViewById(R.id.btnGui);
        btn2 = (Button) findViewById(R.id.btnThoat);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(Start_Activity.RESULT_CANCELED);
                finish();
            }
        });
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent();
        i.putExtra("SoA", edt1.getText().toString());
        i.putExtra("SoB", edt2.getText().toString());
        setResult(Start_Activity.RESULT_OK, i);
        finish();
    }
}
