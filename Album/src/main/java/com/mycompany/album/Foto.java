/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.album;

/**
 *
 * @author aleja
 */
class Foto {

    String ruta;
    Foto siguiente;
    Foto anterior;

    public Foto(String ruta) {
        this.ruta = ruta;
    }
}
