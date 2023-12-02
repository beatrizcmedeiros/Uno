package com.tsi.uno;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.tsi.uno.model.CartaUno;
import com.tsi.uno.model.CartaUnoRandom;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CartaUnoRandom carta;
    private WebView webView;

    List<CartaUno> cartasUnoSorteadas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carta = new CartaUnoRandom(this);
        webView = findViewById(R.id.webView);

        // Configurar as configurações da WebView
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.addJavascriptInterface(new WebAppInterface(this, cartasUnoSorteadas), "Android");


        // Carregar o conteúdo HTML na WebView
        carregarPaginaHtml();
    }

    public void sortearCarta() {
        CartaUno cartaSorteada = carta.selecionarCartaAleatoria();
        cartasUnoSorteadas.add(cartaSorteada);

        // Carregar a imagem na WebView após sortear uma carta
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                carregarImagemNaWebView(cartaSorteada.getImagemCarta());
            }
        });
    }

    private void carregarPaginaHtml() {
        // Limpar o cache da WebView
        webView.clearCache(true);

        // Carregar a string HTML na WebView a partir do arquivo 'index.html'
        String htmlPath = "file:///android_asset/web/index.html";
        webView.loadUrl(htmlPath);

        // Adicionar uma interface JavaScript para se comunicar com o código Java
        webView.addJavascriptInterface(new WebAppInterface(this, cartasUnoSorteadas), "Android");
    }

    private void carregarImagemNaWebView(final int imagemResId) {
        if (webView != null) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    // Carregue o conteúdo HTML e CSS
                    webView.loadUrl("file:///android_asset/web/carta.html");
                }
            });
        }
    }



}
