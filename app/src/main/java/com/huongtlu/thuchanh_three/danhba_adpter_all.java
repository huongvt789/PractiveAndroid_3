package com.huongtlu.thuchanh_three;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by BEHUONG on 3/13/2018.
 */

public class danhba_adpter_all extends BaseAdapter{
    private Context context;
    private int layout;
    private List<danhba_main_all> danhba;

    public danhba_adpter_all(Context context, int layout, List<danhba_main_all> danhba) {
        this.context = context;
        this.layout = layout;
        this.danhba = danhba;
    }

    @Override
    public int getCount() {
        return danhba.size();
    }

    @Override
    public Object getItem(int i) {
        return danhba.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(layout,null);
        TextView txtTen=(TextView) view.findViewById(R.id.txtHT);
        danhba_main_all db=danhba.get(i);
        txtTen.setText(db.getName());
        return view;
    }
}
