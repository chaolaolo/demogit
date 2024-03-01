package com.example.slide1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.slide1.DAO.CatDAO;
import com.example.slide1.adapter.CatAdapter;
import com.example.slide1.model.CatModel;

import java.util.ArrayList;

public class Cat_Activity extends AppCompatActivity {

    EditText edt_namecat;
    Button btn_add, btn_update, btn_delete;
    ListView lv_listcat;
    ArrayList<CatModel> listcat;
    CatAdapter catAdapter;
    CatDAO catDAO;
    CatModel catModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat);

        edt_namecat = findViewById(R.id.edt_namecat);
        btn_add = findViewById(R.id.btn_add);
        btn_update = findViewById(R.id.btn_update);
        btn_delete = findViewById(R.id.btn_delete);
        lv_listcat = findViewById(R.id.lv_listcat);

        catDAO = new CatDAO(this);
        listcat = catDAO.getList();
        catAdapter = new CatAdapter(this, listcat);
        lv_listcat.setAdapter(catAdapter);


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edt_namecat.getText().toString();

                CatModel catModel1 = new CatModel(name);
                int id_moi = catDAO.addRow(catModel1);
                if (id_moi > 0) {
                    listcat.clear();
                    listcat.addAll(catDAO.getList());
                    catAdapter.notifyDataSetChanged();
                    Toast.makeText(Cat_Activity.this, "add OK", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Cat_Activity.this, "add false", Toast.LENGTH_SHORT).show();

                }
            }
        });



    }
}