package com.example.repaso1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.repaso1.Datos.ContactosDAL;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lv_datos;
    private ArrayList<String> listaContactos;
    private ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Comienzo
        ContactosDAL claseRead = new ContactosDAL(this);
        lv_datos= findViewById(R.id.lv_datos);
        listaContactos = claseRead.select();
        adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaContactos);
        lv_datos.setAdapter(adaptador);
    }
}