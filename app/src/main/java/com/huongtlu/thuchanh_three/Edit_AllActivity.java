package com.huongtlu.thuchanh_three;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Edit_AllActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edt1;
    Button btn1,btn2,btn3;
    danhba_main_all db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__all);
        btn1 = (Button) findViewById(R.id.btnEdit);
        btn2 = (Button) findViewById(R.id.btnDelete);
        btn3 = (Button) findViewById(R.id.btnCancel);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        Intent i = getIntent();
        String name = i.getStringExtra("edit");

    }
    @Override
    public void onClick(View view) {
        int id=view.getId();
        if(id==R.id.btnEdit){
         Intent i=new Intent();
         i.putExtra("new",edt1.getText().toString());
         setResult(Main_All_Activity.EDIT,i);
         finish();
        }
        if(id==R.id.btnDelete){
            setResult(Main_All_Activity.DELETE,null);
            finish();
        }
        if (id==R.id.btnCancel)
            finish();
    }
}

