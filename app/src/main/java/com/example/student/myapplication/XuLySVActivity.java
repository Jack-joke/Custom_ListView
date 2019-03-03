package com.example.student.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class XuLySVActivity extends AppCompatActivity {
    EditText edtma, edtten;
    Spinner spmon;
    ArrayList<SinhVien> arrSv;
    public  static  final  int GOITRALAI=200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xu_ly_sv);
        anhxa();
        Intent insv = getIntent();
        Intent intent = getIntent();
        if (intent.getSerializableExtra("SINHVIENSUA") != null) {
            SinhVien sv = (SinhVien) insv.getSerializableExtra("SINHVIENSUA");
            edtma.setText(sv.getMa());
            edtten.setText(sv.getTen());
            //spmon.setSelection(sv.getMon());
            //spmon.getSelectedItemPosition(Integer.parseInt(sv.getMon()));
        }
    }
    private void anhxa() {
        edtma = findViewById(R.id.edt_ma);
        edtten = findViewById(R.id.edt_ten);
        spmon = findViewById(R.id.sp_mon);
    }

    public void Sua(View view) {
        Intent insv = getIntent();
        SinhVien sv = (SinhVien) insv.getSerializableExtra("SINHVIENSUA");
        //SinhVienModel.updateSinhVien(R.drawable.ic_flag_thailand, sv.setTen(edtten.getText().toString()),sv.setMon(spmon.getSelectedItem().toString()));
        sv.setTen(edtten.getText().toString());
        sv.setMon(spmon.getSelectedItem().toString());
        sv.setImg_id(R.drawable.ic_flag_singapore);
        Toast.makeText(this,"Cập nhật thành công!",Toast.LENGTH_SHORT).show();
        Intent inTraLai = new Intent();
        setResult(GOITRALAI,inTraLai );
        finish();
    }
}
