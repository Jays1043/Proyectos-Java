/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.umg.recursividad;

/**
 *
 * @author jays1043
 */
public class Recursividad {

    public static void main(String[] args) {
        System.out.println(InvertirNum(123));
        System.out.println(DivisionPorRestas(12, 3));
        System.out.println(fibonacci(8));
        System.out.println(SumaDigitos(23));
    }

    public static void printNums(int num) {

        if (num > 0) {
            System.out.println(num);
            printNums(num - 1);
        }
    }

    public static int factorial(int num) {
        if (num < 0) {
            return 0;
        }
        if (num == 0 || num == 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }

    public static int InvertirNum(int num) {
        int ultimo;
        int resto;
        int tamanioResto;

        if (num < 10) {
            return num;
        } else {
            ultimo = num % 10;
            resto = num / 10;
            tamanioResto = (int) Math.log10(resto) + 1;

            return ultimo * (int) Math.pow(10, tamanioResto) + InvertirNum(resto);
        }
    }

    public static int DivisionPorRestas(int dividendo, int divisor) {
        if (dividendo < divisor) {
            return 0;
        } else {
            return 1 + DivisionPorRestas(dividendo - divisor, divisor);
        }
    }

    public static int fibonacci(int num) {
        if (num <= 1) {
            return num;
        } else {
            return fibonacci(num - 1) + fibonacci(num - 2);
        }
    }

    public static int SumaDigitos(int num) {
        int ultimo;
        int resto;

        if (num < 10) {
            return num;
        } else {
            ultimo = num % 10;
            resto = num / 10;
            return ultimo + SumaDigitos(resto);
        }
    }
}
