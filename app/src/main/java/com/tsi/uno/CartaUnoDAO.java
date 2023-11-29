package com.tsi.uno;

import android.provider.BaseColumns;

public class CartaUnoDAO {
    private CartaUnoDAO() {
    }

    public static class CartaEntry implements BaseColumns {
        public static final String TABLE_NAME = "carta";
        public static final String COLUMN_IMAGEM_CARTA = "imagem_carta";
        public static final String COLUMN_DESCRICAO_CARTA = "descricao_carta";
    }
}
