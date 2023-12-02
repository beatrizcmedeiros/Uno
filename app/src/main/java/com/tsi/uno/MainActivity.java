package com.tsi.uno;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

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
        webView.setWebContentsDebuggingEnabled(true);


        // Carregar o conteúdo HTML na WebView
        carregarPaginaHtml();
    }

    public void sortearCarta() {
        CartaUno cartaSorteada = carta.selecionarCartaAleatoria();
        cartasUnoSorteadas.add(cartaSorteada);

//        Toast.makeText(this, cartaSorteada.getImagemCarta(), Toast.LENGTH_SHORT).show();

        // Carregar o conteúdo HTML na WebView após sortear uma carta
        carregarPaginaHtml();

        // Carregar a imagem da carta sorteada na WebView
        carregarImagemNaWebView(cartaSorteada.getImagemCarta());
    }

    public void listarCartasSorteadas(List<CartaUno> cartasSorteadas) {
        // Inicie a ListaCartasActivity e passe as cartas sorteadas como extras
        Intent intent = new Intent(this, ListaCartasActivity.class);
        intent.putParcelableArrayListExtra("cartasSorteadas", (ArrayList<? extends Parcelable>) new ArrayList<CartaUno>(cartasSorteadas));
        startActivity(intent);
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

    private void carregarImagemNaWebView(int imagemResId) {
        // Carregar a string HTML na WebView a partir do arquivo 'carta.html'
        webView.loadUrl("file:///android_asset/web/carta.html");

        // Adicionar uma interface JavaScript para se comunicar com o código Java
        webView.addJavascriptInterface(new WebAppInterface(this, cartasUnoSorteadas), "Android");

        // Aguarde um tempo de 500ms antes de chamar a função JavaScript
        webView.postDelayed(() -> {
            String jsFunction = "exibirCartaSorteada('" + imagemResId + "')";
            webView.evaluateJavascript(jsFunction, null);
        }, 500);
    }
}
