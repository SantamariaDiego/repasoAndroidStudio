package com.example.repaso1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.repaso1.Datos.ContactosDAL;
import com.example.repaso1.Datos.ContactosDAL2;
import com.example.repaso1.Datos.PersistenciaDatos;

import java.util.ArrayList;
import java.util.List;

public class listarActivity extends AppCompatActivity {
    private ListView lv_datos;
    private ArrayList<String> listaContactos;
    private ArrayAdapter<String> adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        ContactosDAL2 contactosDAL2 = new ContactosDAL2(this);
        contactosDAL2.open2();
        lv_datos = findViewById(R.id.lvContactos);
        //listaContactos= contactosDAL2.selectContactos();

        adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaContactos);

        SimpleAdapter adapter = new SimpleAdapter(this, contactosDAL2.selectContactos(),
                android.R.layout.simple_list_item_2,
                new String[] {"Linea1", "Linea2"},
                new int[] {android.R.id.text1,
                        android.R.id.text2});


        lv_datos.setAdapter(adapter);
    }

}