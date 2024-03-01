package com.example.slide1.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.slide1.R;
import com.example.slide1.model.CatModel;

import java.util.ArrayList;

public class CatAdapter extends BaseAdapter {

    private Context context;
   protected ArrayList<CatModel> listcat;

    public CatAdapter(Context context, ArrayList<CatModel> listcat) {
        this.context = context;
        this.listcat = listcat;
    }

    @Override
    public int getCount() {
        return listcat.size();
    }

    @Override
    public Object getItem(int position) {
        return listcat.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listcat.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        if (convertView == null) {
            row = View.inflate(context, R.layout.layout_listview_item, null);
        } else {
            row = convertView;
            //lay du lieu
            CatModel catModel = listcat.get(position);

            TextView txt_idcat = row.findViewById(R.id.txt_idcat);
            TextView txt_name = row.findViewById(R.id.txt_name);
            //gán dữ liệu
            txt_idcat.setText(String.valueOf(catModel.getId()));
            txt_name.setText(catModel.getName());
        }
        return row;
    }
}
