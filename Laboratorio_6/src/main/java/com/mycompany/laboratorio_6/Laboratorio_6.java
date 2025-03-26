/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.laboratorio_6;

import java.util.Scanner;

/**
 *
 * @author aleja
 */
public class Laboratorio_6 {

    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("Seleccione una opcion:");
            System.out.println("1. Expresión regular c((a|b)(ba|c))*");
            System.out.println("2. Salir");
            opcion = consola.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Ingrese cadena:");
                    String entrada = consola.next();
                    Automata automata = new Automata();
                    System.out.println(automata.parsear(entrada));
                }
            }
        } while (opcion > 0 && opcion < 6);

    }
}
