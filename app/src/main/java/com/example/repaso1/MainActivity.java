package com.example.repaso1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.repaso1.Datos.ContactosDAL;
import com.example.repaso1.Datos.ContactosDAL2;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lv_datos;
    private ArrayList<String> listaContactos;
    private ArrayAdapter<String> adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    public void clickInsertar(View view){
        Intent intent = new Intent(this,addActivity.class);
        startActivity(intent);
    }
    public void clickListar(View view){
        Intent intent = new Intent(this,listarActivity.class);
        startActivity(intent);
    }
}