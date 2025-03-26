package com.mycompany.laboratorio1;

import java.util.Scanner;

/**
 *
 * @author aleja
 */
public class Laboratorio1 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int puesto, dpi;
        double horas, ordinario, extra, descuento, total;
        String nombre;
        System.out.println("Seleccione su puesto:");
        System.out.println("1. Manager");
        System.out.println("2. Ejecutivo");
        System.out.println("3. Programador");
        System.out.println("4. Secretaria");
        
        puesto=leer.nextInt();
        switch (puesto){
            case 1:
                System.out.println("Usted ha seleccionado Manager.");
                System.out.println("Ingrese su nombre:");
                nombre=leer.next();
                System.out.println("Ingrese su DPI:");
                dpi=leer.nextInt();
                System.out.println("Ingrese las horas trabajadas:");
                horas=leer.nextDouble();

                ordinario = 160*250;
                System.out.println("Salario ordinario: \t"  + ordinario);
                extra = (horas - 160) *1.5*250;
                System.out.println("Salario horas extra: \t" + extra);
                descuento = ordinario * 0.07;
                System.out.println("Descuento: \t \t" + descuento);
                total = (ordinario + extra) - descuento;
                System.out.println("Total: \t \t \t" + total);
            break;
            case 2:   
                System.out.println("Usted ha seleccionado Ejecutivo.");
                System.out.println("Ingrese su nombre:");
                nombre=leer.next();
                System.out.println("Ingrese su DPI:");
                dpi=leer.nextInt();
                System.out.println("Ingrese las horas trabajadas:");
                horas=leer.nextDouble();

                ordinario = 160*200;
                System.out.println("Salario ordinario: \t"  + ordinario);
                extra = 0;
                System.out.println("Salario horas extra: \t" + extra);
                descuento = ordinario * 0.07;
                System.out.println("Descuento: \t \t" + descuento);
                total = (ordinario + extra) - descuento;
                System.out.println("Total: \t \t \t" + total);
            break;
            case 3:   
                System.out.println("Usted ha seleccionado Programador.");
                System.out.println("Ingrese su nombre:");
                nombre=leer.next();
                System.out.println("Ingrese su DPI:");
                dpi=leer.nextInt();
                System.out.println("Ingrese las horas trabajadas:");
                horas=leer.nextDouble();

                ordinario = 160*100;
                System.out.println("Salario ordinario: \t"  + ordinario);
                extra = (horas - 160) *100;;
                System.out.println("Salario horas extra: \t" + extra);
                descuento = ordinario * 0.05;
                System.out.println("Descuento: \t \t" + descuento);
                total = (ordinario + extra) - descuento;
                System.out.println("Total: \t \t \t" + total);
            break;
            case 4:
                System.out.println("Usted ha seleccionado Secretaria.");
                System.out.println("Ingrese su nombre:");
                nombre=leer.next();
                System.out.println("Ingrese su DPI:");
                dpi=leer.nextInt();
                System.out.println("Ingrese las horas trabajadas:");
                horas=leer.nextDouble();
                
                System.out.println();
                ordinario = 160*25;
                System.out.println("Salario ordinario: \t"  + ordinario);
                extra = (horas - 160) *25;;
                System.out.println("Salario horas extra: \t" + extra);
                descuento = 0;
                System.out.println("Descuento: \t \t" + descuento);
                total = (ordinario + extra) - descuento;
                System.out.println("Total: \t \t \t" + total);
            break;
            default:
                System.out.println("Valor incorrecto.");
        }
    }
}
