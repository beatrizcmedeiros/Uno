package com.tsi.uno;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CartaUno implements Serializable {
    private final int imgCarta;
    private final String dscCarta;

    public CartaUno(int imgCarta, String dscCarta) {
        this.imgCarta = imgCarta;
        this.dscCarta = dscCarta;
    }

    public int getImagemCarta() {
        return imgCarta;
    }

    public String getDescricaoCarta() {
        return dscCarta;
    }

    // Método para inserir uma carta no banco de dados
    public long inserirCartaNoBanco(Context context) {
        BancoDeDados dbHelper = new BancoDeDados(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CartaUnoDAO.CartaEntry.COLUMN_IMAGEM_CARTA, imgCarta);
        values.put(CartaUnoDAO.CartaEntry.COLUMN_DESCRICAO_CARTA, dscCarta);

        long newRowId = -1;

        try {
            newRowId = db.insert(CartaUnoDAO.CartaEntry.TABLE_NAME, null, values);
        } catch (SQLException e) {
            // Trate qualquer exceção ao inserir no banco de dados
            e.printStackTrace();
        } finally {
            db.close();
        }

        return newRowId;
    }

    // Método para recuperar todas as cartas do banco de dados
    public static List<CartaUno> obterTodasAsCartasDoBanco(Context context) {
        List<CartaUno> cartas = new ArrayList<>();
        BancoDeDados dbHelper = new BancoDeDados(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                CartaUnoDAO.CartaEntry._ID,
                CartaUnoDAO.CartaEntry.COLUMN_IMAGEM_CARTA,
                CartaUnoDAO.CartaEntry.COLUMN_DESCRICAO_CARTA
        };

        try (Cursor cursor = db.query(
                CartaUnoDAO.CartaEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        )) {
            while (cursor.moveToNext()) {
                int imagemCarta = cursor.getInt(cursor.getColumnIndexOrThrow(CartaUnoDAO.CartaEntry.COLUMN_IMAGEM_CARTA));
                String descricaoCarta = cursor.getString(cursor.getColumnIndexOrThrow(CartaUnoDAO.CartaEntry.COLUMN_DESCRICAO_CARTA));

                cartas.add(new CartaUno(imagemCarta, descricaoCarta));
            }
        } catch (SQLException e) {
            // Trate qualquer exceção ao ler do banco de dados
            e.printStackTrace();
        } finally {
            db.close();
        }

        return cartas;
    }
}//CartaUno
