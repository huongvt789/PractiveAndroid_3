package com.huongtlu.thuchanh_three;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main_All_Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lshovaten;
    ArrayList<danhba_main_all> arr = new ArrayList<>();
    danhba_adpter_all adpter_all;
    Dialog dialog;
    Button add;
    int index;
    public static final int EDIT = 1;
    public static final int DELETE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__all_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
        add = (Button) findViewById(R.id.btnAdd);
        lshovaten = (ListView) findViewById(R.id.lsDanhSach);
        arr.add(new danhba_main_all("Vũ Thị Hường"));
        arr.add(new danhba_main_all( "Nguyễn Văn An"));
        arr.add(new danhba_main_all( "Tranafv Văn Bình"));
        adpter_all = new danhba_adpter_all(this, R.layout.view_ls_all, arr);
        lshovaten.setAdapter(adpter_all);
        lshovaten.setOnItemClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menuAdd) {
            DialogThem();
        }
        return super.onOptionsItemSelected(item);
    }
    private void DialogThem() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_custom);
        final EditText editText = dialog.findViewById(R.id.edtAdd);
        Button btnAdd = dialog.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tennd = editText.getText().toString();
                if (equals("")) {
                    Toast.makeText(Main_All_Activity.this, "Vui long nhao lai", Toast.LENGTH_SHORT).show();
                } else {
                    arr.add(new danhba_main_all(tennd));
                    adpter_all = new danhba_adpter_all(Main_All_Activity.this, R.layout.view_ls_all, arr);
                    lshovaten.setAdapter(adpter_all);
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        index = i;
        Intent intent = new Intent(this, Edit_AllActivity.class);
        intent.putExtra("edit", arr.get(i).getName());
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100) {
            if (resultCode == EDIT) {
                danhba_main_all db = new danhba_main_all();
                db.setName(data.getStringExtra("new"));
                arr.set(index,db);
                adpter_all.notifyDataSetChanged();
            }

            if (resultCode==DELETE){
                arr.remove(index);
                adpter_all.notifyDataSetChanged();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
