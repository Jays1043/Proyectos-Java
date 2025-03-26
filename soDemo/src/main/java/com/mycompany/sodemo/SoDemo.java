/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.sodemo;

import java.util.concurrent.Semaphore;

/**
 *
 * @author aleja
 */
public class SoDemo {
    private static int contador = 0;

    public static synchronized void incrementar() {
        contador++;
    }

    public static synchronized void decrementar() {
        contador--;
    }

    public static void main(String[] args) {
        Thread incrementador = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                incrementar();
            }
        });

        Thread decrementador = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                decrementar();
            }
        });

        incrementador.start();
        decrementador.start();

        try {
            incrementador.join();
            decrementador.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Valor final del contador: " + contador);
    }
}
