package com.tsi.uno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

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
        carta = new CartaUnoRandom();

        Button btnLista = findViewById(R.id.list);

        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListaCartasActivity.class);

//                intent.putStringArrayListExtra("cartasSorteadas", (ArrayList<CartaUno>) cartasUnoSorteadas);
                intent.putExtra("cartasSorteadas", new ArrayList<>(cartasUnoSorteadas));


                startActivity(intent);
            }
        });
    }
    public List<String> listaDeDescricaoCartas(){
        List<String> listaCartas = new ArrayList<>();

        listaCartas.add("Carta Coringa");
        listaCartas.add("Carta +4");

        listaCartas.add("Carta Azul 0");
        listaCartas.add("Carta Azul 1");
        listaCartas.add("Carta Azul 2");
        listaCartas.add("Carta Azul 3");
        listaCartas.add("Carta Azul 4");
        listaCartas.add("Carta Azul 5");
        listaCartas.add("Carta Azul 6");
        listaCartas.add("Carta Azul 7");
        listaCartas.add("Carta Azul 8");
        listaCartas.add("Carta Azul 9");
        listaCartas.add("Carta Azul +2");
        listaCartas.add("Carta Azul Reverse");
        listaCartas.add("Carta Azul Bloqueio");

        listaCartas.add("Carta Verde 0");
        listaCartas.add("Carta Verde 1");
        listaCartas.add("Carta Verde 2");
        listaCartas.add("Carta Verde 3");
        listaCartas.add("Carta Verde 4");
        listaCartas.add("Carta Verde 5");
        listaCartas.add("Carta Verde 6");
        listaCartas.add("Carta Verde 7");
        listaCartas.add("Carta Verde 8");
        listaCartas.add("Carta Verde 9");
        listaCartas.add("Carta Verde +2");
        listaCartas.add("Carta Verde Reverse");
        listaCartas.add("Carta Verde Bloqueio");

        listaCartas.add("Carta Vermelha 0");
        listaCartas.add("Carta Vermelha 1");
        listaCartas.add("Carta Vermelha 2");
        listaCartas.add("Carta Vermelha 3");
        listaCartas.add("Carta Vermelha 4");
        listaCartas.add("Carta Vermelha 5");
        listaCartas.add("Carta Vermelha 6");
        listaCartas.add("Carta Vermelha 7");
        listaCartas.add("Carta Vermelha 8");
        listaCartas.add("Carta Vermelha 9");
        listaCartas.add("Carta Vermelha +2");
        listaCartas.add("Carta Vermelha Reverse");
        listaCartas.add("Carta Vermelha Bloqueio");

        listaCartas.add("Carta Amarela 0");
        listaCartas.add("Carta Amarela 1");
        listaCartas.add("Carta Amarela 2");
        listaCartas.add("Carta Amarela 3");
        listaCartas.add("Carta Amarela 4");
        listaCartas.add("Carta Amarela 5");
        listaCartas.add("Carta Amarela 6");
        listaCartas.add("Carta Amarela 7");
        listaCartas.add("Carta Amarela 8");
        listaCartas.add("Carta Amarela 9");
        listaCartas.add("Carta Amarela +2");
        listaCartas.add("Carta Amarela Reverse");
        listaCartas.add("Carta Amarela Bloqueio");

        return listaCartas;
    }

//    public void sortearCarta(View view) {
//        CartaUno cartaSorteada = carta.selecionarCartaAleatoria();
//        imageView.setImageResource(cartaSorteada.getImagemCarta());
//
//        cartasUnoSorteadas.add(cartaSorteada);
//    }

    public void sortearCarta(View view) {
        CartaUno cartaSorteada = carta.selecionarCartaAleatoria();
        imageView.setImageResource(cartaSorteada.getImagemCarta());

        // Adicionar a carta sorteada ao banco de dados
        long newRowId = cartaSorteada.inserirCartaNoBanco(getApplicationContext());

        if (newRowId != -1) {
            Toast.makeText(this, "Carta adicionada ao banco de dados", Toast.LENGTH_SHORT).show();
            cartasUnoSorteadas.add(cartaSorteada);
        } else {
            Toast.makeText(this, "Erro ao adicionar a carta ao banco de dados", Toast.LENGTH_SHORT).show();
        }
    }
}