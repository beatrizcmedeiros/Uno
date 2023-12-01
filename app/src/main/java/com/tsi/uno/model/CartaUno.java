package com.tsi.uno.model;

import java.io.Serializable;

public class CartaUno implements Serializable {
    private long id;
    private final int imgCarta;
    private final String dscCarta;

    public CartaUno(long id, int imgCarta, String dscCarta) {
        this.id = id;
        this.imgCarta = imgCarta;
        this.dscCarta = dscCarta;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getImagemCarta() {
        return imgCarta;
    }
    public String getDescricaoCarta() {
        return dscCarta;
    }

}//CartaUno
