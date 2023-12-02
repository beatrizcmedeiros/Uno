package com.tsi.uno;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import com.tsi.uno.dao.CartaUnoDAO;
import com.tsi.uno.model.CartaUno;
import com.tsi.uno.model.CartaUnoAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListaCartasActivity extends AppCompatActivity {

    private CartaUnoDAO bancoDeDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cartas);

        bancoDeDados = new CartaUnoDAO(this);

        // Obtenha as cartas do Intent
        List<CartaUno> cartasSorteadas = getIntent().getParcelableArrayListExtra("cartasSorteadas");

        ListView listView = findViewById(R.id.lista);

        if (cartasSorteadas != null && !cartasSorteadas.isEmpty()) {
            // Crie um adaptador personalizado para exibir a lista de CartaUno
            CartaUnoAdapter adapter = new CartaUnoAdapter(this, cartasSorteadas);

            // Defina o adaptador na ListView
            listView.setAdapter(adapter);
        }
    }

    private List<CartaUno> obterCartasDoBanco() {
        SQLiteDatabase db = bancoDeDados.getReadableDatabase();

        String[] projection = {
                CartaUnoDAO.CartaEntry._ID,
                CartaUnoDAO.CartaEntry.COLUMN_IMAGEM,
                CartaUnoDAO.CartaEntry.COLUMN_DESCRICAO
        };

        Cursor cursor = db.query(
                CartaUnoDAO.CartaEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        List<CartaUno> cartas = new ArrayList<>();

        while (cursor.moveToNext()) {
            long id = cursor.getLong(cursor.getColumnIndexOrThrow(CartaUnoDAO.CartaEntry._ID));
            int imagem = cursor.getInt(cursor.getColumnIndexOrThrow(CartaUnoDAO.CartaEntry.COLUMN_IMAGEM));
            String descricao = cursor.getString(cursor.getColumnIndexOrThrow(CartaUnoDAO.CartaEntry.COLUMN_DESCRICAO));

            CartaUno carta = new CartaUno(id, imagem, descricao);
            cartas.add(carta);
        }

        cursor.close();
        db.close();

        return cartas;
    }
}
