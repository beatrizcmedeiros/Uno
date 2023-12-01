package com.tsi.uno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.tsi.uno.model.CartaUno;
import com.tsi.uno.model.CartaUnoAdapter;

import java.util.List;

public class ListaCartasActivity extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_lista_cartas);
//
////        ArrayList<String> cartasSorteadas = getIntent().getStringArrayListExtra("cartasSorteadas");
//        List<CartaUno> cartasSorteadas = getIntent().getParcelableArrayListExtra("cartasSorteadas");
//
//        ListView listView = findViewById(R.id.lista);
//
//        if (cartasSorteadas != null && !cartasSorteadas.isEmpty()) {
//            ArrayAdapter<String> adapter = new ArrayAdapter<>(
//                    this, android.R.layout.simple_list_item_1, cartasSorteadas
//            );
//            listView.setAdapter(adapter);
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cartas);

        // Recupere a lista de CartaUno do Intent
        List<CartaUno> cartasSorteadas = (List<CartaUno>) getIntent().getSerializableExtra("cartasSorteadas");

        ListView listView = findViewById(R.id.lista);

        if (cartasSorteadas != null && !cartasSorteadas.isEmpty()) {
            // Crie um adaptador personalizado para exibir a lista de CartaUno
            CartaUnoAdapter adapter = new CartaUnoAdapter(this, cartasSorteadas);

            // Defina o adaptador na ListView
            listView.setAdapter(adapter);
        }
    }


}
