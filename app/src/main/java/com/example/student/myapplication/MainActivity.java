package com.example.student.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText edtma, edtten;
    Spinner spmon;
    ListView lst;
    ArrayList<SinhVien> arrSv;
    SinhvienArrayAdapter arrayAdapterLs = null;
    int vitri = -1;
    public static final int GOIDIMASUA = 300;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        arrSv = SinhVienModel.getListSinhvienDemo();
        arrayAdapterLs = new SinhvienArrayAdapter( this,R.layout.layout_cus_lst,arrSv);
        lst.setAdapter(arrayAdapterLs);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                vitri = i;
                SinhVien sv = arrSv.get(i);
                edtma.setText(sv.getMa());
                edtten.setText(sv.getTen());
                spmon.setSelection(vitri);

            }
        });
        //Spinner
        List<String> list = new ArrayList<String>();
        list.add("Tin hoc");
        list.add("Lap trinh");
        list.add("May tinh");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spmon.setAdapter(dataAdapter);
    }

    private void anhxa() {
        edtma = findViewById(R.id.edt_ma);
        edtten = findViewById(R.id.edt_ten);
        spmon = findViewById(R.id.sp_mon);
        lst = findViewById(R.id.lst_item);
    }

    public void Add(View view) {
        SinhVien sv = new SinhVien();
        sv.setMa(edtma.getText().toString());
        sv.setTen(edtten.getText().toString());
        sv.setMon(spmon.getSelectedItem().toString());
        sv.setImg_id(R.drawable.ic_flag_thailand);

        if(arrSv.contains(sv)){
            Toast.makeText(this,"Ban Khong Duoc Nhap Trùng Noi Dung",Toast.LENGTH_LONG).show();
            return;
        }
        Boolean kq = SinhVienModel.addSinhVien(sv);
        if (kq)
            arrayAdapterLs.notifyDataSetChanged();
    }

    public void Delete(View view) {
        if (vitri < 0 ){
            Toast.makeText(this,"Chưa chọn item muốn xóa!",Toast.LENGTH_SHORT).show();
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Bạn có chắc muốn xóa?");
        builder.setNegativeButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SinhVienModel.removeSinhVien(vitri);
                arrayAdapterLs.notifyDataSetChanged();
                vitri = -1;
                edtma.setText("");
                edtten.setText("");
            }
        });
        builder.setPositiveButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void Modify(View view) {
        if (vitri < 0 ){
            Toast.makeText(this,"Chưa chọn item muốn sửa!",Toast.LENGTH_SHORT).show();
            return;
        }else {
            SinhVien svSua = arrSv.get(vitri);
            Intent intent = new Intent(MainActivity.this,XuLySVActivity.class);
            intent.putExtra("SINHVIENSUA", svSua);
            startActivityForResult(intent,GOIDIMASUA);
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GOIDIMASUA) {
            switch (resultCode) {
                case 200:
                    arrSv = SinhVienModel.getListSinhvienDemo();
                    arrayAdapterLs = new SinhvienArrayAdapter( this,R.layout.layout_cus_lst,arrSv);
                    lst.setAdapter(arrayAdapterLs);
                    break;
            }
        }
    }
}
