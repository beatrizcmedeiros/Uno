package com.tsi.uno;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoDeDados extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "cartauno.db";
    private static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + CartaUnoDAO.CartaEntry.TABLE_NAME + " (" +
                    CartaUnoDAO.CartaEntry._ID + " INTEGER PRIMARY KEY," +
                    CartaUnoDAO.CartaEntry.COLUMN_IMAGEM_CARTA + " INTEGER," +
                    CartaUnoDAO.CartaEntry.COLUMN_DESCRICAO_CARTA + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + CartaUnoDAO.CartaEntry.TABLE_NAME;

    public BancoDeDados(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
