package com.cicloeterno.game ;

import java.util.HashMap;
import java.util.Map;

public class MapsH {

    //Registro de personajes usando el nombre como key
    private Map<String, PJS> registroPersonajes;
    
    //Registro para objetos inanimados (idea)
    private Map<String, Object> registroObjetos;
    
    // HashMap que guaarda coords de cada personaje u objeto (idea)
    private Map<String, Object> ubicacionCoords;

    public MapsH() {
        registroPersonajes = new HashMap<>();
        registroObjetos = new HashMap<>();
        ubicacionCoords = new HashMap<>();
    }

    //Agregar personajes
    public void agregarPersonaje(PJS personaje) {
        registroPersonajes.put(personaje.getName(), personaje);
    }

    //Busqueda de personajes
    public PJS obtenerPersonaje(String nombre) {
        return registroPersonajes.get(nombre);
    }

    //Verificador de existencia
    public boolean existePersonaje(String nombre) {
        return registroPersonajes.containsKey(nombre);
    }

    //Eliminar un personaje
    public void eliminarPersonaje(String nombre) {
        registroPersonajes.remove(nombre);
    }

    //"Debug" Muestra todos los personajes
    public void mostrarPersonajes() {
        System.out.println("=== Personajes registrados ===");
        for (Map.Entry<String, PJS> entrada : registroPersonajes.entrySet()) {
            System.out.println("Nombre: " + entrada.getKey() + 
                               " | Vida: " + entrada.getValue().getHp() +
                               " | Vivo: " + entrada.getValue().getIsAlive());
        }
    }
}