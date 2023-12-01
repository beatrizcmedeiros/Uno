package com.tsi.uno.model;

import java.io.Serializable;

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

}//CartaUno
