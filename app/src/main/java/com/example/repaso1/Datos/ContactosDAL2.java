package com.example.repaso1.Datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.repaso1.Entidades.Contacto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactosDAL2 {
    private PersistenciaDatos persistenciaDatos;
    private SQLiteDatabase sql; //comandos SQL
    private Context context; //para el constructor

    public ContactosDAL2(Context context) {
        this.context = context;
    }
    public void open(){
        persistenciaDatos = new PersistenciaDatos(context,"PruebaDB", null, 1);
        sql = persistenciaDatos.getReadableDatabase();
    }
    public void open2(){
        persistenciaDatos = new PersistenciaDatos(context,"PruebaDB", null, 1);
        sql = persistenciaDatos.getWritableDatabase();
    }
    public void close(){
        sql.close();
    }
    public long insert(Contacto contacto){
        long count = 0;
        // open();
        try {
            ContentValues row = new ContentValues();
            row.put("Nombre",contacto.getNombre());
            row.put("Apellido",contacto.getApellido());
            row.put("Telefono", contacto.getTelefono());
            count=sql.insert("Contactos",null,row);
        }catch(Exception ex){
            throw ex;
        }
        finally {
           close();
        }
        return count;
    }
    public List<Map<String, String>> selectContactos() {
        String select="SELECT Codigo, Nombre, Apellido, Telefono FROM Contactos";
        //ArrayList<String> listaContactos = new ArrayList<String>();
        List<Map<String, String>> listaContactos = new ArrayList<Map<String, String>>();
        Cursor cursor = sql.rawQuery(select,null);

        if (cursor.moveToFirst()){
            do {
                //listaContactos.add(cursor.getString(0)+" "+cursor.getString(1)+" "+cursor.getString(2)+" "+cursor.getString(3));
                Map<String, String> datum = new HashMap<>();
                datum.put("Linea1", cursor.getString(0)+" "+cursor.getString(1)+" "+cursor.getString(2));
                datum.put("Linea2", cursor.getString(3));
                listaContactos.add(datum);
            }while(cursor.moveToNext());
        }
        return listaContactos;
    }
}
