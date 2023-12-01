package com.tsi.uno.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class CartaUnoDAO extends SQLiteOpenHelper {

    // Defina o nome do banco de dados e a versão
    private static final String DATABASE_NAME = "carta_uno.db";
    private static final int DATABASE_VERSION = 1;

    // Construtor
    public CartaUnoDAO(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Implemente os métodos onCreate e onUpgrade da SQLiteOpenHelper
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crie a tabela do banco de dados aqui
        db.execSQL("CREATE TABLE IF NOT EXISTS " + CartaEntry.TABLE_NAME + " (" +
                CartaEntry._ID + " INTEGER PRIMARY KEY," +
                CartaEntry.COLUMN_IMAGEM + " INTEGER," +
                CartaEntry.COLUMN_DESCRICAO + " TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Atualize a tabela do banco de dados aqui, se necessário
    }

    public static class CartaEntry implements BaseColumns {
        public static final String TABLE_NAME = "cartas";
        public static final String COLUMN_IMAGEM = "imagem";
        public static final String COLUMN_DESCRICAO = "descricao";
    }
}
