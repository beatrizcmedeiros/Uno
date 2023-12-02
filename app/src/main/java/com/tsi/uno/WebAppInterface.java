package com.tsi.uno;

import android.content.Context;
import android.webkit.JavascriptInterface;

import androidx.appcompat.app.AppCompatActivity;

import com.tsi.uno.MainActivity;
import com.tsi.uno.model.CartaUno;

import java.util.List;

public class WebAppInterface {
    private Context mContext;
    private List<CartaUno> cartasSorteadas;

    public WebAppInterface(Context context, List<CartaUno> cartasSorteadas) {
        this.mContext = context;
        this.cartasSorteadas = cartasSorteadas;
    }

    @JavascriptInterface
    public void sortearCarta() {
        if (mContext instanceof AppCompatActivity) {
            ((AppCompatActivity) mContext).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    // Chame o método sortearCarta da MainActivity no thread principal
                    ((MainActivity) mContext).sortearCarta();
                }
            });
        }
    }
}
