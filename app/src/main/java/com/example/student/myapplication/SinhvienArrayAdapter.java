package com.example.student.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SinhvienArrayAdapter extends BaseAdapter {
    Context myContext;
    int myLayout;
    List<SinhVien> myLstSinhVien;

    public SinhvienArrayAdapter(Context myContext, int myLayout, List<SinhVien> myLstSinhVien) {
        this.myContext = myContext;
        this.myLayout = myLayout;
        this.myLstSinhVien = myLstSinhVien;
    }

    private class ViewHolder {
        private TextView tv_ma1, tv_ten1, tv_mon1;
        private ImageView img_cus1;
    }

    @Override
    public int getCount() {
        return myLstSinhVien.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(myLayout, null);
            holder = new ViewHolder();
            holder.tv_ma1 = view.findViewById(R.id.tv_ma);
            holder.tv_ten1 = view.findViewById(R.id.tv_ten);
            holder.tv_mon1 = view.findViewById(R.id.tv_mon);
            holder.img_cus1 = view.findViewById(R.id.img_cus);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tv_ma1.setText(myLstSinhVien.get(i).getMa());
        holder.tv_ten1.setText(myLstSinhVien.get(i).getTen());
        holder.tv_mon1.setText(myLstSinhVien.get(i).getMon());
        holder.img_cus1.setImageResource(myLstSinhVien.get(i).getImg_id());
        return view;

    }
}
