package com.tsi.uno;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.webkit.JavascriptInterface;

import androidx.appcompat.app.AppCompatActivity;

import com.tsi.uno.MainActivity;
import com.tsi.uno.model.CartaUno;

import java.util.ArrayList;
import java.util.List;

public class WebAppInterface {
    private AppCompatActivity mActivity;
    private List<CartaUno> cartasSorteadas;

    public WebAppInterface(AppCompatActivity activity, List<CartaUno> cartasSorteadas) {
        this.mActivity = activity;
        this.cartasSorteadas = cartasSorteadas;
    }

    @JavascriptInterface
    public void sortearCarta() {
        if (mActivity != null) {
            mActivity.runOnUiThread(() -> {
                if (mActivity instanceof MainActivity) {
                    ((MainActivity) mActivity).sortearCarta();
                }
            });
        }
    }

    @JavascriptInterface
    public void listarCartasSorteadas() {
        if (mActivity != null) {
            mActivity.runOnUiThread(() -> {
                // Inicie a ListaCartasActivity e passe as cartas sorteadas como extras
                Intent intent = new Intent(mActivity, ListaCartasActivity.class);
                intent.putParcelableArrayListExtra("cartasSorteadas", (ArrayList<? extends Parcelable>) new ArrayList<>(cartasSorteadas));
                mActivity.startActivity(intent);
            });
        }
    }
}

