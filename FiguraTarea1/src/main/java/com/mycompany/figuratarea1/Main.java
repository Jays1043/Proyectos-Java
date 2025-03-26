/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.figuratarea1;

/**
 *
 * @author aleja
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Circulo circulo = new Circulo(45.2);
        Rectangulo rectangulo = new Rectangulo(12, 8.5);
        Triangulo triangulo = new Triangulo(6.7, 15);
        Cuadrado cuadrado = new Cuadrado(4);

        System.out.println("Área del círculo: " + circulo.calcularArea());
        System.out.println("Área del rectángulo: " + rectangulo.calcularArea());
        System.out.println("Área del triángulo: " + triangulo.calcularArea());
        System.out.println("Área del cuadrado: " + cuadrado.calcularArea());
    }
}
