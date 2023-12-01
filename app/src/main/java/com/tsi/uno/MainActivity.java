package com.tsi.uno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.tsi.uno.model.CartaUno;
import com.tsi.uno.model.CartaUnoRandom;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private CartaUnoRandom carta;

    List<CartaUno> cartasUnoSorteadas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imgCarta);
        carta = new CartaUnoRandom(this);

        Button btnLista = findViewById(R.id.list);

        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListaCartasActivity.class);
                intent.putExtra("cartasSorteadas", new ArrayList<>(cartasUnoSorteadas));
                startActivity(intent);
            }
        });
    }

    public void sortearCarta(View view) {
        CartaUno cartaSorteada = carta.selecionarCartaAleatoria();
        imageView.setImageResource(cartaSorteada.getImagemCarta());

        cartasUnoSorteadas.add(cartaSorteada);
    }
}
