package com.mycompany.nmayorburbuja;

import java.util.Scanner;

/**
 *
 * @author aleja
 */
public class NmayorBurbuja {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tamano;
        System.out.println("Ingrese el tamaño del arreglo: ");
        tamano = sc.nextInt();

        int ArregloN[] = new int[tamano];

        for (int i = 0; i < ArregloN.length; i++) {
            System.out.println("Ingrese el numero " + (i + 1) + ": ");
            ArregloN[i] = sc.nextInt();
        }

        for (int i = 0; i < ArregloN.length - 1; i++) {
            for (int j = 0; j < ArregloN.length - 1; j++) {
                if (ArregloN[j] < ArregloN[j + 1]) {
                    int temp = ArregloN[j + 1];
                    ArregloN[j + 1] = ArregloN[j];
                    ArregloN[j] = temp;
                }
            }
        }

        for (int i = 0; i < ArregloN.length; i++) {
            System.out.print("--> " + ArregloN[i] + "\n");
        }
    }
}
