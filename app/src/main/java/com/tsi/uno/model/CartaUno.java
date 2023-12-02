package com.tsi.uno.model;

import android.os.Parcel;
import android.os.Parcelable;

public class CartaUno implements Parcelable {
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

    // Métodos necessários para implementar Parcelable

    protected CartaUno(Parcel in) {
        id = in.readLong();
        imgCarta = in.readInt();
        dscCarta = in.readString();
    }

    public static final Creator<CartaUno> CREATOR = new Creator<CartaUno>() {
        @Override
        public CartaUno createFromParcel(Parcel in) {
            return new CartaUno(in);
        }

        @Override
        public CartaUno[] newArray(int size) {
            return new CartaUno[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeInt(imgCarta);
        dest.writeString(dscCarta);
    }
}
