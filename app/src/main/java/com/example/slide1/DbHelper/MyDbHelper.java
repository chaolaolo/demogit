package com.example.slide1.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDbHelper extends SQLiteOpenHelper {

    static String DB_NAME = "ql_banHang";
    static int DB_VERSION = 1;

    public MyDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Tạo các bảng ở đây:
        //bang 1
        String tblCat = "CREATE TABLE tb_cat ( id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT UNIQUE NOT NULL );";
        sqLiteDatabase.execSQL(tblCat); //xong bang 1
        //bang 2
        String tblProduct = "CREATE TABLE tb_product ( id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, price INTEGER DEFAULT (0) NOT NULL,id_cat INTEGER NOT NULL CONSTRAINT fk_pro_cat REFERENCES tb_cat (id) );";
        sqLiteDatabase.execSQL(tblProduct);//xong bang 2


        ////Thêm dòng dữ liệu
        String insert_cat = "INSERT INTO tb_cat(name) VALUES ('Tivi'),('Điều hòa'),('Tủ lạnh');";
        sqLiteDatabase.execSQL(insert_cat);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //Cập nhật
//        if (i < i1) {
//            //xoa bang
//            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_product");
//            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_cat");
//
//        }

    }
}
