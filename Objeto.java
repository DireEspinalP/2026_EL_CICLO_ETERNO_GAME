package com.cicloeterno.game;

public class Objeto {
    private int x, y;
    private TipoObjeto tipo;
    private boolean bloqueaPaso;

    public Objeto (int x, int y, TipoObjeto tipo, boolean bloqueaPaso) {
        this.x = x;
        this.y = y;
        this.tipo = tipo;
        this.bloqueaPaso = bloqueaPaso;
    }

    public int getPosicionx() { return x; }
    public int getPosiciony() { return y; }
    public TipoObjeto getTipo() { return tipo; }
    public boolean isBloqueaPaso() { return bloqueaPaso; }

}
