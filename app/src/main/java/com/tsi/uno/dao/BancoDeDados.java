package com.tsi.uno.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoDeDados extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "carta_uno.db";
    private static final int DATABASE_VERSION = 1;

    // Defina o esquema da tabela
    private static final String SQL_CREATE_CARTA_TABLE =
            "CREATE TABLE " + CartaUnoDAO.CartaEntry.TABLE_NAME + " (" +
                    CartaUnoDAO.CartaEntry._ID + " INTEGER PRIMARY KEY," +
                    CartaUnoDAO.CartaEntry.COLUMN_IMAGEM + " INTEGER," +
                    CartaUnoDAO.CartaEntry.COLUMN_DESCRICAO + " TEXT)";

    private static final String SQL_DELETE_CARTA_TABLE =
            "DROP TABLE IF EXISTS " + CartaUnoDAO.CartaEntry.TABLE_NAME;

    public BancoDeDados(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_CARTA_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_CARTA_TABLE);
        onCreate(db);
    }
}
