package com.example.slide1.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.slide1.DbHelper.MyDbHelper;
import com.example.slide1.model.CatModel;

import java.util.ArrayList;

public class CatDAO {

    MyDbHelper dbHelper;
    SQLiteDatabase db;

    public CatDAO(Context context) {
        dbHelper = new MyDbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    //lay danh sach the loai
    public ArrayList<CatModel> getList() {
        ArrayList<CatModel> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM tb_cat ORDER BY name ASC", null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst(); //Trả về đầu hàng
            do {
                CatModel o = new CatModel();
                o.setId(cursor.getInt(0));//cach 2: cursor.getInt(c.getColumnIndex"id")--lấy theo theo tên cột
//                o.getName(cursor.getString(1));
                o.setName(cursor.getString(1));
                list.add(o);
            } while (cursor.moveToNext());
        } else {
            Log.d("zzzz", "getlist: Khong co du lieu");
        }
        return list;
    }


    //Hàm thêm mới
    public int addRow(CatModel catModel) {
        ContentValues values = new ContentValues();
        values.put("name", catModel.getName());
        long ketqua = db.insert("tb_cat", null, values);
        return (int) ketqua;//nếu ketqua > 0 thì thêm ok và id là ketqua
        //yêu cầu id phải là tự tăng(autoincrement)

    }

    //Hàm update
    public int updateRow(CatModel catModel) {
        ContentValues values = new ContentValues();
        values.put("name", catModel.getName());
        String[] dieuKien = new String[]{String.valueOf(catModel.getId())};
        return db.update("tb_cat", values, "id=?", dieuKien);

    }
//Hàm delete
    public int deleteRow(CatModel catModel) {

        String[] dieuKien = new String[]{String.valueOf(catModel.getId())};
        return db.delete("tb_cat", "id=?", dieuKien);

    }


    //get all/ lay danh sach Cat
//    public ArrayList<CatModel> getAll(){
//        ArrayList<CatModel> listcat = new ArrayList<>();
//        Cursor c = db.rawQuery("SELECT * FROM tb_cat",null);
//
//        if(c!=null && c.getCount()>0){
//            c.moveToFirst();
//            do{
//                //thứ tự cột : 0 = id, 1= name
//                int id_cat= c.getInt(0);
//                String name = c.getString(1);
//
//                CatModel catModel = new CatModel(id_cat,name);
//                listcat.add(catModel);
//
//            }while(c.moveToNext());
//        }
//        return listcat;
//    }

}
