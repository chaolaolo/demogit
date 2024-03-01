package com.example.slide1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.slide1.DAO.CatDAO;
import com.example.slide1.model.CatModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    CatDAO catDAO;
    ArrayList<CatModel> listCat;

    Button btnCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        //demo 01: tạo DAO và lấy danh sách ghi ra bảng
//        catDAO = new CatDAO(MainActivity.this);
//
//        ///ví dụ thêm mới 1 bản ghi cho bảng gì đo
//        CatModel objCat = new CatModel("o to");
//        int id_moi = catDAO.addRow(objCat);
//        if (id_moi > 0) {
//            Log.d("zzz", "onCreate: Them ok, id moi = " + id_moi);
//
//        } else {
//            Log.d("zzz", "onCreate: thêm lỗi, có thể là sai dữ liệu");
//        }
//        //sau thêm xong, chạy lại để hiện
//
//
//        listCat = catDAO.getList();//lay du lieu
//        Log.d("zzz", "onCreate: so luong ban ghi tb_cat = " + listCat.size());
//
//
//        //trước khi chạy cần vào file MyDbHelper để insert dữ liệu vào bảng
//        // hiển thị thì tạo adapter để hiển thị
//
//        for (int i = 0; i < listCat.size(); i++) {
//            CatModel tmp = listCat.get(i);
//
//            Log.d("zzz", "Tên thứ " + i + "==> " + tmp.getName());
//        }


        btnCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Cat_Activity.class);
                startActivity(intent);
            }
        });

    }
}