package com.example.repaso1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.repaso1.Datos.ContactosDAL2;
import com.example.repaso1.Entidades.Contacto;

import java.util.List;
import java.util.Map;

public class EditarActivity extends AppCompatActivity {
Map<String, String> datosContacto;
    private EditText et_nombre;
    private EditText et_apellido;
    private EditText et_telefono;
    private int idContacto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        datosContacto = (Map<String, String>) getIntent().getSerializableExtra("ObjetoData");

        et_nombre=findViewById(R.id.etNombre);
        et_apellido=findViewById(R.id.etApellido);
        et_telefono=findViewById(R.id.etTelefono);

        et_nombre.setText(datosContacto.get("Linea1").split(" ")[1]);
        et_apellido.setText(datosContacto.get("Linea1").split(" ")[2]);
        et_telefono.setText(datosContacto.get("Linea2"));
        idContacto = Integer.valueOf(datosContacto.get("Linea1").split(" ")[0]);
    }

    public void clickEliminar(View view){
        ContactosDAL2 contactosDAL2 = new ContactosDAL2(this);
        contactosDAL2.open();
        int contador = contactosDAL2.delete(idContacto);
        if(contador > 0){
            Toast.makeText(this,"Contacto eliminado",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(this,"No se pudo eliminar",Toast.LENGTH_SHORT).show();
        }
    }
    public void clickActualizar(View view){
        Contacto contacto = new Contacto(idContacto, et_nombre.getText().toString(), et_apellido.getText().toString(),  et_telefono.getText().toString());
        ContactosDAL2 contactosDAL2 = new ContactosDAL2(this);
        contactosDAL2.open();
        int contador = contactosDAL2.update(contacto);
        if(contador > 0){
            Toast.makeText(this,"Contacto actualizado",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(this,"No se pudo actualizar",Toast.LENGTH_SHORT).show();
        }
    }
}