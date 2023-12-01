package com.tsi.uno.model;

import com.tsi.uno.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CartaUnoRandom {
    List<CartaUno> listaDeCartas;
    public CartaUnoRandom() {
        this.listaDeCartas = listaDeCartas();
    }
    public List<CartaUno> listaDeCartas(){
        List<CartaUno> listaCartas = new ArrayList<>();

        listaCartas.add(new CartaUno(R.drawable.uno_card_wildchange, "Carta Coringa"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_wilddraw4, "Carta +4"));

        listaCartas.add(new CartaUno(R.drawable.uno_card_blue0, "Carta Azul 0"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_blue1, "Carta Azul 1"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_blue2, "Carta Azul 2"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_blue3, "Carta Azul 3"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_blue4, "Carta Azul 4"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_blue5, "Carta Azul 5"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_blue6, "Carta Azul 6"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_blue7, "Carta Azul 7"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_blue8, "Carta Azul 8"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_blue9, "Carta Azul 9"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_bluedraw2, "Carta Azul +2"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_bluereverse, "Carta Azul Reverse"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_blueskip, "Carta Azul Bloqueio"));

        listaCartas.add(new CartaUno(R.drawable.uno_card_green0, "Carta Verde 0"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_green1, "Carta Verde 1"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_green2, "Carta Verde 2"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_green3, "Carta Verde 3"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_green4, "Carta Verde 4"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_green5, "Carta Verde 5"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_green6, "Carta Verde 6"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_green7, "Carta Verde 7"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_green8, "Carta Verde 8"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_green9, "Carta Verde 9"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_greendraw2, "Carta Verde +2"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_greenreverse, "Carta Verde Reverse"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_greenskip, "Carta Verde Bloqueio"));

        listaCartas.add(new CartaUno(R.drawable.uno_card_red0, "Carta Vermelha 0"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_red1, "Carta Vermelha 1"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_red2, "Carta Vermelha 2"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_red3, "Carta Vermelha 3"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_red4, "Carta Vermelha 4"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_red5, "Carta Vermelha 5"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_red6, "Carta Vermelha 6"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_red7, "Carta Vermelha 7"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_red8, "Carta Vermelha 8"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_red9, "Carta Vermelha 9"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_reddraw2, "Carta Vermelha +2"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_redreverse, "Carta Vermelha Reverse"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_redskip, "Carta Vermelha Bloqueio"));

        listaCartas.add(new CartaUno(R.drawable.uno_card_yellow0, "Carta Amarela 0"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_yellow1, "Carta Amarela 1"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_yellow2, "Carta Amarela 2"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_yellow3, "Carta Amarela 3"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_yellow4, "Carta Amarela 4"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_yellow5, "Carta Amarela 5"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_yellow6, "Carta Amarela 6"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_yellow7, "Carta Amarela 7"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_yellow8, "Carta Amarela 8"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_yellow9, "Carta Amarela 9"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_yellow2, "Carta Amarela +2"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_yellowreverse, "Carta Amarela Reverse"));
        listaCartas.add(new CartaUno(R.drawable.uno_card_yellowskip, "Carta Amarela Bloqueio"));

        return listaCartas;
    }

    public CartaUno selecionarCartaAleatoria() {
        Random random = new Random();
        int cartaSorteada = random.nextInt(listaDeCartas.size());
        return listaDeCartas.get(cartaSorteada);
    }

    public String selecionarDescricaoCartaAleatoria() {
        CartaUno cartaSorteada = selecionarCartaAleatoria();
        return cartaSorteada.getDescricaoCarta();
    }
}//CartaUnoRandom
