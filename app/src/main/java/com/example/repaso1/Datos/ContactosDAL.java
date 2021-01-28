package com.example.repaso1.Datos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ContactosDAL {
    private PersistenciaDatos persistenciaDatos;
    private SQLiteDatabase sql; //comandos SQL
    private Context context; //para el constructor

    public ContactosDAL( Context context) {
        this.context = context;
    }
    public void open(){
        persistenciaDatos = new PersistenciaDatos(context,"PruebaDB", null, 1);
        sql = persistenciaDatos.getReadableDatabase();
    }
    public void close(){
        sql.close();
    }
    public ArrayList<String> select(){
        open();
        ArrayList<String> listaContactos = null;
        try {
            String sqlSelect="SELECT Codigo, Nombre, Apellido, Telefono FROM Contactos";
            Cursor cursor = sql.rawQuery(sqlSelect,null);
            if (cursor.moveToFirst()){
                do {
                    listaContactos.add(cursor.getString(0)+" "+cursor.getString(1)+" "+cursor.getString(2)+" "+
                            cursor.getString(3));
                }while(cursor.moveToNext());
            }
        }catch(Exception ex){
            throw ex;
        }
        finally {
            sql.close();
        }
        return  listaContactos;
    }
}
