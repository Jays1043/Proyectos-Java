/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.album;

/**
 *
 * @author aleja
 */
class Album {

    String nombre;
    Foto inicio;

    public Album(String nombre) {
        this.nombre = nombre;
    }

    public void agregarFoto(String ruta) {
        Foto nuevaFoto = new Foto(ruta);
        if (inicio == null) {
            inicio = nuevaFoto;
            inicio.siguiente = inicio;
            inicio.anterior = inicio;
        } else {
            Foto ultima = inicio.anterior;
            ultima.siguiente = nuevaFoto;
            nuevaFoto.anterior = ultima;
            nuevaFoto.siguiente = inicio;
            inicio.anterior = nuevaFoto;
        }
    }
}
