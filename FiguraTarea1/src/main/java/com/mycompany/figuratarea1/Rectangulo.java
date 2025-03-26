/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.figuratarea1;

/**
 *
 * @author aleja
 */
public class Rectangulo implements Figura{

    private double ladoA;
    private double ladoB;

    public Rectangulo(double ladoA, double ladoB) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
    }

    @Override
    public double calcularArea() {
        return ladoA * ladoB;
    }
}
