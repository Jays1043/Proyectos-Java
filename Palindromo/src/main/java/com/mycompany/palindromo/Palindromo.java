package com.mycompany.palindromo;
import java.util.Scanner;
public class Palindromo {

    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        String palabra;
        char [] palindromo;
        int izq, der;
        System.out.println("Ingrese una palabra para saber si es un palindromo:");
        palabra = leer.nextLine();
        palindromo = palabra.toCharArray();
        izq = 0;
        der = palindromo.length -1;
        
        while(izq < der){
            if(palindromo[izq] == palindromo[der]){
                der--;
                izq++;
            }else {
                System.out.println("La palabra no es un palindromo.");
                break;
            }
        }
        if(izq == der){
            System.out.println("La palabra es un palindromo.");
        }
    }
}
