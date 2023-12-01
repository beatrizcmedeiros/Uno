package com.tsi.uno.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tsi.uno.R;

import java.util.List;

public class CartaUnoAdapter extends BaseAdapter {

    private Context context;
    private List<CartaUno> cartasUno;

    public CartaUnoAdapter(Context context, List<CartaUno> cartasUno) {
        this.context = context;
        this.cartasUno = cartasUno;
    }

    @Override
    public int getCount() {
        return cartasUno.size();
    }

    @Override
    public Object getItem(int position) {
        return cartasUno.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_list_item, parent, false);
        }

        // Obtém a carta para a posição atual
        CartaUno carta = cartasUno.get(position);

        // Atualize a ImageView com a imagem da carta
        ImageView imageView = convertView.findViewById(R.id.imageView);
        imageView.setImageResource(carta.getImagemCarta());

        // Atualize o TextView com a descrição da carta
        TextView textView = convertView.findViewById(R.id.textView);
        textView.setText(carta.getDescricaoCarta());

        return convertView;
    }
}