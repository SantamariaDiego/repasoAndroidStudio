package com.example.repaso1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.repaso1.Datos.ContactosDAL2;
import com.example.repaso1.Entidades.Contacto;

public class addActivity extends AppCompatActivity {
    private EditText et_nombre;
    private EditText et_apellido;
    private EditText et_telefono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        et_nombre=findViewById(R.id.etNombre);
        et_apellido=findViewById(R.id.etApellido);
        et_telefono=findViewById(R.id.etTelefono);
    }

    public void clickAgregar(View view){
        ContactosDAL2 dal = new ContactosDAL2(this);
        dal.open();
        String nombre = et_nombre.getText().toString();
        String apellido =et_apellido.getText().toString();
        String telefono =et_telefono.getText().toString();
        Contacto contacto = new Contacto(0, nombre, apellido, telefono);

        long cantidad = dal.insert(contacto);

        if (cantidad>0){
            Toast.makeText(this,"Contacto agregado",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this,"El contacto no se pudo agregar",Toast.LENGTH_SHORT).show();
        }
        dal.close();

    }
    public void clickRegresar(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}