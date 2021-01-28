package com.example.repaso1.Datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class PersistenciaDatos extends SQLiteOpenHelper {
    private final String SQL_CREATE_TABLE_CONTACTOS ="CREATE TABLE Contactos (Codigo INTEGER PRIMARY KEY AUTOINCREMENT, Nombre TEXT, Apellido TEXT, Telefono TEXT)";

    public PersistenciaDatos(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_CONTACTOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Contactos");
        db.execSQL(SQL_CREATE_TABLE_CONTACTOS);
    }
}
