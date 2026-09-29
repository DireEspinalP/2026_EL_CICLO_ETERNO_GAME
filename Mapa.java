package com.cicloeterno.game;

import java.util.HashMap;
import java.util.Map;

//librerái de ArrayList
import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//linea eliminada porque OBjeto ya está en el mismo paquete que Mapa

/**
 * Representa el mapa del juego: una imagen de fondo y una grilla de tiles.
 * Las coordenadas (x, y) de la grilla son coordenadas de TILE.
 */

public class Mapa {

    // Tamaño de cada tile (32*32 px)
    public static final int TAMANO_TILE = 32; 

    // Dimensiones del mundo en píxeles y tiles
    private int anchoMundo;
    private int altoMundo;
    private int columnas;
    private int filas;

    // Imagen de fondo (mapa)
    private Texture fondoBase;


    // Grilla de elementos:
    // String para coordenadas "x,y"
    // Integrer para ID del bloque (ejemplo: 0 = aire)
    private Map<String, Integer> grillaCoordenadas;

    //lista de referencia de objetos
    private ArrayList<Objeto> objetos;

    //Constructor (llamado después de que libGDX haya iniciado)
    public Mapa(String rutaFondoBase) {
        this.fondoBase = new Texture(rutaFondoBase);
        this.grillaCoordenadas = new HashMap<>();

        // Calculo del tamaño de mundo y cantidad de tiles 
        this.anchoMundo = fondoBase.getWidth();
        this.altoMundo = fondoBase.getHeight();
        this.columnas = anchoMundo / TAMANO_TILE;
        this.filas = altoMundo / TAMANO_TILE;

        //Inicialización de la lista objetos
        this.objetos = new ArrayList<>();

        //Log para verificar que el mapa se ha cargado correctamente 
        System.out.println("Mapa: " + anchoMundo + "x" + altoMundo
                + " px -> Grilla de " + columnas + "x" + filas + " tiles");
    }

    // === GETTERS ===
    public int getAnchoMundo() { return anchoMundo; }
    public int getAltoMundo() { return altoMundo; }
    public int getColumnas() { return columnas; }
    public int getFilas() { return filas; }
    public ArrayList<Objeto> getObjetos() { return objetos; }

    // === METODOS PARA LA GRILLA DE ELEMENTOS ===

    //Método para saber si una coordenada de tile está dentro de la grilla
    public boolean esCoordenadaValida(int x, int y) {
        return x >= 0 && x < columnas && y >= 0 && y < filas;
    }

    // Método para agregar un elemento en una coordenada
    public void agregarElemento(int x, int y, int tipoBloque) {
        if (!esCoordenadaValida(x, y)) {
            System.out.println("Coordenada fuera del mapa: " + x + ", " + y );
            return;
        }
        String claveCoordenada = x + "," + y;
        grillaCoordenadas.put(claveCoordenada, tipoBloque);
    }

    // Método para obtener el tipo de bloque en una coordenada
    public int obtenerElemento(int x, int y) {
        if (!esCoordenadaValida(x, y)) {
            return 0; // fuera del mapa se considera aire
        }
        String claveCoordenada = x + "," + y;
        // Si no hay nada en esa coordenada, devuelve 0
        return grillaCoordenadas.getOrDefault(claveCoordenada, 0);
    }

    //Método para evitar posicionar dos objetos distintos en las mismas coordenadas
    public boolean hayObjetoEn(int x, int y) {
        //for-each para recorrer la lista objetos
        for (Objeto o : objetos) {
            if ((o.getPosicionx() == x) && (o.getPosiciony() == y)) {
                return true;
            }
        }
        return false;
    }

    //Método para agregar objeto o
    public void agregarObjeto(Objeto o) {
        //evitar agregar dos objetos en una misma posición
        if (!hayObjetoEn(o.getPosicionx(), o.getPosiciony())) {
            objetos.add(o);
        }
    }

    //Método para remover un objeto
    public boolean removerObjeto(Objeto o) {
       return objetos.remove(o);
    }



    // === RENDERIZADO ===

    // batch.begin() y batch.end() los llama quine invoque este método
    public void render(SpriteBatch batch) {
        if( fondoBase != null ) {
            batch.draw(fondoBase, 0, 0, anchoMundo, altoMundo);
        }
    }

    // Libera la textura de la memoria (llamarlo al cerrar el juego)
    public void dispose(){
        if ( fondoBase != null ) {
            fondoBase.dispose();
        }
    }
}