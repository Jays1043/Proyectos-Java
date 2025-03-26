/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.hilos;

/**
 *
 * @author aleja
 */
public class Hilos {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new NumberPrinter("Thread 1"));
        Thread thread2 = new Thread(new NumberPrinter("Thread 2"));
        thread1.start();
        thread2.start();
    }
}

class NumberPrinter implements Runnable {

    private String threadName;

    public NumberPrinter(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(threadName + ": " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
