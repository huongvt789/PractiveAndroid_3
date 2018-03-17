package com.huongtlu.thuchanh_three;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ImplicitActivity extends AppCompatActivity implements View.OnClickListener {

    Button btngd, btnmw,btngs,btnmm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);
        Anhxa();
        btngd.setOnClickListener(this);
        btnmw.setOnClickListener(this);
        btngs.setOnClickListener(this);
        btnmm.setOnClickListener(this);
    }

    private void Anhxa() {
        btngd=(Button) findViewById(R.id.btnCall);
        btnmw=(Button) findViewById(R.id.btnOpenWeb);
        btngs=(Button) findViewById(R.id.btnSend);
        btnmm=(Button) findViewById(R.id.btnOpenMap);
    }


    @Override
    public void onClick(View view) {
        int id=view.getId();

        //Truy cập ứng dụng gọi điện
        if(id==R.id.btnCall){
            switch (id){
                case R.id.btnCall:
                doCalling();
                break;
            default:
                break;
            }

        }
        if(id==R.id.btnSend){
            switch (id){
                case R.id.btnSend:
                    doSendMessage();
                    break;
                    default:
                        break;
            }
        }

        //Mở trình duyệt web
        if(id==R.id.btnOpenWeb){
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://suckhoe.vnexpress.net/"));
            startActivity(intent);
        }
    }

    private void doSendMessage() {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("sms:"+"0971861496"));
        startActivity(intent);
    }

    private void doCalling() {
        Intent intent=new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:09876543"));
        startActivity(intent);
    }
}
